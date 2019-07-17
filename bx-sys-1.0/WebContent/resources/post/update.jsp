<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改部门</title>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<form action="updateb.html" method="post">
<table>
	<tr>
		<td>部门名称</td>
		<td>
			<select style="height: 25px" id="depart" name="depart_name">
				 <option id="default" value="${post.department.depart_name}">${post.department.depart_name}</option>
			</select>
		</td>
		<td>职务名称：</td>
		<td>
			<input type="text" name="post_name" value="${post.post_name}"/>
			<input type="hidden" name="id" value="${post.id}"/>
		</td>
		<td><input type="submit" value="提交"/></td>
		<td><input onclick="history.go(-1)" type="button" value="返回"></td>
	</tr>
</table>
</form>
<script type="text/javascript">
	$(function(){
		alert("xxx");
		var depart="";
		var op=$("#default").val();
		$.ajax({
			url:"../staff/ajax/depart.html",
			type:"get",
			dataType:"json",
			success:function(departobj){
				$(departobj).each(function(i,d){
					if(departobj[i].depart_name!=op){						
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

</script>
</body>
</html>