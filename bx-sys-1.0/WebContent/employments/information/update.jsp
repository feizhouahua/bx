<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改学员就业信息</title>
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
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<form action="updateb.html" method="post">
	<span style="font-size: 20px;font-weight: bolder;">[修改学员就业信息]</span>
		<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="保存"/>
		<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
		<table>
			<tr>
				<td>班级:</td>
				<td>
					<input type="hidden" name="id" value="${information.id}"/>
					<input type="text" name="class_name" value="${information.class_name}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>学生:</td>
				<td><input type="text" name="student_name" value="${information.student_name}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>就业公司:</td>
				<td><input type="text" name="employment_company" value="${information.employment_company}"/></td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>薪资:</td>
				<td><input type="text" name="salary" value="${information.salary}"/></td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>岗位:</td>
				<td><input type="text" name="post" value="${information.post}"/></td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>入职时间:</td>
				<td>
					<input type="text" name="Entry_time" class="jeinput" id="test04" value="${information.entry_time}">
				</td>
			</tr>
			<tr>
				<td>
					<br>
				</td>
			</tr>
			<tr>
				<td>备注:</td>
				<td><textarea rows="5" cols="30" name="description">${information.description}</textarea></td>
			</tr>
		</table>
</form>
<script type="text/javascript">
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
</body>
</html>