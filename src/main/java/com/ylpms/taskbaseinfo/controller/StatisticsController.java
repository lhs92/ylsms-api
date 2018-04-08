package com.ylpms.taskbaseinfo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ylpms.taskbaseinfo.service.StatisticsService;
import com.ylpms.taskbaseinfo.too.StaticsDataToo;

/**
 * 
* @ClassName: StatisticsController 
* @Description: 统计接口
* @author yuyao
* @date 2018年2月8日 上午9:53:07
 */
@RestController
public class StatisticsController {

	@Autowired
	StatisticsService statisticsService;
	
	/**
	* @Title: getStatisticsData 
	* @Description: 获取统计列表
	* @param @return    设定文件 
	* @return ArrayList<StaticsDataToo>    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/getStatisticsData")
	public ArrayList<StaticsDataToo> getStatisticsData() {
		
		return statisticsService.getStatisticsData();
	 }
}
