package com.ylpms.user.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ylpms.too.AjaxJson;
import com.ylpms.too.StringTool;
import com.ylpms.too.Table;
import com.ylpms.user.entity.User;
import com.ylpms.user.service.UserService;

@RestController
public class UserController {
	
		@Autowired
		UserService userService;

		/**
		* @Title: findOneCity 
		* @Description: esui 表格分页插件 接口api
		* @param @param dataGrid
		* @param @param user
		* @param @return    设定文件 
		* @return DataGrid    返回类型 
		* @throws
		 */
		@RequestMapping(value = "/getuserlist")
	    public Table getuserlist(Table table,User user) {
	        return userService.finduserlist(table, user);
	    }
		
		/**
		 * 
		* @Title: findUserById 
		* @Description: 通过ID 获取单个用户信息
		* @param @param id
		* @param @return    设定文件 
		* @return User    返回类型 
		* @throws
		 */
		@RequestMapping(value = "/findUserById")
		public User findUserById(Integer id) {
			if(id == null) return null;
			 User user = userService.findUserById(id);
			return user;
		}
		
		/**
		 * 
		* @Title: saveUser 
		* @Description: 添加外部用户信息
		* @param @param user
		* @param @return    设定文件 
		* @return int    返回类型 
		* @throws
		 */
		@RequestMapping(value = "/saveUser")
		public  Integer saveUser(User user) {
			if(user == null) return null;
		    return userService.saveUser(user);
		 };
		
		/**
		 * 
		* @Title: findUserById 
		* @Description: 通过ID 修改外部用户信息
		* @param @param id
		* @param @return    设定文件 
		* @return User    返回类型 
		* @throws
		 */
		@RequestMapping(value = "/updateUserById")
		public Integer updateUserById(User user) {
			if(user == null && user.getId() == null || "".equals(user.getId())) return null;
			return userService.updateUserById(user);
		}
		
		/**
		* @Title: registered 
		* @Description: 外部用户注册
		* @throws
		 */
		@RequestMapping(value = "/registered")
		public AjaxJson registered(User user) {
			AjaxJson ajax = new AjaxJson(); 
			if(user != null && StringTool.isNotNull(user.getMoblie()) && 
					StringTool.isNotNull(user.getPassword())) {
				user.setPassword(StringTool.getMD5(user.getPassword()));
				 User u = userService.findUserByMoblie(user.getMoblie());
				 if(u != null) {
					 ajax.setMsg("账号已存在！");
					 ajax.setSuccess(false);
					 return ajax;
				 }
				 ajax.setSuccess(true);
				 ajax.setPass(1);
				 userService.saveUser(user);
				return ajax;
			}
			ajax.setMsg("传递参数错误！");
			ajax.setSuccess(false);
			return ajax;
		}
		
		/**
		* @Title: login 
		* @Description: 外部用户登录
		* @throws
		 */
		@RequestMapping(value = "/login")
		public AjaxJson login(User user,String loginType) {
			AjaxJson ajax = new AjaxJson(); 
			if(user != null && StringTool.isNotNull(user.getMoblie()) && 
					StringTool.isNotNull(user.getPassword())) {
				user.setPassword(StringTool.getMD5(user.getPassword()));
				User u = userService.findUserByLogin(user,loginType);
				 if(u == null) {
					 ajax.setMsg("登录失败！");
					 ajax.setSuccess(false);
					 return ajax;
				 }
				HashMap<String,Object> userInfo = new HashMap<String,Object>();
		        userInfo.put("userId",u.getId());
		        userInfo.put("username",u.getContacts());
		        userInfo.put("mobilephone",u.getMoblie());
		        userInfo.put("city",u.getCity());
		        userInfo.put("county",u.getCounty());
		        userInfo.put("town",u.getTown());
		        userInfo.put("orgid",u.getAreacode());
		        ajax.setAttributes(userInfo);
				ajax.setSuccess(true);
				ajax.setPass(1);
				
				return ajax;
			}
			ajax.setMsg("传递参数错误！");
			ajax.setSuccess(false);
			return ajax;
		}
		
		/**
		 * 
		* @Title: resetPassword 
		* @Description: 密码重置
		* @param @param user
		* @param @return    设定文件 
		* @return Boolean    返回类型 
		* @throws
		 */
		@RequestMapping(value = "/resetPassword")
		public Boolean resetPassword(User user) {
			if(user != null && StringTool.isNotNull(user.getMoblie())) {
				userService.resetPassword(user);
				return true;
			}
			return false;
		}
		/**
		 * 
		* @Title: findAreaAll 
		* @Description: 获取区域列表
		* @param @return    设定文件 
		* @return HashMap<String,String>    返回类型 
		* @throws
		 */
		@RequestMapping(value = "/findAreaAll")
		public ArrayList<HashMap<String, Object>> findAreaAll(){
		    return userService.findAreaAll();
		}
		
}
