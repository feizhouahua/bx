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
				<td>部门名称</td>
				<td>
					<!-- <input type="text" name="depart_name"/> --> 
					<select style="height: 25px" id="depart" name="depart_name">
						<option>--请选择部门--</option>
					</select>
				</td>
				<td>职务名称</td>
				<td>
					<input type="text" name="post_name"/> 
				</td>
				<td><input type="submit" value="确认" /></td>
				<td><input onclick="history.go(-1)" type="button" value="返回"></td>
				
			</tr>
		</table>
	</form>
<script type="text/javascript">
$(function(){
	var depart="";
	$.ajax({
		url:"../staff/ajax/depart.html",
		type:"get",
		dataType:"json",
		success:function(departobj){
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
</script>
</body>
</html>