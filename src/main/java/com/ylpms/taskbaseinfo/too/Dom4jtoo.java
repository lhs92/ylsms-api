package com.ylpms.taskbaseinfo.too;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ylpms.taskbaseinfo.entity.AgmeDisataskbaseinfo;

public class Dom4jtoo {

	 /**
     * DOM4J方式创建xml文件
     * @param file
     * @throws Exception
     */
    public static void DOM4Jcreate(HttpServletResponse response,List<AgmeDisataskbaseinfo> list)throws Exception{
        Document document=DocumentHelper.createDocument();
        Element root=document.addElement("rss");
        root.addAttribute("version", "2.0");
        
        if(list != null) {
       
        for(AgmeDisataskbaseinfo i:list) {
        	 Element channel=root.addElement("tabl");
        	 
             Element title=channel.addElement("Altitude");
             title.setText(i.getAltitude());
             
             Element Createtime=channel.addElement("Createtime");
             Createtime.setText(i.getCreatetime());
             
             Element Cropperiod=channel.addElement("Cropperiod");
             Cropperiod.setText(i.getCropperiod());
             
             Element Croptypeone=channel.addElement("Croptypeone");
             Croptypeone.setText(i.getCroptypeone());
             
             Element Croptypetwo=channel.addElement("Croptypetwo");
             Croptypetwo.setText(i.getCroptypetwo());
             
             Element Deadline=channel.addElement("Deadline");
             Deadline.setText(i.getDeadline());
             
             Element Del_flg=channel.addElement("Del_flg");
             Del_flg.setText(i.getDel_flg());
             
             Element Developmentaltype=channel.addElement("Developmentaltype");
             Developmentaltype.setText(i.getDevelopmentaltype());
             
             Element Disastertypeone=channel.addElement("Disastertypeone");
             Disastertypeone.setText(i.getDisastertypeone());
             
             Element Disastertypetwo=channel.addElement("Disastertypetwo");
             Disastertypetwo.setText(i.getDisastertypetwo());
             
             Element Investigationarea=channel.addElement("Investigationarea");
             Investigationarea.setText(i.getInvestigationarea());

             Element Investigationtype=channel.addElement("Investigationtype");
             Investigationtype.setText(i.getInvestigationtype());

             Element Iongitude=channel.addElement("Iongitude");
             Iongitude.setText(i.getIongitude());

             Element Latitude=channel.addElement("Latitude");
             Latitude.setText(i.getLatitude());

             Element Performerman=channel.addElement("Performerman");
             Performerman.setText(i.getPerformerman());

             Element Professionalinvestigationtype=channel.addElement("Professionalinvestigationtype");
             Professionalinvestigationtype.setText(i.getProfessionalinvestigationtype());
             
             Element Recipientmen=channel.addElement("Recipientmen");
             Recipientmen.setText(i.getRecipientmen());
             
             Element Refusalreasons=channel.addElement("Refusalreasons");
             Refusalreasons.setText(i.getRefusalreasons());
             
             Element Rejectreason=channel.addElement("Rejectreason");
             Rejectreason.setText(i.getRejectreason());
             
             Element Reviewersname=channel.addElement("Reviewersname");
             Reviewersname.setText(i.getReviewersname());

             Element Taskcreateman=channel.addElement("Taskcreateman");
             Taskcreateman.setText(i.getTaskcreateman());

             Element Taskdesc=channel.addElement("Taskdesc");
             Taskdesc.setText(i.getTaskdesc());

             Element Taskid=channel.addElement("Taskid");
             Taskid.setText(i.getTaskid());

             Element Taskname=channel.addElement("Taskname");
             Taskname.setText(i.getTaskname());

             Element Taskstatus=channel.addElement("Taskstatus");
             Taskstatus.setText(i.getTaskstatus());

             Element Tasktype=channel.addElement("Tasktype");
             Tasktype.setText(i.getTasktype());

             Element Transferreasons=channel.addElement("Transferreasons");
             Transferreasons.setText(i.getTransferreasons());
             
        }
        }
        getFile(response,document);
    }
    
    public static void getFile(HttpServletResponse response,Document document) throws UnsupportedEncodingException {
    	 // 下载本地文件
        String fileName = "taskbaseinfo.xml".toString(); // 文件的默认保存名
        // 读到流中
        InputStream inStream = new ByteArrayInputStream(document.asXML().getBytes("utf-8"));
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            System.out.println("文件输入流 读取异常！" + e.getMessage());
        }
    	
    }
    
}
