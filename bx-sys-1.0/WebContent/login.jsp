<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<style type="text/css">
	body{
		background-image:url("./images/backgroud.png"); 
		background-repeat:no-repeat;
       	background-size:100%;  	
	}
	#center{
		text-align: center;
  		height: 100%;
  		position: fixed;
  		width: 100%;
  		margin-top: 150px;
	}
	.log{
		width: 300px;
   		margin: 0 auto;
   		position: relative;
	}
	.form-signin-heading{
		font-size: 30px;
	}
	#inputimageCode{
		width: 150px;
	}
	#image{
		display: inline-block;
		position: absolute;
		right: 20px;
		top: 130px;
	}
	button{
		background-color: bule;
	}
</style>

<!-- Bootstrap core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./css/signin.css" rel="stylesheet">
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="center">
<div class="container">
		  <span id="error" style="color: red"></span>
          <form id="loginForm" class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
            <h3 class="form-signin-heading"><strong>补习学校后台管理系统</strong></h3>
            <br>
            <div class="log">
               <label for="inputEmail" class="sr-only">用户名</label>
               <input name="username" type="text" id="inputEmail" class="form-control" placeholder="用户名" required autofocus><br>
               <label for="inputPassword" class="sr-only">密码</label>
               <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required><br>
               <label for="inputimageCode" class="sr-only">验证码</label>
               <input name="imageCode" type="text" id="inputimageCode" class="form-control" placeholder="验证码" required>
               <img id="image" alt="验证码" src="${pageContext.request.contextPath}/imageCode.html"><br>
               <button class="btn btn-lg btn-primary btn-block" id="loginBtn" type="button">登录</button>
            </div>
          </form>
      </div> <!-- /container -->
</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#loginBtn").click(function(){
			$("#error").empty();
			$.post("${pageContext.request.contextPath}/login",$("#loginForm").serialize(),function(data){
				if(data.success){
					window.location.href="${pageContext.request.contextPath}/home.html";
				}else{
					if(data.error!=null){
						$("#error").append(data.error);
					}else if(data.errorMsg!=null){
						$("#error").append(data.errorMsg);
					}else{
						if(data.success==false){
							$("#error").append("用户名或密码错误!");
						}
					}
				}
			},"json");
		});
	});
	$(function() {
		if (window != top) {
		top.location.href = location.href;
		}
	});
	
</script>
</html>