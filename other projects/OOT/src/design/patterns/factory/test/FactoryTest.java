package design.patterns.factory.test;


import java.sql.SQLException;

import design.patterns.factory.service.UserService;
import design.patterns.factory.utils.core.BeanFactory;
import design.patterns.factory.utils.core.ClassPathXmlApplicationContext;

public class FactoryTest {
	public static void main(String[] args) {
		//测试使用工厂模式获取service并调用dao登录方法
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("/design/patterns/factory/applicationContext.xml");
		UserService service = (UserService) beanFactory.getBean("UserService");
		try {
			service.login("tom", "123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
