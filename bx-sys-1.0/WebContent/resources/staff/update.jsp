<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改员工</title>
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
	}
	table tr td:nth-child(odd){
		padding-left:10px;
		font-weight: bolder;
	}
</style>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<form action="updateb.html" method="post">
	<span style="font-size: 20px;font-weight: bolder;">[员工管理]</span>
		<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="保存"/>
		<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
		<table>
			<tr>
				<td>登录名：</td>
				<td><input type="text" name="Loginname" value="${staff.loginname}"/></td>
				<td>密码：</td>
				<td><input type="password" name="password" value="${staff.password}"/></td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="staff_name" value="${staff.staff_name}"/></td>
				<td>性别：</td>
				<td>
					<input type="radio" id="man" name="sex" value="男"/>男
					<input type="radio" id="woman" name="sex" value="女"/>女
				</td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td>
					<select style="height: 25px" id="depart" name="depart_name">
						<option id="d_default">${staff.post.department.depart_name}</option>
					</select>
				</td>
				<td>职务：</td>
				<td>
					<select style="height: 25px" id="post" name="post_name">
						<option id="p_default">${staff.post.post_name}</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>入职时间：</td>
				<td><input id="date" type="datetime" name="entry_time" value="${staff.entry_time}"/></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="id" value="${staff.id}"/>
				</td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
$(function(){
	
	var sex='${staff.sex}';
	var man=$("#man").val();
	var woman=$("#woman").val();
	if(sex==man){
		$("#man").attr("checked","true");
	}else if(sex==woman){
		$("#woman").attr("checked","true");
	}
	
	
	var depart="";
	$.ajax({
		url:"./ajax/depart.html",
		type:"get",
		dataType:"json",
		success:function(departobj){
			//alert(departobj);
			$(departobj).each(function(i,d){
				if($("#d_default").val()!=departobj[i].depart_name){				
					depart+="<option>"+departobj[i].depart_name+"</option>";
				}
				
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
	//var s=$("#p_default").clone();
	//$(".op").after(s);
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
			$("#post").append(post);
			$("#p_default").remove();
			
		},
		error:function(){
			alert("ajax请求post失败！");
		},
	});
});
</script>
</body>
</html>