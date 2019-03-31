package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.itheima.jdbc.DataSource.MyDataSource;
import cn.itheima.jdbc.DataSource.MyDataSource2;
import cn.itheima.jdbc.utils.JDBCUtils_V3;

public class TestMyDatasource {
	/**
	 * 添加用户
	 * 使用未改造过的Connection	
	 */
	@Test
	public void testAddUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//	1.创建自定义连接池对象
		MyDataSource datasource = new MyDataSource();
		try {
			//	2.从池子中获取连接
			conn = datasource.getConnection();
			String sql = "insert into tbl_user values(null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "吕布");
			pstmt.setString(2, "貂蝉");
			int rows = pstmt.executeUpdate();
			if(rows>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			datasource.backConnection(conn);
		}
	}
	
	/**
	 * 添加用户
	 * 通过装饰设计模式改造过的Connection	
	 */
	@Test
	public void testAddUser2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//	1.创建自定义连接池对象
		MyDataSource2 datasource = new MyDataSource2();
		try {
			//	2.从池子中获取连接
			conn = datasource.getConnection();
			String sql = "insert into tbl_user values(null,?,?)";
			//	-----必须在自定义的connection类（MyConnection）中重写prepareStatement方法
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "吕布2");
			pstmt.setString(2, "貂蝉2");
			int rows = pstmt.executeUpdate();
			if(rows>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	}
}
