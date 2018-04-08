package com.ylpms.taskbaseinfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ylpms.taskbaseinfo.entity.AgmeDisaAgricultural;
import com.ylpms.taskbaseinfo.entity.AgmeDisaDisaster;
import com.ylpms.taskbaseinfo.entity.AgmeDisaTaskstatus;
import com.ylpms.taskbaseinfo.entity.AgmeDisataskbaseinfo;
import com.ylpms.taskbaseinfo.service.AgmeDisataskbaseinfoService;
import com.ylpms.taskbaseinfo.too.Dom4jtoo;
import com.ylpms.too.Table;
/**
 * 
* @ClassName: AgmeDisataskbaseinfoController 
* @Description: 任务接口 
* @author yuyao
* @date 2018年2月8日 上午9:53:20
 */
@RestController
public class AgmeDisataskbaseinfoController {

	@Autowired
	AgmeDisataskbaseinfoService AgmeDisataskbaseinfoService;
	
	/**
	 * 
	* @Title: getEntityllist 
	* @Description: 获取列表信息
	* @param @param table
	* @param @param entity
	* @param @return    设定文件 
	* @return Table    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/getAgmeDisataskbaseinfolist")
    public Table getEntityllist(Table table,AgmeDisataskbaseinfo entity) {
        return AgmeDisataskbaseinfoService.getEntityllist(table,entity);
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
	@RequestMapping(value = "/findAgriculturalById")
	public AgmeDisaDisaster findAgriculturalById(String taskid) {
		
		return AgmeDisataskbaseinfoService.findAgriculturalById(taskid);
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
	@RequestMapping(value = "/findAgmeDisaAgriculturalById")
	public AgmeDisaAgricultural findAgmeDisaAgriculturalById(String taskid) {
		return AgmeDisataskbaseinfoService.findAgmeDisaAgriculturalById(taskid);
	}
	
	/**
	* @Title: findLikeAgmeDisaTaskstatusLise 
	* @Description: 模糊查询 获取状态值
	* @param @param taskstatusid
	* @param @return    设定文件 
	* @return List<AgmeDisaTaskstatus>    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/findLikeAgmeDisaTaskstatusLise")
	public List<AgmeDisaTaskstatus> findLikeAgmeDisaTaskstatusLise(String taskstatusid){
    	return AgmeDisataskbaseinfoService.findLikeAgmeDisaTaskstatusLise(taskstatusid);
    }
	/**
	* @Title: updateEntityById 
	* @Description: 注销数据
	* @param @param taskid
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/updateEntityById")
	public int updateEntityById(String taskid) {
		return AgmeDisataskbaseinfoService.updateEntityById(taskid);
	}
	
	@RequestMapping(value = "/getXml")
	public void getXml(HttpServletResponse response,HttpServletRequest rq) {
		 String jsonlist = rq.getParameter("list");
		 ArrayList<AgmeDisataskbaseinfo> list = null;
		 if(jsonlist != null) {
			 jsonlist = jsonlist.replace("null", "''");
			 Gson gson = new Gson();
			 list = gson.fromJson(jsonlist, new TypeToken<ArrayList<AgmeDisataskbaseinfo>>() {  
	         }.getType());
			try {
				Dom4jtoo.DOM4Jcreate(response,list);
			} catch (Exception e) {
				System.out.println("xml 转换异常");
			}
		 }
	}
}
