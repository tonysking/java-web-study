package cn.itheima.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererServlet extends HttpServlet {
	//获取referer用于防盗
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//对新闻来源进行判断
		String header = request.getHeader("referer");
		if (header!=null && header.startsWith("http://localhost")) {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("中国真的获得了冠军...");
		} else {
			response.getWriter().write("该链接为盗链...");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}