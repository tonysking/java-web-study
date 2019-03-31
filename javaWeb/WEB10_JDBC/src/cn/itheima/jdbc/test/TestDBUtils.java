package cn.itheima.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itheima.jdbc.utils.C3P0Utils;

/**
 * 测试DBUtils工具类的增删改操作
 * @author CG
 *
 */
public class TestDBUtils {
	
	/**
	 * 添加所有用户方法
	 */
	@Test
	public void testAddUser() {
		
		try {
			//1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2.编写sql语句
			String sql = "insert into tbl_user values(null,?,?)";
			//3.为占位符设置值
			Object[] params = {"于怀","耿耿"};
			//4.执行添加操作
			int rows = qr.update(sql,params);
			if(rows>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据Id修改用户方法
	 */
	@Test
	public void testUpdateUserById() {
		
		try {
			//1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2.编写sql语句
			String sql = "update tbl_user set upassword=? where uid=?";
			//3.为占位符设置值
			Object[] params = {"xxx", 13};
			//4.执行添加操作
			int rows = qr.update(sql,params);
			if(rows>0) {
				System.out.println("修改成功！");
			} else {
				System.out.println("修改失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据Id	删除用户方法
	 */
	@Test
	public void testdeleteUserById() {
		
		try {
			//1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2.编写sql语句
			String sql = "delete from tbl_user where uid=?";
			//3.为占位符设置值
			Object[] params = {5};
			//4.执行添加操作
			int rows = qr.update(sql,params);
			if(rows>0) {
				System.out.println("删除成功！");
			} else {
				System.out.println("删除失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
