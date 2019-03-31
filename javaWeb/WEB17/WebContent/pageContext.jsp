<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		//使用pageContext向request域存数据
		pageContext.setAttribute("name", "tony");
		pageContext.setAttribute("name", "huhu", pageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "huhu2", pageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "huhu3", pageContext.APPLICATION_SCOPE);
	%>
	
	<%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE) %>
	
	<!-- findAttribute会从小到大搜索域的范围中的name (找到就不继续找了)-->
	<!-- page域<request域<session域<application域 -->
	<%=pageContext.findAttribute("name") %>
	
	<%
		//pageContext可以获得其他8大隐式对象(写框架用)
		pageContext.getRequest();
		pageContext.getRequest();
	%>
</body>
</html>