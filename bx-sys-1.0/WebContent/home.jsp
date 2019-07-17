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

</head>
<body>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<span>今天是：</span><span id="times"></span>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><span>欢迎您:${loginUser.username}</span></li>
					<li><a href="#">更改密码</a></li>
					<li><a href="#">重新登录</a></li>
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
						<a href="refer/referStu/into.html">咨询学生管理</a>
					</dd>
					<dd>
						<a href="#">查询学生报名</a>
					</dd>
				</dl>

				<dl class="custom">
					<dt onClick="changeImage()">
						学工部<img src="./images/more.png">
					</dt>
					<dd class="first_dd">
						<a href="#">在校学生管理</a>
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
						<a href="#">班级管理</a>
					</dd>
					<dd>
						<a href="#">课程类别</a>
					</dd>
				</dl>

				<dl class="app">
					<dt onClick="changeImage()">
						就业部<img src="./images/more.png">
					</dt>
					<dd class="first_dd">
						<a href="#">就业情况</a>
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
					<iframe name="nl" ref="iframe" src="" frameborder="no"></iframe>
				</div>
				
			</div>
		</div>
	</div>
	<script src="./js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript">
		$(".leftsidebar_box dt").css({
			"background-color" : "#3992d0"
		});
		$(".leftsidebar_box dt img").attr("src", "./images/more.png");
		$(function() {
			$(".leftsidebar_box dd").hide();
			$(".leftsidebar_box dt").click(
					function() {
						$(".leftsidebar_box dt").css({
							"background-color" : "#3992d0"
						})
						$(this).css({
							"background-color" : "#317eb4"
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