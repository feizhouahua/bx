<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
</head>
<body>
<table  class="table table-hover">
<tr>
<td>姓名</td>
<td>电话</td>
<td>QQ</td>
<td>意向类别/班级</td>
<td>状态</td>
<td>营销人员</td>
<td>查看</td>
</tr>
	<c:forEach items="${queryStu }" var="w">
		<tr>
			<td>${w.refername }</td>
			<td>${w.tel }</td>
			<td>${w.QQ }</td>
			<td>${w.intention_subject }/${w.intention_class }</td>
			<td>${w.state }</td>
			<td>${w.marketer }</td>
			<td><a href="queryref.html?id=${w.id}">查看</a></td>
		</tr>
	</c:forEach>
	<tr>
	<td><a href="queryStu.html?pag=0">首页</a></td>
	<td><a href="queryStu.html?pag=${pag-1<1 ? 0 : pag-1}">上一页</a></td>
	<td><a href="queryStu.html?pag=${pag+1 > numq-1  ? numq-1 : pag+1 }">下一页</a></td>
	<td><a href="queryStu.html?pag=${numq }">尾页</a></td>
	</tr>
</table>
</body>
</html>