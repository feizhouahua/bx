<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div>
		<table class="table table-hover">
			<tr>
				<th>姓名</td><td>QQ</th><th>联系电话</th><th>以前的班级</th><th>流失原因</th><th>业务时间</th>
				<th>经办人</th><th>是否退款</th>
			</tr>
			<c:forEach items="${runoff }" var="run">
				<tr>
					<td>${run.student_name }</td><td>${run.QQ }</td><td>${run.tel }</td>
					<td>${run.befor_classname }</td><td>${run.cause }</td><td>${run.business_time }</td>
					<td>${run.manager }</td><td>${run.refund }</td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="intorunoff.html?page=1">首页</a></td>
				<td><a href="intorunoff.html?page=${page>1 ? page-1 : 1}">上一页</a></td>
				<td><a href="intorunoff.html?page=${page < pagnums ? page +1: pagnums }">下一页</a></td>
				<td><a href="intorunoff.html?page=${pagnums }">尾页</a></td>
				<td>${page }/${pagnums }</td>
			</tr>
		</table>
	</div>
</body>
</html>