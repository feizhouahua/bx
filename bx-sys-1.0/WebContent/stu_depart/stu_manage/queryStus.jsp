<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div>
<form action="stus.html" method="post">
查询条件：<input type="text" name="text" value="">(姓名|电话|QQ|性别) 
课程类别：
<select id="course" name="course">
			<option value="">---请选择---</option>
			<option value="java">java</option>
			<option value="ui">ui</option>
			<option value="web">web</option>
		</select>
<select id="classname" name="classname">
			<option value="">---请选择---</option>
		</select>
<input type="submit" value="超级查询">
</form>
<table class="table table-hover">
<tr><td>姓名</td><td>入学时间</td><td>班级</td><td>QQ</td><td>联系电话</td>
<td>已付/应付学费</td><td>状态</td><td>编辑</td><td>升级/转班</td><td>查看</td><td>流失</td>
</tr>
<c:forEach items="${students }" var="s">
<tr>
<td>${s.student_name }</td>
<td>${s.admission_time }</td>
<td>${s.classes.classname }</td>
<td>${s.QQ }</td>
<td>${s.tel }</td>
<td>${s.tuition_paid }/${s.unpaid_tuition }</td>
<td>${s.state }</td>
<td>编辑</td>
<td>升级/转班</td>
<td>查看</td>
<td>流失</td>
</tr>
</c:forEach>
</table>
${count }
</div>
</body>
<script>
	$("#course").change(function(){
		var course = $("#course").val();
		var post = "";
		$.ajax({
			url:"./ajax/post.html",
			type:"post",
			data:{course:course},
			dataType:"json",
			cache:false,
			success:function(cla){
				alert(cla);
				/* alert("success");
				//$("#course option:gt(0)").remove();
				 $(cla).each(function(i,p){
					post+="<option>"+cla[i]+"</option>";
				});
				$("#classname option").after(post); */
			},
			error:function(){
				alert("ajax请求失败");
			},
		}); 
	});
</script>
</html>