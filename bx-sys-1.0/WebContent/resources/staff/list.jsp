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
	#ahref{
		float: right;
	}
</style>
</head>
<body>
	<span>[员工管理]</span>
	<a id="ahref" href="add.jsp">添加</a>
	<form action="">
		部门：<select style="height: 25px" id="depart" name="depart_name">
				<option>--请选择部门--</option>
			</select>
		职务：<select style="height: 25px" id="post" name="post_name">
				<option>--请选择部职务-</option>
			</select>
		姓名：<input type="text" name="staff_name"/>
		<input type="submit" value="高级查询"/>
	</form>
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
			<tr>
				<td colspan="7">
				<div id="ahref">
				<a href="list.html?page=1">首页</a> 
				<a href="list.html?page=${page>1?page-1:1}">上一页</a>
				<a href="list.html?page=${page<pages?page+1:pages}">下一页</a>
			    <a href="list.html?page=${pages}">末页</a></div></td>
			</tr>
		</tbody>
	</table>
<script type="text/javascript">
	$(function(){
		var depart="";
		var post="";
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
	$("#post option").empty();
	$("#depart").change(function(){
		
		var depart_name=$('#depart').val();
		alert(depart_name);
		$.ajax({
			url:"./ajax/post.html?depart_name="+depart_name,
			type:"get",
			dataType:"json",
			success:function(postobj){
				$(postobj).each(function(i,p){
					post+="<option>"+postobj[i].post_name+"</option>";
				});
				//postobj.delete();
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