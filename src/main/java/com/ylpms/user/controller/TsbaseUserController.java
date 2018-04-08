package com.ylpms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ylpms.user.entity.TsbaseUser;
import com.ylpms.user.service.TsbaseUserService;

@RestController
public class TsbaseUserController {

	@Autowired
	TsbaseUserService tsbaseUserService;
	
	/**
	 * 
	* @Title: findUserById 
	* @Description: 通过ID 获取单个用户信息
	* @param @param id
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/findTsbaseUserById")
	public TsbaseUser findTsbaseUserById(String id,String username,String mobilePhone) {
		if(id != null || username != null || mobilePhone != null) {
			TsbaseUser  user = new TsbaseUser();
			user.setID(id);
			user.setUsername(username);
			user.setMobilePhone(mobilePhone);
			return tsbaseUserService.findUserById(user);
		}return null;
		
	}
}
