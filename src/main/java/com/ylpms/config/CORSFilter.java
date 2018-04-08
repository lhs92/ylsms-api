package com.ylpms.config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

//拦截器添加跨域支持
@Component
public class CORSFilter implements Filter {

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		  HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
		  /*System.out.println(httpServletRequest.getRequestURI()); //请求的接口
		  System.out.println(httpServletRequest.getMethod());//请求方式
		  System.out.println(getIpAddress(httpServletRequest));//请求IP
		   		  
		    //获取请求参数
		   Enumeration<String> names = httpServletRequest.getParameterNames();
		   while (names.hasMoreElements()) {
			  String name = (String) names.nextElement();
			  String value = httpServletRequest.getParameter(name);
			  System.out.println("name:"+ name + "--- value:" + value);
	        }*/
		   HttpServletResponse response = (HttpServletResponse) servletResponse;
		  /* response.setHeader("Access-Control-Allow-Headers", "x-requested-with");   
		   response.setHeader("Access-Content-Type", "application/json;charset=utf-8");  
		   response.setHeader("Access-Control-Allow-Origin", "*");//访问请求 * 所有 主要处理跨域问题
	       response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");//请求方式
	       response.setHeader("Access-Control-Max-Age", "3600");//请求结果缓存
	       response.setHeader("Access-Control-Allow-Credentials", "true"); */
	        
	       filterChain.doFilter(servletRequest, servletResponse);
	       
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	/** 
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址; 
     *  
     * @param request 
     * @return 
     * @throws IOException 
     */  
    public String getIpAddress(HttpServletRequest request) throws IOException {  
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("Proxy-Client-IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_CLIENT_IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getRemoteAddr();  
            }  
        } else if (ip.length() > 15) {  
            String[] ips = ip.split(",");  
            for (int index = 0; index < ips.length; index++) {  
                String strIp = (String) ips[index];  
                if (!("unknown".equalsIgnoreCase(strIp))) {  
                    ip = strIp;  
                    break;  
                }  
            }  
        }  
        return ip;  
    }  

}
