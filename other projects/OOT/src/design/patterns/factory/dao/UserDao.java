package design.patterns.factory.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;

public class UserDao {
	
	
	public void login(String username, String password) throws SQLException {

		System.out.println("用户名："+username+" 密码："+password);
		
	}



//	public User login(String username, String password) throws SQLException {
//
//		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		String sql = "select * from user where username=? and password=?";
//		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
//	}

}
