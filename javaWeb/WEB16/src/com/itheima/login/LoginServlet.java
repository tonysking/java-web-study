package com.itheima.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		//验证码校验
		//获得页面输入的验证码
		String checkCode_client = request.getParameter("checkCode");
		//获得生成图片的文字的验证码
		String checkCode_session = (String) request.getSession().getAttribute("checkcode_session");
		//对比 输入的 和 生成 的验证码 是否一致
		if (!checkCode_client.equals(checkCode_session)) {
			request.setAttribute("loginInfo", "您的验证码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;//直接返回 不检验用户名和密码
		}
		
		
		//获得页面的用户名和密码进行数据校验
		//...
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}