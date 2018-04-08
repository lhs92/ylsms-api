package com.ylpms.user.entity;
/**
 * 
* @ClassName: User 
* @Description: 用户信息 对应 t_b_user 表
* @author yuyao
* @date 2017年12月11日 下午4:11:27
 */
public class User {
	private String id; //主键ID
	private String entity; //经营主体
	private String owner; //企业法人
	private String introduce; //企业概述
	private String address; //企业地址
	private String contacts; //联系人
	private String moblie; //手机号
	private String wechat; //微信号
	private String password;//密码
	private String economytype; //经济类型
	private String organizationtype; //组织形式
	private String SICcode; //行业编码
	private String staff; //职工数
	private String scale; //经营规模
	private String scope; //经营范围
	private String industries; //产业
	private String products; //产品
	private String value; //总产值
	private String city; //地州市
	private String county; //区县
	private String town; //乡镇
	private String areacode; //区域编码
	private String lon; //经度
	private String lat; //纬度
	private String del_flg; //删除标识：0(正常)，1(删除)
	private Integer userType;//用户类型（专业用户 0 ，普通用户 1）
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getMoblie() {
		return moblie;
	}
	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getEconomytype() {
		return economytype;
	}
	public void setEconomytype(String economytype) {
		this.economytype = economytype;
	}
	public String getOrganizationtype() {
		return organizationtype;
	}
	public void setOrganizationtype(String organizationtype) {
		this.organizationtype = organizationtype;
	}
	public String getSICcode() {
		return SICcode;
	}
	public void setSICcode(String sICcode) {
		SICcode = sICcode;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getIndustries() {
		return industries;
	}
	public void setIndustries(String industries) {
		this.industries = industries;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
