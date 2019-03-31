<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="0kb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	A
	<%
		out.write("b");
		response.getWriter().write("c");
		//Tomcat引擎response缓冲区获得内容 out缓冲区的内容（a b d）会移到response缓冲区（c）
		//所以输出 顺序为 c a b d
		//----若将buffer（默认8kb）设为0（out缓冲区关闭） 内容直接写response缓冲区 输出为  a b c d
	%>
	<%="d" %>
</body>
</html>