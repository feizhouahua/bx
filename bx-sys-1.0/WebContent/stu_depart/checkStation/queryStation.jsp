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
		<table class="table table-hover">
			<tr>
				<th>姓名</th><th>操作时间</th><th>操作类型</th><th>经办人</th><th>操作前的班</th><th>操作后的班</th>
			</tr>
			<c:forEach items="${station }" var="st">
				<tr>
					<td>${st.student_name }</td><td>${st.operating_time }</td><td>${st.operation_type }</td>
					<td>${st.manager }</td><td>${st.befor_classname }</td><td>${st.after_classname }</td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="xiaoyang.html?page=1">首页</a></td>
				<td><a href="xiaoyang.html?page=${page>1 ? page-1 : 1}">上一页</a></td>
				<td><a href="xiaoyang.html?page=${page < pagnums ? page +1: pagnums }">下一页</a></td>
				<td><a href="xiaoyang.html?page=${pagnums }">尾页</a></td>
				<td>${page }/${pagnums }</td>
			</tr>
		</table>
	</div>

</body>
</html>