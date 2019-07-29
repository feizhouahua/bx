<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生流失情况</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
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
	<div>
		<br><br>
		<span style="font-size: 20px;font-weight: bolder;">[学生流失情况]</span>
		<br><br><br>
		<table class="table table-striped">
			<tr>
				<th>姓名</th>
				<th>QQ</th>
				<th>联系电话</th>
				<th>以前的班级</th>
				<th>流失原因</th>
				<th>业务时间</th>
				<th>经办人</th>
				<th>是否退款</th>
			</tr>
			<c:forEach items="${runoff }" var="run">
				<tr>
					<td>${run.student_name }</td>
					<td>${run.QQ }</td>
					<td>${run.tel }</td>
					<td>${run.befor_classname }</td>
					<td>${run.cause }</td>
					<td>${run.business_time }</td>
					<td>${run.manager }</td>
					<td>${run.refund }</td>
				</tr>
			</c:forEach>
		</table>
		<div id="right" style="margin-top: 20px;">
			<a class="btn btn-xs btn-info" href="intorunoff.html?page=1">首页</a> 
			<a class="btn btn-xs btn-info" href="intorunoff.html?page=${page>1 ? page-1 : 1}">上一页</a>
			<a class="btn btn-xs btn-info" href="intorunoff.html?page=${page < pagnums ? page +1: pagnums }">下一页</a>
			<a class="btn btn-xs btn-info" href="intorunoff.html?page=${pagnums }">末页</a>
		</div>
	</div>
<script type="text/javascript">
var table=$("table tr").length;
if(table<6){
	for(var i = 1; i<=(6-table);i++){
		$("table tr:last")
		.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
	}
		
}
</script>
</body>
</html>