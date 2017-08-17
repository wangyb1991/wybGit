<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src = "jquery-2.1.4.min.js" style = "text/javascript"></script>
<script type = "text/javascript">
	$(document).ready(function(){
		$("#firstButton").on("click",function(){
			var name = $("#first").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/firstServlet",
				type:"GET",
				data:{"name":name},
				/* async:false, */
				dataType:"text",
				success:function(data){
					$("#firstSpan").html(data);
				}
			});
		});
		$("#secondButton").on("click",function(){
			var name = $("#second").val();
			$.ajax({
				url:"<%=request.getContextPath()%>/secondServlet",
				type:"GET",
				data:{"name":name},
				/* async:false, */
				dataType:"text",
				success:function(data){
					$("#secondSpan").html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	first:<input type = "text" id = "first" />
	<input type = "button" id = "firstButton" value = "first" /><span id = "firstSpan"></span><br/>
	second:<input type = "text" id = "second" />
	<input type = "button" id = "secondButton" value = "second" /><span id = "secondSpan"></span><br/>
</body>
</html>