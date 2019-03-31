package design.patterns.factory.service;

import java.sql.SQLException;

import design.patterns.factory.dao.UserDao;


public class UserService {
	private UserDao userdao;
	public void login(String username, String password) throws SQLException {
		userdao.login(username,password);
	}

	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
}
