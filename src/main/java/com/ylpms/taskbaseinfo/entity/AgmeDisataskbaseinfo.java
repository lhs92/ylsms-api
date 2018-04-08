package com.ylpms.taskbaseinfo.entity;
/**
 * 
* @ClassName: agmeDisataskbaseinfo 
* @Description: 对应实体 agme_disa_taskbaseinfo 01任务基础信息表
* @author yuyao
* @date 2018年1月23日 上午10:01:20
 */
public class AgmeDisataskbaseinfo {

	private String taskid; //任务编号
	private String taskname; //任务名称
	private String createtime; //任务创建时间
	private String taskcreateman; //创建者用户ID
	private String deadline; //任务时限
	private String recipientmen; //可以是多个用户ID，用英文分号隔开
	private String performerman; //实际接收并去执行的用户ID
	private String tasktype; //任务类型
	private String reviewersname; //审核者名字(自建任务)
	private String taskstatus; //存储任务状态ID
	private String transferreasons; //转派理由
	private String refusalreasons; //拒绝理由
	private String investigationarea; //调查地区
	private String iongitude; //经度
	private String latitude; //纬度
	private String altitude; //海拔高度
	private String investigationtype; //调查类型
	private String croptypeone; //农业类别大类
	private String croptypetwo; //农业类别小类
	private String disastertypeone; //调查类型为灾害调查时填写
	private String disastertypetwo; //调查类型为灾害调查时填写
	private String professionalinvestigationtype; //调查类型为专业类型时填写
	private String developmentaltype; //调查类型为农情调查时填写
	private String taskdesc; //任务描述
	private String cropperiod; //
	private String rejectreason; //
	private String del_flg; //0:未删除,1:删除
	
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getTaskcreateman() {
		return taskcreateman;
	}
	public void setTaskcreateman(String taskcreateman) {
		this.taskcreateman = taskcreateman;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getRecipientmen() {
		return recipientmen;
	}
	public void setRecipientmen(String recipientmen) {
		this.recipientmen = recipientmen;
	}
	public String getPerformerman() {
		return performerman;
	}
	public void setPerformerman(String performerman) {
		this.performerman = performerman;
	}
	public String getTasktype() {
		return tasktype;
	}
	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	public String getReviewersname() {
		return reviewersname;
	}
	public void setReviewersname(String reviewersname) {
		this.reviewersname = reviewersname;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public String getTransferreasons() {
		return transferreasons;
	}
	public void setTransferreasons(String transferreasons) {
		this.transferreasons = transferreasons;
	}
	public String getRefusalreasons() {
		return refusalreasons;
	}
	public void setRefusalreasons(String refusalreasons) {
		this.refusalreasons = refusalreasons;
	}
	public String getInvestigationarea() {
		return investigationarea;
	}
	public void setInvestigationarea(String investigationarea) {
		this.investigationarea = investigationarea;
	}
	public String getIongitude() {
		return iongitude;
	}
	public void setIongitude(String iongitude) {
		this.iongitude = iongitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getInvestigationtype() {
		return investigationtype;
	}
	public void setInvestigationtype(String investigationtype) {
		this.investigationtype = investigationtype;
	}
	public String getCroptypeone() {
		return croptypeone;
	}
	public void setCroptypeone(String croptypeone) {
		this.croptypeone = croptypeone;
	}
	public String getCroptypetwo() {
		return croptypetwo;
	}
	public void setCroptypetwo(String croptypetwo) {
		this.croptypetwo = croptypetwo;
	}
	public String getDisastertypeone() {
		return disastertypeone;
	}
	public void setDisastertypeone(String disastertypeone) {
		this.disastertypeone = disastertypeone;
	}
	public String getDisastertypetwo() {
		return disastertypetwo;
	}
	public void setDisastertypetwo(String disastertypetwo) {
		this.disastertypetwo = disastertypetwo;
	}
	public String getProfessionalinvestigationtype() {
		return professionalinvestigationtype;
	}
	public void setProfessionalinvestigationtype(String professionalinvestigationtype) {
		this.professionalinvestigationtype = professionalinvestigationtype;
	}
	public String getDevelopmentaltype() {
		return developmentaltype;
	}
	public void setDevelopmentaltype(String developmentaltype) {
		this.developmentaltype = developmentaltype;
	}
	public String getTaskdesc() {
		return taskdesc;
	}
	public void setTaskdesc(String taskdesc) {
		this.taskdesc = taskdesc;
	}
	public String getCropperiod() {
		return cropperiod;
	}
	public void setCropperiod(String cropperiod) {
		this.cropperiod = cropperiod;
	}
	public String getRejectreason() {
		return rejectreason;
	}
	public void setRejectreason(String rejectreason) {
		this.rejectreason = rejectreason;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	

}
