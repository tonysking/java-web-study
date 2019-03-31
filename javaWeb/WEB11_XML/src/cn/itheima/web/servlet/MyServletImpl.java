package cn.itheima.web.servlet;

public class MyServletImpl implements MyServlet {

	@Override
	public void init() {
		System.out.println("我来了...");
	}

	@Override
	public void service() {
		System.out.println("我来服务了...");
	}

	@Override
	public void destroy() {
		System.out.println("我走了...");
	}

}
