package cn.itheima.web.servlet1;

public class MyServlet2 implements MyServlet{

	@Override
	public void init() {
		System.out.println("MyServlet2出现了...");
	}

	@Override
	public void service() {
		System.out.println("MyServlet2开始服务了...");
	}

	@Override
	public void destroy() {
		System.out.println("MyServlet2销毁了...");
	}

}
