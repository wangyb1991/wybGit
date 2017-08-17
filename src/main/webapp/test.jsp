<!-- page attribute -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- this is a jsp test -->
	
	<!-- declare -->
	<%! int a = 5;
		int b = 7; %>
	
	<!-- expression -->
	<!-- cannot end with ";" -->
	<p>the result is <%= a+b %></p>
	
	<!-- script & built-in object -->
	<%out.println("我是jsp输出的"); %>
	<br/>
	<%
		for(int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++){
				out.print(i*j+" ");
			}
			out.println("<br/>");
		}
	%>
	
</body>
</html>