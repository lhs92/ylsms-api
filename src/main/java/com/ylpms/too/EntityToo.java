package com.ylpms.too;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ylpms.user.entity.User;

/**
 * 
* @ClassName: EntityToo 
* @Description: 实体对象工具
* @author yuyao
* @date 2018年1月30日 上午9:56:02
 */
public class EntityToo {
	
	/** 
	    * java反射bean的get方法  获取mysql 用于修改语句
	    *  
	    * @param objectClass 
	    * @param fieldName 
	    * @return 
	    */  
	   public static String getGetMethod(Object entity) {  
		   // 获取实体类的所有属性，返回Field数组
		   Field[] field = entity.getClass().getDeclaredFields(); 
	        try {
	        	// 遍历所有属性
	            for (int j = 0; j < field.length; j++) { 
	            	// 获取属性的名字
	                String ybname = field[j].getName(); 
	                // 将属性的首字符大写，方便构造get，set方法
	                String name = ybname.substring(0, 1).toUpperCase() + ybname.substring(1); 
	                // 获取属性的类型
	                String type = field[j].getGenericType().toString(); 
	                   // Method m = entity.getClass().getMethod("get" + name);
	                   // 调用getter方法获取属性值
	                	StringBuilder sb = new StringBuilder();
	                	sb.append("if(StringTool.isNotNull(entity.get"+name+"()))");
	                	sb.append("sql.append(\""+ybname+"='\"+entity.get"+name+"()+\"',\");");
	                    System.out.println(sb);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	       return null;  
	   }  
	   
	   public static void main(String[] args) {
		
		   EntityToo.getGetMethod(new User());
		   
	}

}
