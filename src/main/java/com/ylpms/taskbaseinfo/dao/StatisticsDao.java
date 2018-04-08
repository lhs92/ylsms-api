package com.ylpms.taskbaseinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ylpms.taskbaseinfo.too.StatisticsToo;
/**
 * 
* @ClassName: Statistics 
* @Description: 查询统计
* @author yuyao
* @date 2018年2月8日 上午9:37:04
 */
@Mapper
public interface StatisticsDao {

	/**
	* @Title: findAgmeDisaTaskstatusLise 
	* @Description: 统计自建任务
	* @param @return    设定文件 
	* @return List<StatisticsToo>    返回类型 
	* @throws
	 */
	@Select("select t.taskname,taskstatus,performerman userid,count(t.taskstatus) sl "
			+ "from agme_disa_taskbaseinfo t where tasktype = 'sb22' group by "
			+ "performerman,taskstatus  order by  performerman desc")  
    List<StatisticsToo> getStatisticsZj();
	
	/**
	* @Title: getStatisticsNotZj 
	* @Description: 统计非自建任务
	* @param @return    设定文件 
	* @return List<StatisticsToo>    返回类型 
	* @throws
	 */
	@Select("select t.taskname,taskstatus,performerman userid,count(t.performerman) sl "
			+ "from agme_disa_taskbaseinfo t where tasktype != 'sb22' group by "
			+ "performerman,taskstatus  order by  performerman desc")  
    List<StatisticsToo> getStatisticsNotZj();
	
}
