package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itheima.jdbc.JDBCUtils_V1;
import cn.itheima.jdbc.JDBCUtils_V2;
import cn.itheima.jdbc.JDBCUtils_V3;

/**
 * 测试工具类
 * @author CG
 *
 */
public class TestUtils {
	/**
	 * 根据id更新信息方法
	 */
	@Test
	public void testUpdateById() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//	获取连接
			conn = JDBCUtils_V3.getConnection();
			//	编写sql语句
			String sql = "update tbl_user set upassword=? where uid=?";
			//	获取执行sql语句对象
			pstmt = conn.prepareStatement(sql);
			//	设置参数
			pstmt.setString(1, "hehe");
			pstmt.setInt(2, 3);
			//	执行更新操作
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("更新成功！");
			} else {
				System.out.println("更新失败");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			//	释放资源
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	
	}
	/**
	 * 根据id删除信息方法
	 */
	@Test
	public void testDeleteById() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//	获取连接
			conn = JDBCUtils_V3.getConnection();
			//	编写sql语句
			String sql = "delete from tbl_user where uid=?";
			//	获取执行sql语句对象
			pstmt = conn.prepareStatement(sql);
			//	设置参数
			pstmt.setInt(1, 2);
			//	执行插入操作
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("删除成功！");
			} else {
				System.out.println("删除失败");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			//	释放资源
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	
	}
	/**
	 * 添加用户信息
	 */
	@Test
	public void testAdd() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//	获取连接
			conn = JDBCUtils_V2.getConnection();
			//	编写sql语句
			String sql = "insert into tbl_user values(null,?,?)";
			//	获取执行sql语句对象
			pstmt = conn.prepareStatement(sql);
			//	设置参数
			pstmt.setString(1, "caogang");
			pstmt.setString(2, "caogang");
			//	执行插入操作
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			//	释放资源
			JDBCUtils_V2.release(conn, pstmt, null);
		}
	}
	/**
	 * 根据id查询用户信息
	 * 
	 */
	@Test
	public void testFindUserById() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//	获取连接
			conn = JDBCUtils_V1.getConnection();
			//	编写sql语句
			String sql = "select * from tbl_user where uid = ?";
			// 获取执行sql语句对象
			pstmt = conn.prepareStatement(sql);
			//	设置参数
			pstmt.setInt(1, 2);
			//	执行查询操作
			rs = pstmt.executeQuery();
			//	处理结果集
			while(rs.next()) {
				System.out.println(rs.getString(2)+"-----"+rs.getString("upassword"));
			}
			//	---------不能在此处释放资源
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//	释放资源
			JDBCUtils_V1.release(conn, pstmt, rs);
		}
	}
}
