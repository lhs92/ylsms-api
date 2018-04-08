package com.ylpms.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylpms.mysql.config.TargetDataSource;
import com.ylpms.too.StringTool;
import com.ylpms.too.Table;
import com.ylpms.user.dao.TbuserloginlogDao;
import com.ylpms.user.entity.Tbuserloginlog;
import com.ylpms.user.entity.Vuserdetailsifno;

@Service
public class TbuserloginlogService {

	@Autowired
	TbuserloginlogDao tbuserloginlogDao;
	
	/**
	 * 
	* @Title: finduserlist 
	* @Description: 获取列表   @TargetDataSource("pamiss_othe_sod") 指定数据原为 pamiss_othe_sod
	* @param @param table
	* @param @param user
	* @param @param kscxtime
	* @param @param jscxtime
	* @param @return    设定文件 
	* @return Table    返回类型 
	* @throws
	 */
	@TargetDataSource("pamiss_othe_sod")
	public Table finduserlist(Table table, Tbuserloginlog user,String kscxtime,String jscxtime) {
		
		List<Tbuserloginlog> list = tbuserloginlogDao.findUserList(user, table,kscxtime,jscxtime);
		int count = tbuserloginlogDao.findUsercount(user, table,kscxtime,jscxtime);
		table.setData(list);
		table.setCount(count);
		
		return table;
	}
	/**
	 * 
	* @Title: save 
	* @Description: 添加
	* @param @param user    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@TargetDataSource("pamiss_othe_sod")
	public void save(Tbuserloginlog user) {
		 Vuserdetailsifno vuser = tbuserloginlogDao.getVuserdetailsifno(user);
		 
		 user.setUserName(vuser.getRealname());
		 user.setAreacod(vuser.getDepartcode());
		 user.setAreaname(vuser.getUserDepartment());
		
		tbuserloginlogDao.save(user.getAreacod(),user.getAreaname(), user.getLoginType(), user.getUserId(), user.getUserName(),StringTool.getSystemDateTimeString());
	}
	
}
