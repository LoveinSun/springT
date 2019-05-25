<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% int a = Integer.valueOf(request.getParameter("p"));if(a!=0){a=1;} %>
<meta charset="UTF-8">
<title><% if(a==1){%>用户<%}else{%>管理员<%} %>登录界面</title>
</head>
<body>
	<form action="Check" method="post">
		<a>用户名:</a><input type=text name="name"/><br>
		<a>密　码:</a><input type=text name="pwd"/><br>
		<input type="hidden" name="key" value=<%=a%>>
		<input type=submit value=submit />
	</form>
</body>
</html>