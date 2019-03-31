package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//传递请求到service层
		ProductService service = new ProductService();
		List<Product> productlist = null;
		try {
			productlist = service.findAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//全部商品的数据准备好了 转发给jsp进行数据显示
		request.setAttribute("productlist", productlist);
		
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}