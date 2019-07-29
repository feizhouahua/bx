<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生升级/转班</title>
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
		<span style="font-size: 20px;font-weight: bolder;">[学生升级/转班]</span>
		<br><br><br>
		<table class="table table-striped">
			<tr>
				<th>姓名</th>
				<th>操作时间</th>
				<th>操作类型</th>
				<th>经办人</th>
				<th>操作前的班</th>
				<th>操作后的班</th>
			</tr>
			<c:forEach items="${station }" var="st">
				<tr>
					<td>${st.student_name }</td>
					<td>${st.operating_time }</td>
					<td>${st.operation_type }</td>
					<td>${st.manager }</td>
					<td>${st.befor_classname }</td>
					<td>${st.after_classname }</td>
				</tr>
			</c:forEach>
		</table>
		<div id="right" style="margin-top: 20px;">
			<a class="btn btn-xs btn-info" href="xiaoyang.html?page=1">首页</a> 
			<a class="btn btn-xs btn-info" href="xiaoyang.html?page=${page>1 ? page-1 : 1}">上一页</a>
			<a class="btn btn-xs btn-info" href="xiaoyang.html?page=${page < pagnums ? page +1: pagnums }">下一页</a>
			<a class="btn btn-xs btn-info" href="xiaoyang.html?page=${pagnums }">末页</a>
		</div>
	</div>
</body>
<script type="text/javascript">
var table=$("table tr").length;
if(table<6){
	for(var i = 1; i<=(6-table);i++){
		$("table tr:last")
		.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
	}
		
}
</script>
</html>