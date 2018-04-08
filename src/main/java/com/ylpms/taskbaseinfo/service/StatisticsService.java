package com.ylpms.taskbaseinfo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylpms.mysql.config.TargetDataSource;
import com.ylpms.taskbaseinfo.dao.StatisticsDao;
import com.ylpms.taskbaseinfo.entity.AgmeDisaTaskstatus;
import com.ylpms.taskbaseinfo.entity.AgmeDisataskbaseinfo;
import com.ylpms.taskbaseinfo.too.StaticsDataToo;
import com.ylpms.taskbaseinfo.too.StatisticsToo;
import com.ylpms.too.StringTool;
import com.ylpms.user.entity.TsbaseUser;
import com.ylpms.user.service.TsbaseUserService;

/**
 * 
* @ClassName: StatisticsService 
* @Description: 统计逻辑
* @author yuyao
* @date 2018年2月8日 上午9:52:38
 */
@Service
public class StatisticsService {

	@Resource
	StatisticsDao statisticsDao;
	
	@Autowired
	TsbaseUserService tsbaseUserService;
	
	@Autowired
	AgmeDisataskbaseinfoService agmeDisataskbaseinfoService;
	
	@TargetDataSource("usr_collect_api")
    public ArrayList<StaticsDataToo> getStatisticsData() {
		 ArrayList<StatisticsToo> list = new ArrayList<StatisticsToo>();
		//获取非自建任务
		List<StatisticsToo> notzilist = statisticsDao.getStatisticsNotZj();
		//获取自建任务
		List<StatisticsToo> zilist = statisticsDao.getStatisticsZj();
		
		list.addAll(notzilist);
		list.addAll(zilist);
		
		 ArrayList<StaticsDataToo> datalist = getDtat(list);
		 datalist =  getUserNameList(datalist); 
		return datalist;
    }
	
	/**
	 * 
	* @Title: getDtat 
	* @Description: 数据装配
	* @param @param list
	* @param @return    设定文件 
	* @return ArrayList<StaticsDataToo>    返回类型 
	* @throws
	 */
	public ArrayList<StaticsDataToo> getDtat(ArrayList<StatisticsToo> list) {
		ArrayList<StaticsDataToo> datalist = new ArrayList<StaticsDataToo>();
		ArrayList<String> userli = new ArrayList<String>();
		for(StatisticsToo i : list) {
			StaticsDataToo staticsDataToo = new StaticsDataToo();
			//staticsDataToo.setTaskstatus(i.getTaskstatus());
			//staticsDataToo.setTaskName(i.getTaskname());
			staticsDataToo.setUserId(i.getUserid());
			//判断是否已经存在
			if(StringTool.isNotNull(i.getUserid())) {
			if(userli.indexOf(i.getUserid()) == -1) {
				if("st02".equals(i.getTaskstatus()))staticsDataToo.setSt02(i.getSl());
				if("st03".equals(i.getTaskstatus()))staticsDataToo.setSt03(i.getSl());
				if("st04".equals(i.getTaskstatus()))staticsDataToo.setSt04(i.getSl());
				if("st05".equals(i.getTaskstatus()))staticsDataToo.setSt05(i.getSl());
				if("st06".equals(i.getTaskstatus()))staticsDataToo.setSt06(i.getSl());
				if("st07".equals(i.getTaskstatus()))staticsDataToo.setSt07(i.getSl());
				if("st08".equals(i.getTaskstatus()))staticsDataToo.setSt08(i.getSl());
				if("st77".equals(i.getTaskstatus()))staticsDataToo.setSt77(i.getSl());
				if("st88".equals(i.getTaskstatus()))staticsDataToo.setSt88(i.getSl());
				if("st99".equals(i.getTaskstatus()))staticsDataToo.setSt99(i.getSl());
				userli.add(i.getUserid());
				datalist.add(staticsDataToo);
			}else {//已存在
				for(int j=0;j<datalist.size();j++) {
					if(i.getUserid().equals(datalist.get(j).getUserId())) {
						if("st02".equals(i.getTaskstatus()))datalist.get(j).setSt02(i.getSl());
						if("st03".equals(i.getTaskstatus()))datalist.get(j).setSt03(i.getSl());
						if("st04".equals(i.getTaskstatus()))datalist.get(j).setSt04(i.getSl());
						if("st05".equals(i.getTaskstatus()))datalist.get(j).setSt05(i.getSl());
						if("st06".equals(i.getTaskstatus()))datalist.get(j).setSt06(i.getSl());
						if("st07".equals(i.getTaskstatus()))datalist.get(j).setSt07(i.getSl());
						if("st08".equals(i.getTaskstatus()))datalist.get(j).setSt08(i.getSl());
						if("st77".equals(i.getTaskstatus()))datalist.get(j).setSt77(i.getSl());
						if("st88".equals(i.getTaskstatus()))datalist.get(j).setSt88(i.getSl());
						if("st99".equals(i.getTaskstatus()))datalist.get(j).setSt99(i.getSl());
					}
				}
			}
			}
			
		}
		return datalist;
	}
	
	/**
	* @Title: getDtat 
	* @Description: 数据 用户信息装配
	* @param @param list
	* @param @return    设定文件 
	* @return ArrayList<StaticsDataToo>    返回类型 
	* @throws
	 */
	public ArrayList<StaticsDataToo> getUserNameList(ArrayList<StaticsDataToo> list) {
		
		HashSet<String> ids = new HashSet<String>();
    	for (StaticsDataToo entity : list) {
    		if(StringTool.isNotNull(entity.getUserId()))ids.add(entity.getUserId());
		
    	}
    	 StringBuilder idjh = new StringBuilder();
    	 for(String id:ids) {
    		 idjh.append(","+id);
    	 }
    	String datasj = idjh.toString().replaceAll(",","|"); 
    	datasj = datasj.substring(1, datasj.length());
    	//数据量大后 需要分级查询
    	List<TsbaseUser> userlist = tsbaseUserService.getTsbaseUserList(datasj);
		
    	 for(int i = 0;i < list.size(); i++) {
    		 for(TsbaseUser u:userlist) {
    			 if(list.get(i).getUserId().equals(u.getID())) {
    				 if(StringTool.isNotNull(u.getRealname())) {
    					 list.get(i).setUserName(u.getRealname()); 
    				 }else {
    					 list.get(i).setUserName("未知用户"); 
					}
    				 
    			 }
    		 }
    	 }
		
		return list;
	}
	
	
}
