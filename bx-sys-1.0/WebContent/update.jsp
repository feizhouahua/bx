<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改密码</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<style type="text/css">
	#ahref{
		float: right;
		margin-left: 10px;
	}
	table{
		margin: 0px auto; 
		margin-top: 50px;
		font-weight: bolder;
	}
</style>
</head>
<body>
<form action="updateb.html" method="post">
<span style="font-size: 20px;font-weight: bolder;">[更改密码]</span>
<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="修改"/>
<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
<table>
	<tr>
		<td>原始密码:</td>
		<td>
			<input type="hidden" name="id" value="${sessionScope.loginUser.id}"/>
			<input type="text" name="password"/>
		</td>
	</tr>
	<tr>
		<td>新密码:</td>
		<td>
			<input type="text" name="newpassword"/>
		</td>
	</tr>
	<tr>
		<td>确认密码:</td>
		<td>
			<input type="text" name="oknewpassword"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>