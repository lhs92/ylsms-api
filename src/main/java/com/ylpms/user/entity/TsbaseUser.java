package com.ylpms.user.entity;
/**
 * 
* @ClassName: T_s_base_user 
* @Description: 对应 数据库 用户表
* @author yuyao
* @date 2018年1月9日 下午6:10:36
 */
public class TsbaseUser {

	private String ID; //
	private String createtime; //创建时间
	private String activitiSync; //
	private String browser; //
	private String realname; //
	private String username; //
	private String password; //
	private String mobilePhone; //手机号
	private String signature; //
	private String status; //
	private String userkey; //
	private String departid; //
	private String delete_flag; //删除状态0:未删除，1:删除
	private String registradion_id; //注册ID
	private String tag; //统一代号
	private String alias; //用户别名
	private String device_type; //设备类型:0 android 1 ios
	private String token; //
	private String openid; //微信号
	private String mode; //注册方式（0：分配，1：微信，2：网页，3：APP）
	private String nickname; //昵称
	private String e_mail; //邮件
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getActivitiSync() {
		return activitiSync;
	}
	public void setActivitiSync(String activitiSync) {
		this.activitiSync = activitiSync;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserkey() {
		return userkey;
	}
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	public String getDepartid() {
		return departid;
	}
	public void setDepartid(String departid) {
		this.departid = departid;
	}
	public String getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	public String getRegistradion_id() {
		return registradion_id;
	}
	public void setRegistradion_id(String registradion_id) {
		this.registradion_id = registradion_id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

}
