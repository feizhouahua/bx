<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加跟踪信息</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	#ahref{
		float: right;
		margin-left: 10px;
	}
	div{
		margin-left: 300px;
		margin-top: 100px;
	}
</style>
</head>
<body>
	<form action="addtrack.html" method="post">
		<br><br>
		<span style="font-size: 20px;font-weight: bolder;">[添加跟踪信息]</span>
		<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
		<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="提交">
		<div>
			<textarea rows="16" name="txt" cols="56"></textarea>
			<input type="hidden" value="${refer.id }" name="id" />
			<input type="hidden" value="110" name="name"/>
		</div>
	</form>
</body>
</html>