package com.ylpms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ylpms.too.Table;
import com.ylpms.user.entity.Tbuserloginlog;
import com.ylpms.user.service.TbuserloginlogService;

/**
 * 
* @ClassName: TbuserloginlogController 
* @Description: 登录信息 
* @author yuyao
* @date 2018年1月10日 上午11:27:13
 */
@RestController
public class TbuserloginlogController {

	@Autowired
	TbuserloginlogService tbuserloginlogService;
	
	/**
	 * 
	* @Title: findOneCity 
	* @Description: 登录日志列表
	* @param @param table
	* @param @param user
	* @param @param response
	* @param @return    设定文件 
	* @return Table    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/getuserloglist")
    public Table findOneCity(Table table,Tbuserloginlog user,String kstime,String jstime) {
        return tbuserloginlogService.finduserlist(table, user,kstime,jstime);
        
    }
	
	/**
	 * 
	* @Title: save 
	* @Description: 添加接口
	* @param @param user    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/savelog")
    public int save(final Tbuserloginlog user) {
		
		int msg = 0;
		Thread thread = new Thread(){
			   public void run(){
					try {
						tbuserloginlogService.save(user);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						//msg = 2;
					}
			   }
			};
			thread.start();
			return msg;
    }
}
