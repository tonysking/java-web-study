package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;

public class ProductService {

	//根据关键字查询商品
	public List<Object> findProductByWord(String word) throws SQLException {

		ProductDao dao = new ProductDao();
		
		return dao.findProductByWord(word);
	}

}
