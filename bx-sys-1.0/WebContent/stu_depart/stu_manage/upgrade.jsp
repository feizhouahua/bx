<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<form action="transferok.html" method="post">
${loginUser.username}
<input type="hidden" value="${upstudent.classes.classname}" name="oldclass">
${upstudent.classes.classname}
<input type="hidden" name="username" value="${loginUser.username}"/>
<input type="hidden" name="id" value="${upstudent.id}"/>
<input type="hidden" name="studentname" value="${upstudent.student_name }"/>




<table>
<tr><td>姓名:</td><td>${upstudent.student_name }</td></tr>
<tr><td>现在所在班级:</td><td>类别${upstudent.classes.course_type.course_name },班级${upstudent.classes.classname}</td></tr>
<tr><td>操作类型:</td>
<td>
<select name="opertype">
	<option>升级</option>
	<option>转班</option>
</select>
</td>
</tr>
<tr><td>操作学科:</td>
<td>
<select id="select" name="course_name">
</select>
</td>
<td>操作班级:</td>
<td>
<select id="select2" name="classname">
	<option class="bj">--班级--</option>
</select>
</td>
</tr>
</table>
<input type="submit" />
</form>
</body>
<script type="text/javascript">
	$(function(){
		var txt="";
		$.ajax({
			url:"./ajax/coursename.html",
			type:"post",
			dataType:"json",
			success:function(qwe){
				$(qwe).each(function(i,p){
					txt+="<option>"+qwe[i].course_name+"</option>";
				})
				$("#select").append(txt);
			},
			error:function(qwe){
				alert("error");
			},
		});
		setTimeout("s2()",60);
	});
	
	$("#select").change(function(){
		s2();
	})
	
	function s2(){
		var course = $("#select").val();
		var text = "";
		$("#select2 option:gt(0)").remove();
		$.ajax({
			url:"./ajax/course.html",
			type:"post",
			dataType:"json",
			data:{course:course},
			success:function(asd){
				$(asd).each(function(i,p){
					
					text+="<option>"+asd[i].classname+"</option>";
				});
				
				$(".bj").after(text);
			},
			error:function(){
				alert("error");
			}
		})
	}
</script>
</html>