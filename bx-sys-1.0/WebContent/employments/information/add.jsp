<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加就业信息</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="../../css/jedate.css">
<script type="text/javascript" src="../../js/jedate.js"></script>
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
</head>
<body>
<form action="add.html" method="post">
<span style="font-size: 20px;font-weight: bolder;">[添加学院就业信息]</span>
<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="保存"/>
<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
<table>
	<tr>
		<td>班级:</td>
		<td>
			<select id="classname" name="class_name">
				<option>--请选择班级--</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			<br>
		</td>
	</tr>
	<tr>
		<td>学生:</td>
		<td>
			<select id="studentname" name="student_name">
				<option id="s_default">--请选择学生--</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			<br>
		</td>
	</tr>
	<tr>
		<td>就业公司:</td>
		<td><input type="text" name="employment_company"/></td>
	</tr>
	<tr>
		<td>
			<br>
		</td>
	</tr>
	<tr>
		<td>薪资:</td>
		<td><input type="text" name="salary"/></td>
	</tr>
	<tr>
		<td>
			<br>
		</td>
	</tr>
	<tr>
		<td>岗位:</td>
		<td><input type="text" name="post"/></td>
	</tr>
	<tr>
		<td>
			<br>
		</td>
	</tr>
	<tr>
		<td>入职时间:</td>
		<td><input type="text" name="Entry_time" class="jeinput" id="test04" placeholder="YYYY-MM-DD hh:mm:ss"></td>
	</tr>
	<tr>
		<td>
			<br>
		</td>
	</tr>
	<tr>
		<td>备注:</td>
		<td><textarea rows="5" cols="30" name="description"></textarea></td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var classname="";
		$.ajax({
			url:"./ajax/classname.html",
			type:"get",
			dataType:"json",
			success:function(classobj){
				$(classobj).each(function(i,c){
					classname+="<option>"+classobj[i].classname+"</option>";
				});
				$("#classname option").after(classname);
			},
			error:function(){
				alert("ajax请求失败!");
			}
		});
	});
	$("#classname").change(function(){
		$(".op").remove();
		var studentname="";
		var classname=$("#classname").val();
		$.ajax({
			url:"./ajax/studentname.html?classname="+classname,
			type:"get",
			dataType:"json",
			success:function(studentobj){
				$(studentobj).each(function(i,s){
					studentname+="<option class='op'>"+studentobj[i].student_name+"</option>";
				});	
				$("#studentname").append(studentname);
				$("#s_default").remove();
			},
			error:function(){
				alert("ajax请求失败!");
			}
		});
	});
	
	jeDate("#test04",{
	    festival:true,
	    minDate:"1900-01-01",              //最小日期
	    maxDate:"2099-12-31",              //最大日期
	    method:{
	        choose:function (params) {
	            
	        }
	    },
	    format: "YYYY-MM-DD hh:mm:ss"
	});
</script>
</html>