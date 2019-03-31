package com.itheima.transfer.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.transfer.service.TransferService;
import com.itheima.transfer.service.TransferService_ThreadLocal;

public class TransferServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//接受转账参数
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		String moneyStr = request.getParameter("money");
		double money = Double.parseDouble(moneyStr);
		
		//调用业务层的转账方法
		//---service中手动conn开启事务
		//TransferService service = new TransferService();
		//---service中采用ThreadLocal
		TransferService_ThreadLocal service = new TransferService_ThreadLocal();
		
		boolean isTransferSuccess = service.transfer(out,in,money);
		
		response.setContentType("text/html;charset=UTF-8");
		if (isTransferSuccess) {
			response.getWriter().write("转账成功！");
		}else {
			response.getWriter().write("转账失败！");
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}