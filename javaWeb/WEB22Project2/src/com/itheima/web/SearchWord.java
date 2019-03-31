package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

import net.sf.json.JSONArray;

public class SearchWord extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得关键字
		String word = request.getParameter("word");
		
		//查询该关键字的所有商品
		ProductService service = new ProductService();
		List<Object> productList = null;
		try {
			productList = service.findProductByWord(word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		//[{"pname":"小米","shop_price":2988...},{},{}...]
		//使用json的转换工具将对象或集合转换成json格式的字符串
		/*JSONArray fromObject = JSONArray.fromObject(productList);
		String string = fromObject.toString();
		System.out.println(string);*/
		
		Gson gson = new Gson();
		String json = gson.toJson(productList);
		System.out.println(json);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}