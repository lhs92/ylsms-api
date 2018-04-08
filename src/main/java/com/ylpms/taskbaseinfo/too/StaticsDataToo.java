package com.ylpms.taskbaseinfo.too;
/**
 * 
* @ClassName: StaticsDataToo 
* @Description: 返回统计实体类
* @author yuyao
* @date 2018年2月8日 上午9:57:51
 */
public class StaticsDataToo {

	private String taskName;//任务名称
	private String taskstatus;//任务类型态码
	private String taskstatusName;//任务类型名称
	private String userName;//用户姓名
	private String userId;//用户ID
	private int st02;//新建待接收
	private int st03;//转派待接收
	private int st04;//驳回待接收
	private int st05;//执行中
	private int st06;//待审核
	private int st07;//审核中
	private int st08;//审核通过
	private int st77;//被拒绝
	private int st88;//已归档
	private int st99;//作废
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public String getTaskstatusName() {
		return taskstatusName;
	}
	public void setTaskstatusName(String taskstatusName) {
		this.taskstatusName = taskstatusName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getSt02() {
		return st02;
	}
	public void setSt02(int st02) {
		this.st02 = st02;
	}
	public int getSt03() {
		return st03;
	}
	public void setSt03(int st03) {
		this.st03 = st03;
	}
	public int getSt04() {
		return st04;
	}
	public void setSt04(int st04) {
		this.st04 = st04;
	}
	public int getSt05() {
		return st05;
	}
	public void setSt05(int st05) {
		this.st05 = st05;
	}
	public int getSt06() {
		return st06;
	}
	public void setSt06(int st06) {
		this.st06 = st06;
	}
	public int getSt07() {
		return st07;
	}
	public void setSt07(int st07) {
		this.st07 = st07;
	}
	public int getSt08() {
		return st08;
	}
	public void setSt08(int st08) {
		this.st08 = st08;
	}
	public int getSt77() {
		return st77;
	}
	public void setSt77(int st77) {
		this.st77 = st77;
	}
	public int getSt88() {
		return st88;
	}
	public void setSt88(int st88) {
		this.st88 = st88;
	}
	public int getSt99() {
		return st99;
	}
	public void setSt99(int st99) {
		this.st99 = st99;
	}
	
}
