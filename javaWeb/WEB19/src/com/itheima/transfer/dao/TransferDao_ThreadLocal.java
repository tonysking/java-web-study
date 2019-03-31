package com.itheima.transfer.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.utils.DataSourceUtils;

public class TransferDao_ThreadLocal {

	public void out(String out, double money) throws SQLException {

		QueryRunner runner = new QueryRunner();
		Connection conn = DataSourceUtils.getConnection();
		String sql = "update account set money=money-? where name=?";
		runner.update(conn, sql, money,out);
		
	}

	public void in(String in, double money) throws SQLException {
		
		QueryRunner runner = new QueryRunner();
		Connection conn = DataSourceUtils.getConnection();
		String sql = "update account set money=money+? where name=?";
		runner.update(conn, sql, money,in);
		
	}

}
