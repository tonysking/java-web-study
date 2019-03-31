package cn.itheima.web.servlet;

import org.junit.Test;

public class TestMyServlet {

	@Test
	public void testMyServlet() {
		MyServletImpl my = new MyServletImpl();
		my.init();
		my.service();
		my.destroy();
	}
	//反射
	@Test
	public void testMyServlet1() {
		try {
			String className = "cn.itheima.web.servlet.MyServletImpl";
			Class clazz = Class.forName(className);
			MyServletImpl my = (MyServletImpl) clazz.newInstance();
			my.init();
			my.service();
			my.destroy();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}
}
