package cn.itheima.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//向request域中存数据
		request.setAttribute("name", "tom");
		
		
		//servlet1将请求转发给servlet2
		//获得转发器
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet2");
		//执行转发的方法
		dispatcher.forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}