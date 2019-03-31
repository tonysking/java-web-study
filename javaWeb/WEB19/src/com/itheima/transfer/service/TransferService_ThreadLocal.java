package com.itheima.transfer.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.transfer.dao.TransferDao;
import com.itheima.transfer.dao.TransferDao_ThreadLocal;
import com.itheima.utils.DataSourceUtils;

public class TransferService_ThreadLocal {

	public boolean transfer(String out, String in, double money) {
		
		TransferDao_ThreadLocal dao = new TransferDao_ThreadLocal();
		
		boolean isTransferSuccess = true;
		Connection conn = null;
		
		try {
			//开启事务
			DataSourceUtils.startTransaction();
			//转出钱方法
			dao.out(out,money);
			int i = 1/0;//测试转账失败(注意下面的异常不能抓SQLException)
			//转入钱方法
			dao.in(in,money);
			
		} catch (Exception e) {
			isTransferSuccess = false;
			//回滚事务
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return isTransferSuccess;
		
	}

}
