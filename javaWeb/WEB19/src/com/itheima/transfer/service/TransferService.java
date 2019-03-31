package com.itheima.transfer.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.transfer.dao.TransferDao;
import com.itheima.utils.DataSourceUtils;

public class TransferService {

	public boolean transfer(String out, String in, double money) {
		
		TransferDao dao = new TransferDao();
		
		boolean isTransferSuccess = true;
		Connection conn = null;
		
		try {
			//开启事务
			conn = DataSourceUtils.getConnection();
			conn.setAutoCommit(false);
			//转出钱方法
			dao.out(conn,out,money);
			int i = 1/0;//测试转账失败(注意下面的异常不能抓SQLException)
			//转入钱方法
			dao.in(conn,in,money);
			
		} catch (Exception e) {
			isTransferSuccess = false;
			//回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return isTransferSuccess;
		
	}

}
