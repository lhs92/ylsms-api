package com.ylpms.taskbaseinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.ylpms.taskbaseinfo.entity.AgmeDisaAgricultural;
import com.ylpms.taskbaseinfo.entity.AgmeDisaDisaster;
import com.ylpms.taskbaseinfo.entity.AgmeDisaTaskstatus;
import com.ylpms.taskbaseinfo.entity.AgmeDisataskbaseinfo;
import com.ylpms.too.StringTool;
import com.ylpms.too.Table;

@Mapper // 标志为 Mybatis 的 Mapper
public interface AgmeDisataskbaseinfoDao {


    @SelectProvider(type=TutorDynaSqlProvider.class,  
    		method="findEntityListSql")  
    List<AgmeDisataskbaseinfo> findEntityList(AgmeDisataskbaseinfo entity,Table table);
    
    @SelectProvider(type=TutorDynaSqlProvider.class,  
    		method="findEntitycount") 
    int findEntitycount(AgmeDisataskbaseinfo Entity,Table table);
    
    /**
    * @Title: findAgmeDisaTaskstatusLise 
    * @Description: 获取状态
    * @param @return    设定文件 
    * @return List<AgmeDisaTaskstatus>    返回类型 
    * @throws
     */
    @Select("select * from agme_disa_taskstatus ")  
    List<AgmeDisaTaskstatus> findAgmeDisaTaskstatusLise();
    
    @SelectProvider(type=TutorDynaSqlProvider.class,  
	method="findLikeAgmeDisaTaskstatusLise") 
    List<AgmeDisaTaskstatus> findLikeAgmeDisaTaskstatusLise(String taskstatusid);
    
    @Select("select * from agme_disa_agricultural where taskid = #{taskid}")  
    AgmeDisaAgricultural findAgmeDisaAgriculturalById(@Param("taskid")String taskid);
    
    @Select("select * from agme_disa_disaster where taskid = #{taskid}")  
    AgmeDisaDisaster findAgriculturalById(@Param("taskid")String taskid);
    
    @Update(" UPDATE agme_disa_taskbaseinfo SET del_flg = '1' WHERE taskid=#{taskid}") 
    int updateEntityById(@Param("taskid")String taskid);
    
    
    /**
     * 内部类 编写动态sql
     * @author Administrator
     */
    public class TutorDynaSqlProvider{  
    	
    	//通用SQL
    	String Entitytysq = "select * from agme_disa_taskbaseinfo where del_flg = 0";
    	
        public String findEntityListSql(AgmeDisataskbaseinfo entity,Table table)  { 
        	
        	StringBuilder sql = new StringBuilder();
        	int ks = table.getLimit() * (table.getPage()-1);
        	//计算起始位置
        	if(ks < 0) {
        		ks = 0;
        	}
        	sql.append(Entitytysq);
        	if(StringTool.isNotNull(entity.getTaskname()))sql.append(" and taskname like '" + entity.getTaskname() + "%'");
        	if(StringTool.isNotNull(table.getKstime()))sql.append(" and createtime >= '" + table.getKstime() + "'");
        	if(StringTool.isNotNull(table.getJstime()))sql.append(" and createtime <= '" + table.getJstime() + "'");
        	if(StringTool.isNotNull(entity.getInvestigationtype()))sql.append(" and investigationtype = '" + entity.getInvestigationtype() + "'");
        	if(StringTool.isNotNull(entity.getCroptypetwo()))sql.append(" and croptypetwo = '" + entity.getCroptypetwo() + "'");
        	sql.append(" ORDER BY createtime DESC limit "+ ks + "," + table.getLimit() + ";");
        	return  sql.toString();
        }  
        
        public String findEntitycount(AgmeDisataskbaseinfo entity,Table table)  { 
        	
        	StringBuilder sql = new StringBuilder();
        	sql.append("select count(*) count from (");
        	sql.append(Entitytysq);
        	if(StringTool.isNotNull(entity.getTaskname()))sql.append(" and taskname like '" + entity.getTaskname() + "%'");
        	if(StringTool.isNotNull(table.getKstime()))sql.append(" and createtime >= '" + table.getKstime() + "'");
        	if(StringTool.isNotNull(table.getJstime()))sql.append(" and createtime <= '" + table.getJstime() + "'");
        	if(StringTool.isNotNull(entity.getInvestigationtype()))sql.append(" and investigationtype = '" + entity.getInvestigationtype() + "'");
        	if(StringTool.isNotNull(entity.getCroptypetwo()))sql.append(" and croptypetwo = '" + entity.getCroptypetwo() + "'");
        	sql.append(") a");
        	return  sql.toString();
        }
        
        public String findLikeAgmeDisaTaskstatusLise(String taskstatusid) {
        	StringBuilder sql = new StringBuilder();
        	sql.append("select * from agme_disa_taskstatus where taskstatusid like '"+taskstatusid+"%'");
        	return  sql.toString();
        }
        
    }  
}
