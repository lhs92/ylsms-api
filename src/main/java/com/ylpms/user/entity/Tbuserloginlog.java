package com.ylpms.user.entity;

/**
 * 
* @ClassName: Tbuserloginlog 
* @Description: 对应登录信息表 t_b_user_login_log
* @author yuyao
* @date 2018年1月10日 上午10:43:03
 */
public class Tbuserloginlog {

	private String id; //主键ID
	private String areacod; //区域编码
	private String areaname;//区域名称
	private String loginType; //用户类型（系统）was、waspro、wcs、wcspro、dca、pms、bas
	private String time; //登录时间
	private String userId; //用户ID
	private String userName; //用户姓名
	private long counts;//次数
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAreacod() {
		return areacod;
	}
	public void setAreacod(String areacod) {
		this.areacod = areacod;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getCounts() {
		return counts;
	}
	public void setCounts(long counts) {
		this.counts = counts;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
}
