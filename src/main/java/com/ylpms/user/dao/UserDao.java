package com.ylpms.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ylpms.too.StringTool;
import com.ylpms.too.Table;
import com.ylpms.user.entity.User;
@Mapper // 标志为 Mybatis 的 Mapper
public interface UserDao {

	
    @SelectProvider(type=TutorDynaSqlProvider.class,  
    		method="findUserListSql")  
    List<User> findUserList(User user,Table table);
    
    @SelectProvider(type=TutorDynaSqlProvider.class,  
    		method="findUsercount") 
    int findUsercount(User user,Table table);
    
    @Select("select * from t_b_user where id = #{id} and userType = 0")  
    User findUserById(@Param("id")int id);
    
    @Select("select * from t_b_area ")  
    ArrayList<HashMap<String, Object>> findAreaAll();
    
    @Select("select * from t_b_user where moblie = #{moblie} and userType = 0 limit 1")  
    User findUserByMoblie(@Param("moblie")String moblie);
    
    @Select("select * from t_b_user where password = #{user.password} and moblie = #{user.moblie} and userType = 0 limit 1")  
    User findUserByLogin(@Param("user")User user);
    
    @Insert("Insert into t_b_user (entity,owner,introduce,address,contacts,moblie,wechat,economytype,organizationtype,SICcode,"
    		+ "staff,scale,scope,industries,products,value,city,county,town,areacode,lon,lat,userType,password) "
    		+ "VALUES ("
    		+ "#{user.entity},#{user.owner},#{user.introduce},#{user.address},#{user.contacts},#{user.moblie},#{user.wechat},#{user.economytype},#{user.organizationtype},#{user.SICcode},"
    		+"#{user.staff},#{user.scale},#{user.scope},#{user.industries},#{user.products},#{user.value},#{user.city},#{user.county},#{user.town},#{user.areacode},#{user.lon},#{user.lat},"
    		+ "#{user.userType},#{user.password})")
    int saveUser(@Param("user")User user);
    
    @UpdateProvider(type=TutorDynaSqlProvider.class,  
    		method="updateUserById") 
    int updateUserById(User entity);
    
    @Update("UPDATE t_b_user SET password=#{user.password}  WHERE moblie =#{user.moblie} and userType = 0 ") 
    int resetPassword(@Param("user")User entity);
    
    
    /**
     * 内部类 编写动态sql
     * @author Administrator
     *
     */
    public class TutorDynaSqlProvider{  
    	
    	//通用SQL
    	String usertysq = "select t4.* from  t_s_base_user t1 inner join t_s_user_org t2 on "
    			+ "t1.ID = t2.user_id inner join t_b_area_depart t3 on t2.org_id = t3.departid "
    			+ "inner join t_b_user t4 on position(t3.areacode in t4.areacode) where "
    			+ " t4.del_flg = 0 ";
    	
        public String findUserListSql(User user,Table table)  { 
        	
        	StringBuilder sql = new StringBuilder();
        	int ks = table.getLimit() * (table.getPage()-1);
        	//计算起始位置
        	if(ks < 0) {
        		ks = 0;
        	}
        	sql.append(usertysq);
        	if(!StringTool.isNotNull(user.getAreacode())) user.setAreacode("-----");;
        	sql.append(" and t1.username = '"+user.getAreacode()+"'");
        	if(user.getUserType()!=null)sql.append(" and t4.userType = '" + user.getUserType() + "'");
        	if(user.getEntity()!=null && !"".equals(user.getEntity()))sql.append(" and t4.entity = '" + user.getEntity() + "'");
        	if(user.getOwner()!=null && !"".equals(user.getOwner()))sql.append(" and t4.owner = '"+ user.getOwner() + "'");
        	if(user.getContacts()!=null && !"".equals(user.getContacts()))sql.append(" and t4.contacts = '"+ user.getContacts() + "'");
        	
			sql.append(" ORDER BY id desc limit "+ ks + "," + table.getLimit() + ";");
        	return  sql.toString();
        }  
        
