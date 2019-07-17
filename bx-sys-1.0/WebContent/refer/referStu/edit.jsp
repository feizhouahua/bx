<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
<form action="upup.html" method="post">
<input type="hidden" name="id" value="${xgrefer.id }">
<table>
<tr><td>姓名</td><td></td><td></td><td><input type="text" name="refername" value="${xgrefer.refername }"> </td></tr>
<tr><td>电话</td><td></td><td></td><td><input type="text" name="tel" value="${xgrefer.tel }"></td></tr>
<tr><td>QQ</td><td></td><td></td><td><input type="text" name="QQ" value="${xgrefer.QQ }"></td></tr>
<tr><td>意向级别</td><td></td><td></td><td>
<select id="level" name="intention_level">
			<option value="A">A.已肯定，等时间</option>
			<option value="B">B.想报名，考虑中</option>
			<option value="C">C.考虑中，是否报</option>
		</select>
		</td></tr>
<tr><td>咨询人</td><td></td><td></td><td>
<select id="subject" name="intention_subject">
			<option value="JAVA">JAVA</option>
			<option value="UI">UI</option>
			<option value="WEB">WEB</option>
		</select>
 </td>
<td>
意向班级:
<select id="class" name="intention_class">
			<option value="JAVA1班">JAVA1班</option>
			<option value="UI1班">UI1班</option>
			<option value="WEB1班">WEB1班</option>
		</select>
</td></tr>
<tr><td>来源</td><td></td><td></td><td>
<select id="source" name="source">
			<option value="JAVA1班">JAVA1班</option>
			<option value="UI1班">UI1班</option>
			<option value="WEB1班">WEB1班</option>
		</select>
<input type="text" name="source" value="${xgrefer.source }"></td></tr>
<tr><td>备注</td><td></td><td></td><td><input type="text" name="remarks" value="${xgrefer.remarks }"></td></tr>
</table>
<input type="submit" value="确定更改">
</form>
</body>
<script type="text/javascript">
var level = $("#level>option");
for(var i=0;i<level.length;i++){
	var num = level[i].value
		if(num=='${xgrefer.intention_level }'){
			level[i].selected=true;
		}
}
alert(1)
var cla = $("#class>option");
for(var i=0;i<cla.length;i++){
	var num = cla[i].value
		if(num=='${xgrefer.intention_class }'){
			cla[i].selected=true;
		}
}
alert(2)
var subject = $("#subject>option");
for(var i=0;i<subject.length;i++){
	var num = subject[i].value
		if(num=='${xgrefer.intention_subject }'){
			subject[i].selected=true;
		}
}
alert(3)
var source = $("#source>option");
for(var i=0;i<source.length;i++){
	var num = source[i].value
		if(num=='${xgrefer.source }'){
			source[i].selected=true;
		}
}
</script>
</html>