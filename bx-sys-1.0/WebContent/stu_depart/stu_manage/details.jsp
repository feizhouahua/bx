<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h4>[编辑正式学员]</h4>
<div>
	<table>
		<tr><td>姓名:</td><td>${destudent.student_name }</td></tr>
		<tr><td>状态:</td><td>${destudent.state}</td></tr>
		<tr><td>类别:</td><td>${destudent.classes.course_type.course_name }</td></tr>
		<tr><td>班级:</td><td>${destudent.classes.classname }</td></tr>
		<tr><td></td><td><a href="queryStus.jsp">返回</a></td></tr>
	</table>
</div>

</body>
</html>