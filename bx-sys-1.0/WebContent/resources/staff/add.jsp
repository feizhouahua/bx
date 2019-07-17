<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加部门</title>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<form action="add.html" method="post">
		<table>
			<tr>
				<td>登录名：</td>
				<td><input type="text" name="Loginname"/></td>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="staff_name"/></td>
				<td>性别：</td>
				<td>
					<input type="radio" name="sex" value="男" checked="checked"/>男
					<input type="radio" name="sex" value="女"/>女
				</td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td>
					<select style="height: 25px" id="depart" name="depart_name">
						<option>--请选择部门--</option>
					</select>
				</td>
				<td>职务：</td>
				<td>
					<select style="height: 25px" id="post" name="post_name">
						<option  id="one">--请选择部职务-</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>入职时间：</td>
				<td><input type="date" name="entry_time"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认" /></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
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