        public String findUsercount(User user,Table table)  { 
        	
        	StringBuilder sql = new StringBuilder();
        	sql.append("select count(*) count from (");
        	sql.append(usertysq);
        	if(!StringTool.isNotNull(user.getAreacode())) user.setAreacode("-----");;
        	sql.append(" and t1.username = '"+user.getAreacode()+"'");
        	if(user.getUserType()!=null)sql.append(" and t4.userType = '" + user.getUserType() + "'");
        	if(user.getEntity()!=null && !"".equals(user.getEntity()))sql.append(" and t4.entity = '" + user.getEntity() + "'");
        	if(user.getOwner()!=null && !"".equals(user.getOwner()))sql.append(" and t4.owner = '"+ user.getOwner() + "'");
        	if(user.getContacts()!=null && !"".equals(user.getContacts()))sql.append(" and t4.contacts = '"+ user.getContacts() + "'");
        	
        	sql.append(") a");
        	return  sql.toString();
        }
        
        /**
         * 
        * @Title: updateUserById 
        * @Description: 修改 用户审核信息
        * @param @param map
        * @param @return    设定文件 
        * @return String    返回类型 
        * @throws
         */
        public String updateUserById(User entity)  { 
        	StringBuilder sql = new StringBuilder();
        	sql.append("UPDATE t_b_user SET ");
        	
        	if(StringTool.isNotNull(entity.getEntity()))sql.append("entity='"+entity.getEntity()+"',");
        	if(StringTool.isNotNull(entity.getOwner()))sql.append("owner='"+entity.getOwner()+"',");
        	if(StringTool.isNotNull(entity.getIntroduce()))sql.append("introduce='"+entity.getIntroduce()+"',");
        	if(StringTool.isNotNull(entity.getAddress()))sql.append("address='"+entity.getAddress()+"',");
        	if(StringTool.isNotNull(entity.getContacts()))sql.append("contacts='"+entity.getContacts()+"',");
        	if(StringTool.isNotNull(entity.getMoblie()))sql.append("moblie='"+entity.getMoblie()+"',");
        	if(StringTool.isNotNull(entity.getWechat()))sql.append("wechat='"+entity.getWechat()+"',");
        	if(StringTool.isNotNull(entity.getPassword()))sql.append("password='"+entity.getPassword()+"',");
        	if(StringTool.isNotNull(entity.getEconomytype()))sql.append("economytype='"+entity.getEconomytype()+"',");
        	if(StringTool.isNotNull(entity.getOrganizationtype()))sql.append("organizationtype='"+entity.getOrganizationtype()+"',");
        	if(StringTool.isNotNull(entity.getSICcode()))sql.append("SICcode='"+entity.getSICcode()+"',");
        	if(StringTool.isNotNull(entity.getStaff()))sql.append("staff='"+entity.getStaff()+"',");
        	if(StringTool.isNotNull(entity.getScale()))sql.append("scale='"+entity.getScale()+"',");
        	if(StringTool.isNotNull(entity.getScope()))sql.append("scope='"+entity.getScope()+"',");
        	if(StringTool.isNotNull(entity.getIndustries()))sql.append("industries='"+entity.getIndustries()+"',");
        	if(StringTool.isNotNull(entity.getProducts()))sql.append("products='"+entity.getProducts()+"',");
        	if(StringTool.isNotNull(entity.getValue()))sql.append("value='"+entity.getValue()+"',");
        	if(StringTool.isNotNull(entity.getCity()))sql.append("city='"+entity.getCity()+"',");
        	if(StringTool.isNotNull(entity.getCounty()))sql.append("county='"+entity.getCounty()+"',");
        	if(StringTool.isNotNull(entity.getTown()))sql.append("town='"+entity.getTown()+"',");
        	if(StringTool.isNotNull(entity.getAreacode()))sql.append("areacode='"+entity.getAreacode()+"',");
        	if(StringTool.isNotNull(entity.getLon()))sql.append("lon='"+entity.getLon()+"',");
        	if(StringTool.isNotNull(entity.getLat()))sql.append("lat='"+entity.getLat()+"',");
        	if(StringTool.isNotNull(entity.getDel_flg()))sql.append("del_flg='"+entity.getDel_flg()+"',");
        	if(entity.getUserType() !=null)sql.append("userType='"+entity.getUserType()+"',");

        	String sql1 = sql.toString().substring(0,sql.toString().length() - 1);
        	sql1 = sql1 + " WHERE id = " + entity.getId();
        	 
        	return  sql1;
        }
        
        
    }  
    
}
