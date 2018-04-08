package com.ylpms.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ylpms.mysql.config.TargetDataSource;
import com.ylpms.too.StringTool;
import com.ylpms.too.Table;
import com.ylpms.user.dao.TbuserloginlogDao;
import com.ylpms.user.dao.UserDao;
import com.ylpms.user.entity.User;
@Service
public class UserService{

	@Resource
	UserDao userDao;
	
	@Autowired
	TbuserloginlogDao tbuserloginlogDao;
	
	//redis 缓存
	@Resource
	private RedisTemplate<String, User> redisTemplate;
	
    //log4j2 日子管理
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());  

    /**
     * 
    * @Title: finduserlist 
    * @Description: 获取外部用户 信息列表
    * @param @param table
    * @param @param user
    * @param @return    设定文件 
    * @return Table    返回类型 
    * @throws
     */
    @TargetDataSource("pamiss_othe_sod")
	public Table finduserlist(Table table, User user) {
		
		List<User> list = userDao.findUserList(user, table);
		int count = userDao.findUsercount(user, table);
		table.setData(list);
		table.setCount(count);
		
		return table;
	}

    @TargetDataSource("pamiss_othe_sod")
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

    @TargetDataSource("pamiss_othe_sod")
	public int updateUserById(User user) {
		return userDao.updateUserById(user);
	}
    @TargetDataSource("pamiss_othe_sod")
    public User findUserByMoblie(String moblie) {
    	return userDao.findUserByMoblie(moblie);
    };
    
    @TargetDataSource("pamiss_othe_sod")
    public User findUserByLogin(User user,String loginType) {
    	User u = userDao.findUserByLogin(user);
    	if(u != null) {
    		if(user.getCounty() == null) user.setCounty("");
        	if(user.getCity() == null) user.setCity("");
        	if(user.getTown() == null) user.setTown("");
        	tbuserloginlogDao.save(user.getAreacode(),user.getCity()+user.getCounty()+user.getTown(),loginType, user.getId(), user.getCounty(),StringTool.getSystemDateTimeString());
    	}
    	return u;
    };
    /**
     * 
    * @Title: saveUser 
    * @Description: 添加用户信息
    * @param @param user
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    @TargetDataSource("pamiss_othe_sod")
    public int saveUser(User user) {
    	
        return userDao.saveUser(user);
    };
    /**
     * 
    * @Title: resetPassword 
    * @Description: 密码重置
    * @param @param entity
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    @TargetDataSource("pamiss_othe_sod")
    public int resetPassword(User entity) {
    	entity.setPassword(StringTool.getMD5("123456"));
    	 return userDao.resetPassword(entity);
    };
    /**
    * @Title: findAreaAll 
    * @Description: 获取区域列表
    * @param @return    设定文件 
    * @return HashMap<String,String>    返回类型 
    * @throws
     */
    @TargetDataSource("pamiss_othe_sod")
    public ArrayList<HashMap<String, Object>> findAreaAll(){
    	return userDao.findAreaAll();
    }
	
}
