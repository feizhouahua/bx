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
  		margin-top: 200px;
	}
	.log{
		width: 300px;
   		margin: 0 auto;
	}
	.form-signin-heading{
		font-size: 30px;
	}
	button{
		background-color: bule;
	}
</style>

<!-- Bootstrap core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./css/signin.css" rel="stylesheet">
</head>
<body>
<div id="center">
<div class="container">
		  <c:if test="${not empty param.error}">
		  	<span style="color: red">用户名或密码错误!</span>
		  </c:if>
          <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
            <h3 class="form-signin-heading"><strong>补习学校后台管理系统</strong></h3>
            <br>
            <div class="log">
               <label for="inputEmail" class="sr-only">用户名</label>
               <input name="username" type="text" id="inputEmail" class="form-control" placeholder="用户名" required autofocus><br>
               <label for="inputPassword" class="sr-only">密码</label>
               <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required><br>
               <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
            </div>
          </form>
      </div> <!-- /container -->
</div>
</body>
</html>