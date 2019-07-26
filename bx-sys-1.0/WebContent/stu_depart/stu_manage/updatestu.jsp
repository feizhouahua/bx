<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
${referstu.student_sex},${referstu.classes.classname }${(referstu.student_sex=='女')?"checked":''}${(referstu.student_sex=='男')?'checked':''}
${referstu.email }
<form action="upstuok.html" method="post">
<input type="hidden" value="${referstu.id }" name="id"/>
<table class="table table-hover">
<tr>
<td>姓名</td><td><input type="text" name="student_name" value="${referstu.student_name}"></td>
<td>性别</td><td>
<input type="radio" name="student_sex" value="男" checked="${(referstu.student_sex=='男')? 'checked' :''}">男 
<input type="radio" name="student_sex" value="女" checked="${(referstu.student_sex=='女')? 'checked' :''}">女
				</td>
</tr>
<tr>
<td>应付学费：</td><td><input type="number" name="tuition_paid" value="${referstu.tuition_paid }"></td>
<td>实付学费：</td><td><input type="number" name="unpaid_tuition" value="${referstu.unpaid_tuition }"></td>
</tr>
<tr>
<td>身份证号码：</td><td><input type="text" name="Id_card" value="${referstu.id_card }"></td>
<td>手机号：</td><td><input type="text" name="Tel" value="${referstu.tel}"></td>
</tr>
<tr>
<td>QQ号：</td><td><input type="number" name="QQ" value="${referstu.QQ}"></td>
<td>邮箱：</td><td><input type="email" name="Email" value="${referstu.email }"></td>
</tr>
<tr>
<td>就读班级：</td>
<td>类别<select class="course_name" name="course_name">
			<option>--选择学科--</option>
			
		</select>
		班级:<select class="classname" name="classname">
			<option>--请选择--</option>
		</select>
		</td></tr>
<tr><td>毕业学校：</td><td><input type="text" name="graduated_school" value="${referstu.graduated_school }"></td>
<td>学历：</td><td><select name="education" class="education">
					<option>--请选择--</option>
					<option value="专科生">专科生</option>	
					<option value="本科生">本科生</option>	
					<option value="研究生">研究生</option>
					<option value="硕士生">硕士生</option>
					<option value="博士生">博士生</option>
				 </select> 
专业：<input type="text" name="profession" value="${referstu.profession }"></td>
</tr>
<tr>
<td>身份证地址：</td><td><input type="text" name="card_address" value="${referstu.card_address }"></td>
</tr>
<tr>
<td>在京地址：</td><td><input type="text" name="current_address" value="${referstu.current_address }"></td>
</tr>
<tr>
<td>学员描述：</td><td><input type="text" name="student_description" value="${referstu.student_description }"></td>
</tr>
<tr><td colspan = "5">出门在外，如果发生意外，我们将根据下面的信息联系学院家长</td></tr>
<tr>
<td>家庭联系电话：</td><td><input type="text" name="family_tel" value="${referstu.family_tel }"></td>
<td>家庭联系人：</td><td><input type="text" name="family_tel" value="${referstu.family_people }"></td>
</tr>
</table>
<input type="submit" value="确认修改">   
</form>
</body>
<script type="text/javascript">
	
		var txt = ""
		$.ajax({
			url:"./ajax/coursename.html",
			type:"post",
			dataType:"json",
			success:function(cour){
				$(cour).each(function(i,p){
					txt+= "<option  value="+cour[i].course_name+">"+cour[i].course_name+"</option>";
				}),
				$(".course_name option").after(txt);
			},
			error:function(){
				alert("error");
			},
		});
		setTimeout('okcourse()',10);
		setTimeout('okclass()',40);
		okeducation();
	function okcourse(){
		var course_name = $(".course_name>option");
		for(var i=0;i<course_name.length;i++){
			var num = course_name[i].value;
			if(num=='${course }'){
				course_name[i].selected=true;
			}
		}
		quclass();
	}
	
	function quclass(){
		var txet =""; 
		var course = $(".course_name").val();
		$.ajax({
			url:"./ajax/course.html",
			type:"post",
			data:{course:course},
			dataType:"json",
			success:function(classes){
				$(classes).each(function(i,p){
					txet+= "<option value="+classes[i].classname+">"+classes[i].classname+"</option>";
				}),
				$(".classname option").after(txet);
			},
			error:function(){
				alert("error");
			},
		});
	}	
	
	function okclass(){
		var ha = '${referstu.classes.classname}';
		var classnam = $(".classname>option");
		for(var i=0;i<classnam.length;i++){
			num = classnam[i].value;
			if(num==ha){
				classnam[i].selected=true;
			}
		}
	}
	
	function okeducation(){
		var ha = '${referstu.education}';
		var education = $(".education>option");
		for(var i=0;i<education.length;i++){
			num = education[i].value;
			if(num==ha){
				education[i].selected=true;
			}
		}
	}
	
	$(".course_name").change(function(){
		quclass();
	})
</script>
</html>