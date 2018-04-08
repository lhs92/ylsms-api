package com.ylpms.taskbaseinfo.too;
/**
 * 
* @ClassName: Statistics 
* @Description: 统计实体类
* @author yuyao
* @date 2018年2月8日 上午9:40:15
 */
public class StatisticsToo {

 	private String taskname;//任务名称
 	private String taskstatus;//状态
 	private String userid;//用户ID
 	private int sl;//数量
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
 	
 	
 	
}
