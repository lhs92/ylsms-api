package com.ylpms.taskbaseinfo.service;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylpms.mysql.config.TargetDataSource;
import com.ylpms.taskbaseinfo.dao.AgmeDisataskbaseinfoDao;
import com.ylpms.taskbaseinfo.entity.AgmeDisaAgricultural;
import com.ylpms.taskbaseinfo.entity.AgmeDisaDisaster;
import com.ylpms.taskbaseinfo.entity.AgmeDisaTaskstatus;
import com.ylpms.taskbaseinfo.entity.AgmeDisataskbaseinfo;
import com.ylpms.too.Table;
import com.ylpms.user.entity.TsbaseUser;
import com.ylpms.user.service.TsbaseUserService;

/**
 * 
* @ClassName: AgmeDisataskbaseinfoService 
* @Description: 任务表逻辑处理
* @author yuyao
* @date 2018年1月23日 上午10:11:24
 */
@Service
public class AgmeDisataskbaseinfoService {

	
	@Resource
	AgmeDisataskbaseinfoDao agmeDisataskbaseinfoDao;
	
	@Autowired
	TsbaseUserService tsbaseUserService;
	
	/**
	 * 
	* @Title: getEntityllist 
	* @Description: 获取列表分页数据
	* @param @param table
	* @param @param entity
	* @param @return    设定文件 
	* @return Table    返回类型 
	* @throws
	 */
	@TargetDataSource("usr_collect_api")
    public Table getEntityllist(Table table,AgmeDisataskbaseinfo entity) {
		List<AgmeDisataskbaseinfo> list = agmeDisataskbaseinfoDao.findEntityList(entity, table);
		List<AgmeDisataskbaseinfo> zhdata = null;
		if(list != null && list.size() > 0) {
			zhdata = getData(list);
		}
		int count = agmeDisataskbaseinfoDao.findEntitycount(entity, table);
		table.setData(zhdata);
		table.setCount(count);
        return table;
    }
	
	
	/**
	 * 
	* @Title: findAgmeDisaAgriculturalById 
	* @Description: 获取农情信息
	* @param @param taskid
	* @param @return    设定文件 
	* @return AgmeDisaAgricultural    返回类型 
	* @throws
	 */
	@TargetDataSource("usr_collect_api")
	public AgmeDisaAgricultural findAgmeDisaAgriculturalById(String taskid) {
		
		return agmeDisataskbaseinfoDao.findAgmeDisaAgriculturalById(taskid);
	}
	
	/**
	 * 
	* @Title: findAgriculturalById 
	* @Description: 获取灾情信息
	* @param @param taskid
	* @param @return    设定文件 
	* @return AgmeDisaDisaster    返回类型 
	* @throws
	 */
	@TargetDataSource("usr_collect_api")
	public AgmeDisaDisaster findAgriculturalById(String taskid) {
		
		return agmeDisataskbaseinfoDao.findAgriculturalById(taskid);
	}

	/**
	 * 
	* @Title: findAgmeDisaTaskstatusLise 
	* @Description: 获取任务类型列表
	* @param @return    设定文件 
	* @return List<AgmeDisaTaskstatus>    返回类型 
	* @throws
	 */
	@TargetDataSource("usr_collect_api")
	public List<AgmeDisaTaskstatus> findAgmeDisaTaskstatusLise() {
		return agmeDisataskbaseinfoDao.findAgmeDisaTaskstatusLise();
	}
    
    /**
     * 
    * @Title: updateEntityById 
    * @Description: 修改实体状态
    * @param @param entity
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    @TargetDataSource("usr_collect_api")
	public int updateEntityById(String taskid) {
    	
		return agmeDisataskbaseinfoDao.updateEntityById(taskid);
	}
    /**
     * 
    * @Title: findLikeAgmeDisaTaskstatusLise 
    * @Description: 模糊查询 获取状态值
    * @param @param taskstatusid
    * @param @return    设定文件 
    * @return List<AgmeDisaTaskstatus>    返回类型 
    * @throws
     */
    @TargetDataSource("usr_collect_api")
    public List<AgmeDisaTaskstatus> findLikeAgmeDisaTaskstatusLise(String taskstatusid){
    	return agmeDisataskbaseinfoDao.findLikeAgmeDisaTaskstatusLise(taskstatusid);
    }
    
