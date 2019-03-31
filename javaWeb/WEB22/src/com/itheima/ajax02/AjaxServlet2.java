package com.itheima.ajax02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name+"  "+age);
		
		//返回json(---java代码只能返回一个json格式的字符串---)
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("{\"name\":\"中文\",\"age\":24}");
		//返回字符串
		//response.getWriter().write("success...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}