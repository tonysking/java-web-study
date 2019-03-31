package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

public class ProductDao {

	public List<Object> findProductByWord(String word) throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pname like ? limit 0,8";
		//List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class),"%"+word+"%");
		List<Object> productList = runner.query(sql, new ColumnListHandler("pname"),"%"+word+"%");
		return productList;
	}

}
