<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门管理</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<style type="text/css">
	#ahref{
		float: right;
	}
</style>
</head>
<body>
	<span>[职务管理]</span>
	<a id="ahref" href="add.jsp">添加</a>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th colspan="2">部门名称</th>
				<th colspan="2">职务名称</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td>${post.id}</td>
					<td colspan="2">${post.department.depart_name}</td>
					<td colspan="2">${post.post_name}</td>
					<td><a href="updatea.html?id=${department.id}"><img
							src="../images/bianji.png"></a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
				<div id="ahref">
				<a href="list.html?page=1">首页</a> 
				<a href="list.html?page=${page>1?page-1:1}">上一页</a>
				<a href="list.html?page=${page<pages?page+1:pages}">下一页</a>
			    <a href="list.html?page=${pages}">末页</a></div></td>
			</tr>
		</tbody>
	</table>


</body>
</html>