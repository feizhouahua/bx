<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改部门</title>
</head>
<body>
<form action="updateb.html" method="post">
<table>
	<tr>
		<td>部门名称</td>
		<td>
			<input type="hidden" name="id" value="${post.id}"/>
			<input type="text" name="post_name" value="${post.post_name}"/>
		</td>
		<td><input type="submit" value="提交"/></td>
	</tr>
</table>
</form>
</body>
</html>