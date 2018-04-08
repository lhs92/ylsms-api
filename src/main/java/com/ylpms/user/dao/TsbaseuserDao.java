package com.ylpms.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ylpms.user.entity.TsbaseUser;

@Mapper // 标志为 Mybatis 的 Mapper
public interface TsbaseuserDao {

	@SelectProvider(type=TutorDynaSqlProvider.class,  
	method="findUser") 
	TsbaseUser findUserById(TsbaseUser user);
	
	
	/**
	 * 
	* @Title: findUserById 
	* @Description: 正则匹配集合数据
	* @param @param idlist
	* @param @return    设定文件 
	* @return ArrayList<TsbaseUser>    返回类型 
	* @throws
	 */
	@Select("select * from t_s_base_user where id REGEXP #{idlist}")  
	List<TsbaseUser> findUserListByIds(@Param("idlist")String idlist);
	
	 /**
     * 内部类 编写动态sql
     * @author Administrator
     *
     */
    public class TutorDynaSqlProvider{  
    	
        public String findUser(TsbaseUser user)  { 
        	StringBuilder sql = new StringBuilder();
        	sql.append("select * from t_s_base_user where 1 = 1");
        	if(user.getID() != null )sql.append(" and ID = #{ID}");
        	if(user.getUsername() != null )sql.append(" and realname = #{username}");
        	if(user.getMobilePhone() != null )sql.append(" and mobilePhone = #{mobilePhone}");
        	
        	return  sql.toString();
        }
        
        
    }  
}
