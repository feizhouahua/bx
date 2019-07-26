<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>班级管理</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<style type="text/css">
	#right{
		float: right;
	}
	.table.table-striped{
		height: 240px;
	}
	a{
		margin-right: 10px;
	}
	table tr td{
		position: relative;
	}
	.time{	
		 opacity:0.6;
         position: absolute;
         z-index:0;
         right: 5px;
         width: 120px;
         top: 30px;  
	}
	#up{
		z-index: 1;
	}
	.upload:hover{
		
	}
</style>
</head>
<body>
	<div>
		<span style="font-size: 20px;font-weight: bolder;">[班级管理]</span>
		<div id="right"><a class="btn btn-sm btn-primary" href="add.jsp">添加</a></div>	
	</div>
	<br>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>班级名称</th>
				<th>所属课程</th>
				<th>开课时间</th>
				<th>毕业时间</th>
				<th>状态</th>
				<th>学生总数</th>
				<th>升学数</th>
				<th>转班数</th>
				<th>编辑</th>
				<th>查看</th>
				<th>课表</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${classes}" var="classs">
				<tr>
					<td>${classs.id}</td>
					<td>${classs.classname}</td>
					<td>${classs.course_type.course_name}</td>
					<td>${classs.opening_hours}</td>
					<td>${classs.graduation_time}</td>
					<td>${classs.state}</td>
					<td>${classs.student_number}</td>
					<td>${classs.entrance_number}</td>
					<td>${classs.transfer_number}</td>
					<td>${classs.refund_number}</td>
					<td><a id="up" href="updatea.html?id=${classs.id}"><img
						 	src="../images/bianji.png"></a></td>
					<td id="up">
						<a class="upload" href="uploada.html?id=${classs.id}">上传</a>
						<c:choose>
							<c:when test="${classs.upload_state eq '有'}">
								<a href="downloada.html?id=${classs.id}">下载</a>
							</c:when>
							<c:otherwise>
								<span>暂无</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="right" style="margin-top: 20px;">
		<a class="btn btn-xs btn-info" href="list.html?page=1">首页</a> 
		<a class="btn btn-xs btn-info" href="list.html?page=${page>1?page-1:1}">上一页</a>
		<a class="btn btn-xs btn-info" href="list.html?page=${page<pages?page+1:pages}">下一页</a>
		<a class="btn btn-xs btn-info" href="list.html?page=${pages}">末页</a>
	</div>
<script type="text/javascript">
	
	var table=$("table tr").length;
	if(table<6){
		for(var i = 1; i<=(6-table);i++){
			$("table tr:last")
			.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
		}	
	}
	
	$(".upload").hover(function(e){
		$(".time").remove();
		var id=$(this).parent("td").parent("tr").find("td:first").text();
		var post="";
		$.ajax({
			url:"./ajax/gettime.html",
			dataType:"json",
			type:"post",
			data:{"id":id},
			cache:false,
			success:function(time){
				$(time).each(function(i,p){
					post="<span class='time'>上次上传时间："+time[i].upload_time+"</span>";
				});	
				$(e.target).after(post);
			},
			error:function(){
				alert("ajax请求失败!");
			},
		});
		
	});
	
	$("td").mouseout(function(){
		$(".time").remove();
	});
	
	
</script>
</body>
</html>