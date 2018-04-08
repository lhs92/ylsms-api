package com.ylpms.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylpms.mysql.config.TargetDataSource;
import com.ylpms.user.dao.TsbaseuserDao;
import com.ylpms.user.entity.TsbaseUser;
/**
 * 
* @ClassName: TsbaseUserService 
* @Description: T s base User Service
* @author yuyao
* @date 2018年1月9日 下午6:14:54
 */
@Service
public class TsbaseUserService {

	@Autowired
	TsbaseuserDao tsbaseuserDao;
	
	/**
	 * 
	* @Title: findUserById 
	* @Description: 通过 ID 获取用户 信息
	* @param @param id
	* @param @return    设定文件 
	* @return TsbaseUser    返回类型 
	* @throws
	 */
	@TargetDataSource("pamiss_othe_sod")
	public TsbaseUser findUserById(TsbaseUser user) {
		
		return tsbaseuserDao.findUserById(user);
	}
	
	/**
	 * 
	* @Title: getTsbaseUserList 
	* @Description: 通过 id 集合获取 用户对象
	* @param @param list
	* @param @return    设定文件 
	* @return ArrayList<TsbaseUser>    返回类型 
	* @throws
	 */
	@TargetDataSource("pamiss_othe_sod")
	public List<TsbaseUser> getTsbaseUserList(String ids){
		
		return tsbaseuserDao.findUserListByIds(ids);
	};
	
}
