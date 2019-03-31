package cn.itheima.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;




/**
 * 测试sql注入问题
 * @author CG
 *
 */
public class TestLogin {
	@Test
	public void testLogin() {
		try {
			login("乎乎'or'乎乎", "666");	//	乎乎'or'乎乎也会登录成功
				//	select * from tbl_user where uname='乎乎'or'乎乎' and upassword='666'
			login1("乎乎'or'乎乎", "666");	//	乎乎'or'乎乎报错
				//	防止sql注入问题（字符串拼接问题）
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void login(String username, String password) throws ClassNotFoundException, SQLException {
		//	注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//	获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "6666");
		//	创建执行sql语句的对象
		Statement stmt = conn.createStatement();
		//	书写sql语句
		String sql = "select * from tbl_user where "+"uname='"+username+"' and upassword='"+password+"'";
		//	执行sql语句
		ResultSet rs = stmt.executeQuery(sql);
		//	对结果集处理
		if(rs.next()) {
			System.out.println("hi!"+username+"登录成功！");
			System.out.println(sql);
		} else {
			System.out.println("错误！");
		}
		if(rs!=null) {
			rs.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}

	public void login1(String username, String password) throws ClassNotFoundException, SQLException {
		//	注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//	获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "6666");
		//	编写sql语句
		String sql = "select * from tbl_user where uname=? and upassword=?";
		//	创建预处理对象
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//	设置参数（将？占位符替换成实际参数）
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		//	执行查询操作
		ResultSet rs = pstmt.executeQuery();	//	--------------注意此处不需要参数
		if(rs.next()) {
			System.out.println("hi!"+username+"登录成功！");
			System.out.println(sql);
		} else {
			System.out.println("错误！");
		}
		if(rs!=null) {
			rs.close();
		}
		if(pstmt!=null) {
			pstmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
	
}
