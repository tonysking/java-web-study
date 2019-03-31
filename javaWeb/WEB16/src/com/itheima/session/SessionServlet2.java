package com.itheima.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//从session中获得存储的数据
		HttpSession session = request.getSession();
		
		Object attribute = (String) session.getAttribute("name");//不写成object会报错
		
		response.getWriter().write(attribute+"");//注意+""   在访问不到时才可显示null
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}