<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<td>登录名：</td>
				<td><input type="text" name="Loginname" value="${staff.loginname}"/></td>
				<td>密码：</td>
				<td><input type="password" name="password" value="${staff.password}"/></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="staff_name" value="${staff.staff_name}"/></td>
				<td>性别：</td>
				<td>
					<input type="radio" name="sex" value="男"/>男
					<input type="radio" name="sex" value="女"/>女
				</td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td>
					<select style="height: 25px" id="depart" name="depart_name">
						<option id="d_default" value="${staff.post.department.depart_name}">${staff.post.department.depart_name}</option>
					</select>
				</td>
				<td>职务：</td>
				<td>
					<select style="height: 25px" id="post" name="post_name">
						<option id="p_default" value="${staff.post.post_name}">${staff.post.post_name}</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>入职时间：</td>
				<td><input id="date" type="date" name="entry_time" value="${staff.entry_time}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认" /></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
	var date=${staff.entry_time};
	var timestamp2 = Date.parse(new Date(date));
	newDate.setTime(timestamp2);
	$("input[name='entry_time']").val()=newDate.toLocaleString();
</script>
</body>
</html>