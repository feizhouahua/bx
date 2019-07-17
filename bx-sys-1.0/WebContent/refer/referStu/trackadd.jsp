<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addtrack.html" method="post">
<textarea rows="16" name="txt" cols="56"></textarea>
<input type="hidden" value="${refer.id }" name="id"/>
<%-- <input type="hidden" value="${user.username }"/> --%>
<input type="hidden" value="110" name="name"/>
<input type="submit" value="提交">
</form>
<a href="table.jsp">返回</a>
</body>
</html>