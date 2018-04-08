package com.ylpms.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.ylpms.too.Table;
import com.ylpms.user.entity.Tbuserloginlog;
import com.ylpms.user.entity.Vuserdetailsifno;

@Mapper // 标志为 Mybatis 的 Mapper
public interface TbuserloginlogDao {

	@Insert("INSERT INTO t_b_user_login_log (areacod,loginType,userId,userName,areaname,time) VALUES "
			+ "(#{areacod},#{loginType},#{userId},#{userName},#{areaname},#{time});")  
	int save(@Param("areacod")String areacod,
			@Param("areaname")String areaname,
			@Param("loginType")String loginType,
			@Param("userId")String userId,
			@Param("userName")String userName,
			@Param("time")String time);

	@SelectProvider(type=TutorDynaSqlProvider.class,  
	method="getVuserdetailsifno")  
	Vuserdetailsifno getVuserdetailsifno(Tbuserloginlog user);
	
	@SelectProvider(type=TutorDynaSqlProvider.class,  
    		method="findUserListSql")  
    List<Tbuserloginlog> findUserList(Tbuserloginlog user,Table table,String kscxtime,String jscxtime);
    
    @SelectProvider(type=TutorDynaSqlProvider.class,  
    		method="findUsercount") 
    int findUsercount(Tbuserloginlog user,Table table,String kscxtime,String jscxtime);
	
	 /**
     * 内部类 编写动态sql
     * @author Administrator
     *
     */
    public class TutorDynaSqlProvider{  
    	
    	//通用SQL
    	String usertysq = "select id,userId,areaname,userName,areacod,loginType,max(time) time,count(1) AS counts from t_b_user_login_log where userName !='管理员'";
    	
    	 public String findUserListSql(Tbuserloginlog user,Table table,String kscxtime,String jscxtime)  { 
         	
         	StringBuilder sql = new StringBuilder();
         	int ks = table.getLimit() * (table.getPage()-1);
         	//计算起始位置
         	if(ks < 0) {
         		ks = 0;
         	}
         	sql.append(usertysq);
         	if(user.getLoginType()!=null && !"".equals(user.getLoginType()))sql.append(" and loginType = '" + user.getLoginType() + "'");
         	if(user.getUserName()!=null && !"".equals(user.getUserName()))sql.append(" and userName like '"+ user.getUserName() + "%'");
         	if(kscxtime!=null && !"".equals(kscxtime))sql.append(" and time >= '"+ kscxtime + "'");
         	if(jscxtime!=null && !"".equals(jscxtime))sql.append(" and time <= '"+ jscxtime + "'");
         	if(user.getAreaname()!=null && !"".equals(user.getAreaname()))sql.append(" and areaname like '"+ user.getAreaname() + "%'");
         	sql.append(" GROUP BY  userId,loginType");
 			sql.append(" limit "+ ks + "," + table.getLimit() + ";");
         	return  sql.toString();
         }  
    	 
    	
    	 public String findUsercount(Tbuserloginlog user,Table table,String kscxtime,String jscxtime)  { 
         	
         	StringBuilder sql = new StringBuilder();
         	sql.append("select count(*) count from (");
         	sql.append(usertysq);
         	if(user.getLoginType()!=null && !"".equals(user.getLoginType()))sql.append(" and loginType = '" + user.getLoginType() + "'");
         	if(user.getUserName()!=null && !"".equals(user.getUserName()))sql.append(" and userName like '"+ user.getUserName() + "%'");
         	if(kscxtime!=null && !"".equals(kscxtime))sql.append(" and time >= '"+ kscxtime + "'");
         	if(jscxtime!=null && !"".equals(jscxtime))sql.append(" and time <= '"+ jscxtime + "'");
         	if(user.getAreaname()!=null && !"".equals(user.getAreaname()))sql.append(" and areaname like '"+ user.getAreaname() + "%'");
         	sql.append(" GROUP BY  userId,loginType");
         	sql.append(") a");
         	return  sql.toString();
         }
    	 
    	 public String getVuserdetailsifno(Tbuserloginlog user)  { 
          	StringBuilder sql = new StringBuilder();
          	sql.append("select * from v_userdetailsifno where ID = '" + user.getUserId() + "'");
          	return  sql.toString();
          }
    	
    }

}
