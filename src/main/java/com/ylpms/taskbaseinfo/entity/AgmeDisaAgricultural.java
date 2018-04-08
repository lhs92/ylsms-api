package com.ylpms.taskbaseinfo.entity;

/**
 * 
* @ClassName: AgmeDisaAgricultural 
* @Description: 对应实体 agme_disa_agricultural
* 存储农情调查结果，其中不同发育期需要采集的信息，字段是共用的，需要根据发育期判断 例如 播种出苗
* @author yuyao
* @date 2018年1月23日 上午10:06:09
 */
public class AgmeDisaAgricultural {

	private String taskid; //任务编号
	private String sowdate; //播种日期或预计收获时间
	private String compareforyears; //早、晚、相同
	private String differday; //相差天数
	private String emergence; //出苗情况
	private String seedlinggrowth; //好，一般，差
	private String soilmoisture; //渍涝 湿润  一般  干旱   严重干旱
	private String soilhumidity; //土壤相对湿度
	private String comprehensivedesc; //综合描述
	private String expectedharvest; //丰、平、欠
	private String createtime; //创建时间
	
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public String getSowdate() {
		return sowdate;
	}
	public void setSowdate(String sowdate) {
		this.sowdate = sowdate;
	}
	public String getCompareforyears() {
		return compareforyears;
	}
	public void setCompareforyears(String compareforyears) {
		this.compareforyears = compareforyears;
	}
	public String getDifferday() {
		return differday;
	}
	public void setDifferday(String differday) {
		this.differday = differday;
	}
	public String getEmergence() {
		return emergence;
	}
	public void setEmergence(String emergence) {
		this.emergence = emergence;
	}
	public String getSeedlinggrowth() {
		return seedlinggrowth;
	}
	public void setSeedlinggrowth(String seedlinggrowth) {
		this.seedlinggrowth = seedlinggrowth;
	}
	public String getSoilmoisture() {
		return soilmoisture;
	}
	public void setSoilmoisture(String soilmoisture) {
		this.soilmoisture = soilmoisture;
	}
	public String getSoilhumidity() {
		return soilhumidity;
	}
	public void setSoilhumidity(String soilhumidity) {
		this.soilhumidity = soilhumidity;
	}
	public String getComprehensivedesc() {
		return comprehensivedesc;
	}
	public void setComprehensivedesc(String comprehensivedesc) {
		this.comprehensivedesc = comprehensivedesc;
	}
	public String getExpectedharvest() {
		return expectedharvest;
	}
	public void setExpectedharvest(String expectedharvest) {
		this.expectedharvest = expectedharvest;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}
