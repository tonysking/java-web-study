package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//1.创建cookie对象
		Cookie cookie = new Cookie("name","huhu");//,"huhu"中间不能有空格
		
		//1.1为cookie设置持久化时间---在硬盘上保存时间
		cookie.setMaxAge(60*10);//10分钟----时间设置为0表示删除改cookie
		//1.2为cookie设置携带的路径
		//cookie.setPath("/WEB16/sendCookie");//访问sendCookie资源时才携带这个cookie
		cookie.setPath("/WEB16");	//访问WEB16下资源时都携带这个cookie
		//cookie.setPath("/");//访问服务器中所有资源都携带这个cookide
		//2.将cookie中存储的信息发送给客户端-头
		response.addCookie(cookie);
	 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}