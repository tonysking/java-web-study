<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html注释 (翻译后的servlet、页面显示html源码 均可见) -->
	<!-- jsp被翻译后的servlet在tomcat/ work文件夹中 -->
	<%
		//翻译到service()方法 内部
		//	java单行注释
		int i = 0;
		/*
			java多行注释
		*/
		System.out.println(i);
	%>
	<%-- jsp注释 (仅jsp源码可见) --%>
	<%-- 翻译为 service方法内部的out.print()--%>
	<%=i%>
	
	<%!
		//翻译 为  servlet 成员 变量或方法
		String str = "jsp <%!";
		public void fun(){
			
		}
	%>
	
	<%=str %>
	
	<h1>jsp(java server page)</h1>
</body>
</html>