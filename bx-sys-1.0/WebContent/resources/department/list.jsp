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
	.table.table-striped{
		height: 240px;
		margin-top: 60px;
	}
</style>
</head>
<body>
	<span style="font-size: 20px;font-weight: bolder;">[部门管理]</span>
	<a id="ahref" class="btn btn-sm btn-primary" href="add.jsp">添加</a>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th colspan="2">部门名称</th>
				<th colspan="2">编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${departments}" var="department">
				<tr>
					<td>${department.id}</td>
					<td colspan="2">${department.depart_name}</td>
					<td colspan="2"><a href="updatea.html?id=${department.id}"><img
							src="../images/bianji.png"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="ahref">
		<a class="btn btn-xs btn-info" href="list.html?page=1">首页</a> 
		<a class="btn btn-xs btn-info" href="list.html?page=${page>1?page-1:1}">上一页</a>
		<a class="btn btn-xs btn-info" href="list.html?page=${page<pages?page+1:pages}">下一页</a>
		<a class="btn btn-xs btn-info" href="list.html?page=${pages}">末页</a>
	</div>

</body>
</html>