    /**
     * 
    * @Title: getData 
    * @Description: 对象属性拼接
    * @param @param list
    * @param @return    设定文件 
    * @return List<AgmeDisataskbaseinfo>    返回类型 
    * @throws
     */
    public List<AgmeDisataskbaseinfo> getData(List<AgmeDisataskbaseinfo> list){
    	
    	HashSet<String> ids = new HashSet<String>();
    	for (AgmeDisataskbaseinfo entity : list) {
    		if(entity.getTaskcreateman() != null && !"".equals(entity.getTaskcreateman()))ids.add(entity.getTaskcreateman());
    		if(entity.getReviewersname() != null && !"".equals(entity.getReviewersname()))ids.add(entity.getReviewersname());
    		if(entity.getRecipientmen() != null && !"".equals(entity.getRecipientmen()))ids.add(entity.getRecipientmen());
    		if(entity.getPerformerman() != null && !"".equals(entity.getPerformerman()))ids.add(entity.getPerformerman());
		
    	}
    	 StringBuilder idjh = new StringBuilder();
    	 for(String id:ids) {
    		 idjh.append(","+id);
    	 }
    	String datasj = idjh.toString().replaceAll(",","|"); 
    	datasj = datasj.substring(1, datasj.length());
    	List<TsbaseUser> userlist = tsbaseUserService.getTsbaseUserList(datasj);
    	
    	 List<AgmeDisaTaskstatus> ztlist = findAgmeDisaTaskstatusLise();
    	
    	for(int i = 0;i < list.size(); i++) {
    		if("sb22".equals(list.get(i).getDevelopmentaltype())) {//自建任务
    			list.get(i).setReviewersname(list.get(i).getPerformerman());
    			list.get(i).setPerformerman(list.get(i).getTaskcreateman());
    		}else {//下达任务
    			list.get(i).setReviewersname(list.get(i).getPerformerman());
    			list.get(i).setReviewersname(list.get(i).getTaskcreateman());
			}
    		
    		for(TsbaseUser user : userlist) {
    			if(list.get(i).getTaskcreateman() != null && !"".equals(list.get(i).getTaskcreateman())&&
    					list.get(i).getTaskcreateman().contains(user.getID())) {
    				list.get(i).setTaskcreateman(user.getRealname());
    			} 
    			if(list.get(i).getReviewersname() != null && !"".equals(list.get(i).getReviewersname())&&
    					list.get(i).getReviewersname().contains(user.getID())) {
    				list.get(i).setReviewersname(user.getRealname());
    			} 
    			if(list.get(i).getRecipientmen() != null && !"".equals(list.get(i).getRecipientmen())&&
    					list.get(i).getRecipientmen().contains(user.getID())) {
    				list.get(i).setRecipientmen(user.getRealname());
    			} 
    			if(list.get(i).getPerformerman() != null && !"".equals(list.get(i).getPerformerman())&&
    					list.get(i).getPerformerman().contains(user.getID())) {
    				list.get(i).setPerformerman(user.getRealname());
    			}
    		}
    		
    		for(AgmeDisaTaskstatus j : ztlist) {
    			if(list.get(i).getCropperiod() != null && !"".equals(list.get(i).getCropperiod())&&
    					list.get(i).getCropperiod().contains(j.getTaskstatusid())) {
    				list.get(i).setCropperiod(j.getTaskstatusname());
    			}
    			if(list.get(i).getDevelopmentaltype() != null && !"".equals(list.get(i).getDevelopmentaltype())&&
    					list.get(i).getDevelopmentaltype().contains(j.getTaskstatusid())) {
    				list.get(i).setDevelopmentaltype(j.getTaskstatusname());
    			}
    			if(list.get(i).getProfessionalinvestigationtype() != null && !"".equals(list.get(i).getProfessionalinvestigationtype())&&
    					list.get(i).getProfessionalinvestigationtype().contains(j.getTaskstatusid())) {
    				list.get(i).setProfessionalinvestigationtype(j.getTaskstatusname());
    			}
    			if(list.get(i).getDisastertypetwo() != null && !"".equals(list.get(i).getDisastertypetwo())&&
    					list.get(i).getDisastertypetwo().contains(j.getTaskstatusid())) {
    				list.get(i).setDisastertypetwo(j.getTaskstatusname());
    			}
    			if(list.get(i).getDisastertypeone() != null && !"".equals(list.get(i).getDisastertypeone())&&
    					list.get(i).getDisastertypeone().contains(j.getTaskstatusid())) {
    				list.get(i).setDisastertypeone(j.getTaskstatusname());
    			}
    			if(list.get(i).getCroptypetwo() != null && !"".equals(list.get(i).getCroptypetwo())&&
    					list.get(i).getCroptypetwo().contains(j.getTaskstatusid())) {
    				list.get(i).setCroptypetwo(j.getTaskstatusname());
    			}
    			if(list.get(i).getCroptypeone() != null && !"".equals(list.get(i).getCroptypeone())&&
    					list.get(i).getCroptypeone().contains(j.getTaskstatusid())) {
    				list.get(i).setCroptypeone(j.getTaskstatusname());
    			}
    			if(list.get(i).getInvestigationtype() != null && !"".equals(list.get(i).getInvestigationtype())&&
    					list.get(i).getInvestigationtype().contains(j.getTaskstatusid())) {
    				list.get(i).setInvestigationtype(j.getTaskstatusname());
    			}
    			if(list.get(i).getTasktype() != null && !"".equals(list.get(i).getTasktype())&&
    					list.get(i).getTasktype().contains(j.getTaskstatusid())) {
    				list.get(i).setTasktype(j.getTaskstatusname());
    			}
    			if(list.get(i).getTaskstatus() != null && !"".equals(list.get(i).getTaskstatus())&&
    					list.get(i).getTaskstatus().contains(j.getTaskstatusid())) {
    				list.get(i).setTaskstatus(j.getTaskstatusname());
    			}
    			
    			
    		}
    		
    	}
    	return list;
    }

	
}
