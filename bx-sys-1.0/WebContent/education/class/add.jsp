<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>班级管理</title>
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
<form action="add.html" method="post">
<span style="font-size: 20px;font-weight: bolder;">[班级管理]</span>
<input id="ahref" class="btn btn-sm btn-primary" type="submit" value="保存"/>
<input id="ahref" class="btn btn-sm btn-primary" onclick="history.go(-1)" type="button" value="返回">
<table>
	<tr>
		<td>班级名称:</td>
		<td><input type="text" name="classname"  required="required"/></td>
		<td>所属类别:</td>
		<td>
			<select style="height: 25px;" id="course" name="course_name">
				<option>--请选择--</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>开课时间:</td>
		<td><input type="text" class="jeinput" id="test04" placeholder="YYYY-MM-DD" name="opening_hours"  required="required"/></td>
		<td>结业时间:</td>
		<td><input type="text" class="jeinput" id="test05" placeholder="YYYY-MM-DD" name="graduation_time"  required="required"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>班级总人数:</td>
		<td><input type="text" value="0" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4">其他说明:</td>
	</tr>
	<tr>
		<td colspan="4"><textarea required="required" rows="8" cols="60" name="other_notes"></textarea></td>
	</tr>
</table>
</form>
<script type="text/javascript">
	$(function(){
		var a="";
		$.ajax({
			url:"./ajax/course.html",
			type:"get",
			dataType:"json",
			cache:false,
			success:function(courseobj){
				//alert("ajax请求成功!");
				$(courseobj).each(function(i,d){
					a+="<option>"+courseobj[i].course_name+"</option>";
				});
				$("#course option").after(a);
			},
			error:function(){
				alert("ajax请求失败!");
			},
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
        
        donefun: function(obj){
        	 var aa = obj.val;
        	 jeDate("#test05",{
        	        festival:true,
        	        minDate:aa,              			//最小日期为开课日期
        	        maxDate:"2099-12-31",              //最大日期
        	        method:{
        	            choose:function (params) {
        	                
        	            }
        	        },
        	        format: "YYYY-MM-DD"
        	    }); 
        },
        format: "YYYY-MM-DD"
    });
	
</script>
</body>
</html>