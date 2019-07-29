<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改密码</title>
<!-- Bootstrap core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./css/dashboard.css" rel="stylesheet">
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
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
<form action="update.html" method="post">
<span style="font-size: 20px;font-weight: bolder;">[更改密码]</span>
<input id="ahref" class="btn btn-sm btn-primary" type="submit" id="sub" value="修改"/>
<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
<table>
	<tr>
		<td>原始密码:</td>
		<td>
			<input type="hidden" name="id" value="${sessionScope.loginUser.id}"/>
			<input type="password" name="password"/>
		</td>
	</tr>
	<tr>
		<td><br></td>
	</tr>
	<tr>
		<td>新密码:</td>
		<td>
			<input type="password" name="newpassword"/>
		</td>
	</tr>
	<tr>
		<td><br></td>
	</tr>
	<tr>
		<td>确认密码:</td>
		<td>
			<input type="password" name="oknewpassword"/>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	//$("[id='sub']").click(function(){	
	$("[name='oknewpassword']").mouseleave(function(){		
		$("#error").remove();
		if($("[name='newpassword']").val()!=$("[name='oknewpassword']").val()){
			$("[name='oknewpassword']").after("<span id='error' style='color:red;position:absolute;'>两次输入的密码不一样!</span>");
		}else{
			$("#error").remove();	
		}
	});
	$("[name='oknewpassword']").blur(function(){		
		$("#error").remove();
		if($("[name='newpassword']").val()!=$("[name='oknewpassword']").val()){
			$("[name='oknewpassword']").after("<span id='error' style='color:red;position:absolute;'>两次输入的密码不一样!</span>");
		}else{
			$("#error").remove();	
		}
	});
</script>
</body>
</html>