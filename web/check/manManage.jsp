<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员管理界面</title>
</head>
<body>
<form action="deleteUser" method="post">
    <input type="text" name="uName" /><br/>
    <input type="submit" value="删除用户" />
</form>
<br/><br/><br/>
<form action="deleteBook" method="post">
    书籍名<input type="text" name="bookID" /><br/>
    <input type="submit" value="删除书籍" />
</form>
<br/><br/><br/>
<form action="addBook" method="post">
    书　籍　名：<input type="text" name="bookName" /><br/>
    作者序列号：<input type="text" name="authorID" /><br/>
    <input type="submit" value="添加书籍" />
</form>
<br/><br/><br/>
<a href = "count">查询用户人数</a>
</body>
</html>