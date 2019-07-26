<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课表上传</title>
<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
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
<form action="uploadb.html" method="post" enctype="multipart/form-data">
<span style="font-size: 20px;font-weight: bolder;">[课表上传]</span>
<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="上传"/>
<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
<table>
	<tr>
		<td>班级名称:</td>
		<td>${classupload.classname}</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>所属类别:</td>
		<td>${classupload.course_type.course_name}</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>上次上传时间:</td>
		<td>
			<c:choose>
				<c:when test="${not empty curriculums}">
					<c:forEach items="${curriculums}" var="curriculum" varStatus="status">
						<c:if test="${status.last}">
							<span>${curriculum.upload_time}</span>
						</c:if>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<span>无</span>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>选择课表：</td>
		<td>
			<input type="hidden" name="id" value="${classupload.id}"/>
			<input type="file" name="filename"/>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	
</script>
</body>
</html>