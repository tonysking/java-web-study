package com.itheima.web;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class AutoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		//获得cookie中的用户名和密码进行登录操作
		//定义cookie_username和cookie_password
		String cookie_username = null;
		String cookie_password = null;
		//获得cookie
		Cookie[] cookies = req.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				//获得 名字是   cookie_username 和 cookie_password
				if ("cookie_username".equals(cookie.getName())) {
					cookie_username = cookie.getValue();
					
					//恢复中文用户名
					cookie_username = URLDecoder.decode(cookie_username, "UTF-8");
				}
				if ("cookie_password".equals(cookie.getName())) {
					cookie_password = cookie.getValue();
				}
			}
			
		}
		
	
		//判断用户名 和 密码 是否为空
		if (cookie_username!=null && cookie_password!=null) {
			//登录 的 代码
			UserService service = new UserService();
			User user = null;
			try {
				user = service.login(cookie_username,cookie_password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//将登录的用户对象存到session中
			session.setAttribute("user", user);
			
		}
		
		//放行
		chain.doFilter(req, resp);
		
		
	}

	@Override
	public void destroy() {
		
	}

	
}
