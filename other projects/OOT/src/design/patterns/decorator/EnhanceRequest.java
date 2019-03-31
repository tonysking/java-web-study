package design.patterns.decorator;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EnhanceRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	
	public EnhanceRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	//对getParameter进行增强
	@Override
	public String getParameter(String name) {
		String parameter = request.getParameter(name);//中文乱码
		try {
			if (parameter!=null) {
				
				parameter = new String(parameter.getBytes("iso8859-1"),"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return parameter;
	}
}
