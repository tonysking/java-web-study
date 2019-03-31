package com.itheima.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//创建属于该客户端(会话)的session区域-----不同浏览器即不同客户端 创建不同session
		/*request.getSession()方法内部会判断 该客户端在服务器是否已经存在session
		 *  若不存在     创建一个新的session对象
		 *  若存在         获得已经存在的该session返回
		 */
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "tony");
		
		String id = session.getId();//该session对象的编号id
		
		//手动创建一个存储JSESSIONID(默认存在一次会话的时间)的cookie  为该cookie设置持久化时间
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setPath("/WEB16/");
		cookie.setMaxAge(60*10);//10分钟
		
		response.addCookie(cookie);
		
		response.getWriter().write("JSESSIONID:"+id);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}