<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<link href="../../css/dashboard.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	#right{
		float: right;
	}
	.table.table-striped{
		height: 240px;
	}
</style>
</head>
<body>
	<span style="font-size: 20px;font-weight: bolder;">[咨询管理]</span>
	<div id="right">
	<form id="form" action="into.html">
		查询条件： <input type="text" name="txt" value="${txt }"> 姓名|QQ|电话
	</form>
	</div>
	<br><br><br><br>
	<table class="table table-striped">
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
	</table>
	<div id="right" style="margin-top: 20px;">
		<a class="btn btn-xs btn-info" href="into.html?txt=${txt }&page=1">首页</a> 
		<a class="btn btn-xs btn-info" href="into.html?txt=${txt }&page=${page>1 ? page-1 : 1}">上一页</a>
		<a class="btn btn-xs btn-info" href="into.html?txt=${txt }&page=${page < nums ? page +1: nums }">下一页</a>
		<a class="btn btn-xs btn-info" href="into.html?txt=${txt }&page=${nums }">尾页</a>
	</div>
</body>
<script type="text/javascript">
	var table=$("table tr").length;
	if(table<6){
		for(var i = 1; i<=(6-table);i++){
			$("table tr:last")
			.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
		}
		
	}

	$("[name='txt']").blur(function() {
		$("#form").submit();
	})
</script>
</html>