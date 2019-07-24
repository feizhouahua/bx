<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询学生报名</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	#right{
		float: right;
	}
	
</style>
</head>
<body>
	<br><br>
	<span style="font-size: 20px;font-weight: bolder;">[查询学生报名]</span>
	<div id="right">
	<form id="frm" action="queryStu.html">
		查询条件： <input type="text" name="txts" value="${txts }">
		姓名|QQ|电话
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
	</table>
	<div id="right" style="margin-top: 20px;">
		<a class="btn btn-xs btn-info" href="queryStu.html?txts=${txts }&page=1">首页</a> 
		<a class="btn btn-xs btn-info" href="queryStu.html?txts=${txts }&page=${pag>1 ? pag-1 : 1}">上一页</a>
		<a class="btn btn-xs btn-info" href="queryStu.html?txts=${txts }&page=${pag < numq ? pag +1: numq }">下一页</a>
		<a class="btn btn-xs btn-info" href="queryStu.html?txts=${txts }&page=${numq }">尾页</a>
	</div>
</body>
<script type="text/javascript">
	
	var table=$("table tr").length;
	if(table<6){
		for(var i = 1; i<=(6-table);i++){
			$("table tr:last")
			.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
		}
	}

	$("[name='txts']").blur(function() {
		$("#frm").submit();
	})
</script>
</html>