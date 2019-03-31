package design.patterns.decorator;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//request.setCharacterEncoding("UTF-8");//post提交解决中文乱码
		
		
		
		//在传递request之前对request的getParameter方法进行增强
		/*
		 * 装饰者模式
		 * 1.增强类与被增强类实现同一接口
		 * 2.在增强类中传入被增强的类
		 * 3.需要增强的方法重写 不需要增强的方法调用被增强对象的父类
		 */
//		//被增强对象
		HttpServletRequest req = (HttpServletRequest) request;
		//增强对象(装饰者)
		EnhanceRequest enhanceRequest = new EnhanceRequest(req);
		
		
		chain.doFilter(enhanceRequest, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
