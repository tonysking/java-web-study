package cn.itheima.web.servlet1;

public class MyServlet1 implements MyServlet{

	@Override
	public void init() {
		System.out.println("MyServlet1出现了...");
	}

	@Override
	public void service() {
		System.out.println("MyServlet1开始服务了...");
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet1销毁了...");
	}

}
