<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link href="./css/home.css" rel="stylesheet"/>
<!-- Bootstrap core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.navbar.navbar-inverse.navbar-fixed-top{
		background-color:rgb(51,122,183);
		height: 80px;
	}
	.leftsidebar_box{
		background-color: #4F4F4F;
		padding-top: 30px;
	}
	#navbar ul li span,a{
		color: white;
		font-size: 15px;
		margin-top:15px;
		display: inline-block;
	}
	#titlename{
		margin-top:5px;
		font-size: 25px;
		font-weight: bolder;
	}
	.nav.navbar-nav.navbar-right li{
		padding-right: 20px;
	}
	.nav.navbar-nav.navbar-right li a{
		color: white;
	}
	
</style>
</head>
<body>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<img alt="" src="./images/tupibao.png">
				<span id="titlename">补习学校后台管理系统</span>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><span>今天是：</span><span id="times"></span></li>
					<li><span>欢迎您:${loginUser.username}</span></li>
					<li><a href="change.html" target="nl">更改密码</a></li>
					<!-- 因为spring security默认为我们提供了退出操作，我们只需要访问特定的url就可以退出登录了 -->
					<li><a href="${pageContext.request.contextPath}/logout">重新登录</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="leftsidebar_box">
				<dl class="system_log">
					<dt onClick="changeImage()">
						咨询部<img src="./images/more.png">
					</dt>
					<dd class="first_dd">
						<a href="refer/referStu/into.html?page=1" target="nl">咨询学生管理</a>
					</dd>
					<dd>
						<a href="refer/queryStu/queryStu.html?page=1" target="nl">查询学生报名</a>
					</dd>
				</dl>

				<dl class="custom">
					<dt onClick="changeImage()">
						学工部<img src="./images/more.png">
					</dt>
					<dd class="first_dd">
						<a href="stu_depart/stu_manage/stus.html?page=1" target="nl">在校学生管理</a>
					</dd>
					<dd>
						<a href="#">学生升级/转班</a>
					</dd>
					<dd>
						<a href="#">学生流失情况</a>
					</dd>
				</dl>

				<dl class="channel">
					<dt>
						教学部<img src="./images/more.png">
					</dt>
					<dd class="first_dd">
						<a href="education/class/list.html?page=1" target="nl">班级管理</a>
					</dd>
					<dd>
						<a href="education/course_type/list.html?page=1" target="nl">课程类别</a>
					</dd>
				</dl>

				<dl class="app">
					<dt onClick="changeImage()">
						就业部<img src="./images/more.png">
					</dt>
					<dd class="first_dd">
						<a href="employments/information/list.html?page=1" target="nl">就业情况</a>
					</dd>
				</dl>

				<dl class="cloud">
					<dt>
						人力资源部<img src="./images/more.png">
					</dt>
					<dd class="first_dd">
						<a href="resources/department/list.html?page=1" target="nl">部门管理</a>
					</dd>
					<dd>
						<a href="resources/post/list.html?page=1" target="nl">职务管理</a>
					</dd>
					<dd>
						<a href="resources/staff/list.html?page=1" target="nl">员工管理</a>
					</dd>
					<dd>
				</dl>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">Section title</h2>
				<div class="table-responsive">
					<iframe name="nl" ref="iframe" src="hello.jsp" frameborder="no"></iframe>
				</div>
				
			</div>
		</div>
	</div>
	<script src="./js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript">
		$(".leftsidebar_box dt").css({
			"background-color" : "#4F4F4F"
		});
		$(".leftsidebar_box dt img").attr("src", "./images/more.png");
		$(function() {
			$(".leftsidebar_box dd").hide();
			$(".leftsidebar_box dt").click(
					function() {
						$(".leftsidebar_box dt").css({
							"background-color" : "#4F4F4F"
						})
						$(this).css({
							"background-color" : "rgb(51,122,183)"
						});
						$(this).parent().find('dd').removeClass("menu_chioce");
						$(".leftsidebar_box dt img").attr("src",
								"./images/more.png");
						$(this).parent().find('img').attr("src",
								"./images/more.png");
						$(".menu_chioce").slideUp();
						$(this).parent().find('dd').slideToggle();
						$(this).parent().find('dd').addClass("menu_chioce");
					});
		});
		//得到时间并写入div
		function getDate(){
		    //获取当前时间
		    var date = new Date();
		    //格式化为本地时间格式
			var date1 = date.toLocaleString();
			//获取div
			var span = document.getElementById("times");
			//将时间写入div
		 	span.innerHTML = date1;
		}
		//使用定时器每秒向div写入当前时间
		setInterval("getDate()",1000);
	</script>
</body>
</html>