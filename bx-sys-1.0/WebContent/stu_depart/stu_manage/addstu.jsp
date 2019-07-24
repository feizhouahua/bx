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
<form action="addstudent.html" method="post">
<table class="table table-hover">
<tr>
<td>姓名</td><td><input type="text" name="student_name" value="${referstu.student_name}"></td>
<td>性别</td><td><input type="radio" name="student_sex" value="男">男 
				<input type="radio" name="student_sex" value="女">女</td>
</tr>
<tr>
<td>应付学费：</td><td><input type="number" name="tuition_paid" value=""></td>
<td>实付学费：</td><td><input type="number" name="unpaid_tuition" value=""></td>
</tr>
<tr>
<td>身份证号码：</td><td><input type="text" name="Id_card" value="${referstu.id_card }"></td>
<td>手机号：</td><td><input type="text" name="Tel" value="${referstu.tel}"></td>
</tr>
<tr>
<td>QQ号：</td><td><input type="number" name="QQ" value="${referstu.QQ}"></td>
<td>邮箱：</td><td><input type="email" name="Email" value=""></td>
</tr>
<tr>
<td>就读班级：</td>
<td>类别<select class="course_name" name="course_name">
			<option value="">--选择学科--</option>
			<option value="java">java</option>
			<option value="ui">ui</option>
			<option value="web">web</option>
		</select>
		<select class="classname" name="classname">
			<option value="">--请选择--</option>
		</select>
		</td></tr>
<tr><td>毕业学校：</td><td><input type="text" name="graduated_school" value=""></td>
<td>学历：</td><td><select name="education">
					<option value="专科生">专科生</option>	
					<option value="本科生">本科生</option>	
					<option value="研究生">研究生</option>
					<option value="硕士生">硕士生</option>
					<option value="博士生">博士生</option>
				 </select> 
专业：<input type="text" name="profession"></td>
</tr>
<tr>
<td>身份证地址：</td><td><input type="text" name="card_address" value=""></td>
</tr>
<tr>
<td>在京地址：</td><td><input type="text" name="current_address" value=""></td>
</tr>
<tr>
<td>学员描述：</td><td><input type="text" name="student_description" value=""></td>
</tr>
<tr>
<td>家庭联系电话：</td><td><input type="text" name="family_tel" value=""></td>
<td>家庭联系人：</td><td><input type="text" name="family_people" value=""></td>
</tr>
</table>
<input type="submit" value="确认添加">
</form>
</body>
<script type="text/javascript">
	$(".course_name").change(function(){
		var course = $(".course_name").val();
		var text = "";
		$(".classname option:gt(0)").remove();
		$.ajax({
			url:"./ajax/course.html",
			type:"post",
			data:{course:course},
			dataType:"json",
			success:function(cla){
				$(cla).each(function(i,p){
					text+="<option>"+cla[i].classname+"</option>";
				});
				$(".classname option").after(text);
			},
			error:function(){
				alert("ajax请求失败")
			}
		});
	});
</script>
</html>