package com.itheima.header;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date date = new Date();
		
		//设置响应头
		response.addHeader("name", "cg");
		response.addIntHeader("age",23);
		response.addDateHeader("birthday", date.getTime());
		
		response.addHeader("name", "huhu");
		
		response.setIntHeader("age", 26);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}