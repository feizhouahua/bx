<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课表下载</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="../../css/jedate.css">
<script type="text/javascript" src="../../js/jedate.js"></script>
<style type="text/css">
#ahref {
	float: right;
	margin-left: 10px;
}

table {
	margin: 0px auto;
	margin-top: 50px;
	width: 500px;
}

table tr td:nth-child(odd) {
	padding-left: 10px;
	font-weight: bolder;
}
</style>
</head>
<body>
	<form action="uploadb.html" method="post" enctype="multipart/form-data">
		<span style="font-size: 20px; font-weight: bolder;">[课表下载]</span> <input
			id="ahref" class="btn btn-sm btn-primary" type="submit" value="上传" />
		<input id="ahref" class="btn btn-sm btn-primary"
			onclick="history.go(-1)" type="button" value="返回">
		<table class="table table-striped">
			<tr>
				<td>id</td>
				<td>上传时间</td>
				<td>下载</td>
			</tr>
			<c:forEach items="${curriculumdownload}" var="download">
				<tr>
					<td>${download.id}</td>
					<td>${download.upload_time}</td>
					<td><a href="../../../upload/${download.newname}">下载</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<script type="text/javascript">
		
	</script>
</body>
</html>