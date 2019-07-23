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
<form id="form" action="into.html">
查询条件： <input type="text" name="txt" value="${txt }">  姓名|QQ|电话
</form>
<table class="table table-hover">
<tr>
<td>姓名</td>
<td>电话</td>
<td>QQ</td>
<td>意向类别/班级</td>
<td>状态</td>
<td>营销人员</td>
<td>查看</td>
<td>编辑</td>
<td>跟踪</td>
<td>录入学籍</td>
</tr>
	<c:forEach items="${refers }" var="w">
		<tr>
			<td>${w.refername }</td>
			<td>${w.tel }</td>
			<td>${w.QQ }</td>
			<td>${w.intention_subject }/${w.intention_class }</td>
			<td>${w.state }</td>
			<td>${w.marketer }</td>
			<td><a href="chakan.html?id=${w.id}">查看</a></td>
			<td><a href="xiugai.html?id=${w.id}">编辑</a></td>
			<td><a href="genzong.html?id=${w.id}">跟踪</a></td>
			<td><a href="enter.html?id=${w.id}">录入学籍</a></td>
		</tr>
	</c:forEach>
	<tr>
	<td><a href="into.html?txt=${txt }&page=1">首页</a></td>
	<td><a href="into.html?txt=${txt }&page=${page>1 ? page-1 : 1}">上一页</a></td>
	<td><a href="into.html?txt=${txt }&page=${page < nums ? page +1: nums }">下一页</a></td>
	<td><a href="into.html?txt=${txt }&page=${nums }">尾页</a></td>
	<td>${page }/${nums }</td>
	</tr>
</table>
</body>
<script type="text/javascript">
$("[name='txt']").blur(function(){
	$("#form").submit();
})
</script>
</html>