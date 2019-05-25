<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理界面</title>
</head>
<body>
    <form action="addChoose" method="post">
        <a>用户id：</a><input type="text" name="userID" /><br/>
        <a>书籍序列号：</a><input type="text" name="bookID" /><br/>
        <a>借阅起始时间：</a><input type="text" name="begin" /><br/>
        <a>借阅终止时间：</a><input type="text" name="end" /><br/>
        <input type="submit" value="添加借阅信息" /><br/>
    </form>
    <br/><br/><br/>
    <form action="deleteChoose" method="post">
        <a>用户id：</a><input type="text" name="userID" /><br/>
        <a>书籍序列号：</a><input type="text" name="bookID" /><br/>
        <input type="submit" value="删除借阅信息" /><br/>
    </form>
    <br/><br/><br/>
    <form action="searchAuthor" method="post">
        <a>书籍序列号：</a><input type="text" name="bookID" /><br/>
        <input type="submit" value="查询书籍信息" /><br/>
    </form><br/><br/><br/>
    <form action="addEnd" method="post">
        <a>用户id：</a><input type="text" name="userID" /><br/>
        <a>书籍序列号：</a><input type="text" name="bookID" /><br/>
        <a>延长还书时间至：</a><input type="text" name="nEnd" /><br/>
        <input type="submit" value="查询书籍信息" /><br/>
    </form>
</body>
</html>