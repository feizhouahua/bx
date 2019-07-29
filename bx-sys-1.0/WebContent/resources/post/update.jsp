<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改职务</title>
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
	<span style="font-size: 20px;font-weight: bolder;">[职务管理]</span>
	<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="保存"/>
	<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
<table>
	<tr>
		<td>部门名称：</td>
		<td>
			<select style="height: 25px" id="depart" name="depart_name">
				 <option id="default" value="${post.department.depart_name}">${post.department.depart_name}</option>
			</select>
		</td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td>职务名称：</td>
		<td>
			<input type="text" name="post_name" value="${post.post_name}" required="required"/>
			<input type="hidden" name="id" value="${post.id}"/>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	$(function(){
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