<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理</title>
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
</style>
</head>
<body>
	<div>
	  <form action="list.html?page=1" method="post">	
		<span style="font-size: 20px;font-weight: bolder;">[员工管理]</span>
			<div id="right"><input class="btn btn-sm btn-primary" type="submit" value="高级查询"/>&nbsp;<a class="btn btn-sm btn-primary" href="add.jsp">添加</a></div>
		<br><br>
			部门：<select style="height: 25px" id="depart" name="depart_name">
					<option>--请选择部门--</option>
				</select>
			职务：<select style="height: 25px" id="post" name="post_name">
					<option  id="one">--请选择部职务-</option>
				</select>
			姓名：<input type="text" name="staff_name"/>
		
	   </form>
	</div>
	<br><br>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>员工姓名</th>
				<th>性别</th>
				<th>入职时间</th>
				<th>所属部门</th>
				<th>职务</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${staffs}" var="staff">
				<tr>
					<td>${staff.id}</td>
					<td>${staff.staff_name}</td>
					<td>${staff.sex}</td>
					<td>${staff.entry_time}</td>
					<td>${staff.post.department.depart_name}</td>
					<td>${staff.post.post_name}</td>
					<td><a href="updatea.html?id=${staff.id}"><img
							src="../images/bianji.png"></a></td>
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
			.after("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><tr>");
		}
			
	}
	
	$(function(){
		var depart="";
		$.ajax({
			url:"./ajax/depart.html",
			type:"get",
			dataType:"json",
			success:function(departobj){
				//alert(departobj);
				$(departobj).each(function(i,d){
					depart+="<option>"+departobj[i].depart_name+"</option>";
					
				});
				$("#depart option").after(depart);
			},
			error:function(){
				alert("ajax请求depart失败！");
			},
		});
	});
	
	$("#depart").change(function(){
		$(".op").remove();
		var post="";
		var depart_name=$('#depart').val();
		//alert(depart_name);
		$.ajax({
			url:"./ajax/post.html?depart_name="+depart_name,
			type:"get",
			dataType:"json",
			cache:false,
			success:function(postobj){
				//alert(postobj);
				$(postobj).each(function(i,p){
					post+="<option class='op'>"+postobj[i].post_name+"</option>";
				});	
				$("#post option").after(post);
			},
			error:function(){
				alert("ajax请求post失败！");
			},
		});
	});
	
</script>
</body>
</html>