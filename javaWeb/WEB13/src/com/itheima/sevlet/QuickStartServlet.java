package com.itheima.sevlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStartServlet implements Servlet{

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//1.获得servlet的<servlet-name>abc</servlet-name>
		String servletName = config.getServletName();
		System.out.println(servletName);
		//2.获得servlet初始化参数
		String initParameter = config.getInitParameter("url");
		System.out.println(initParameter);
		//3.获得servletcontext对象
		ServletContext servletContext = config.getServletContext();
		
		System.out.println("WEB13/QuickStartServlet---(<load-on-startup>3)---init...");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse res) throws ServletException, IOException {
		System.out.println("service...");
		res.getWriter().write("service...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
