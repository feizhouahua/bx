<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<form id="frm" action="queryStu.html">
查询条件： <input type="text" name="txts" value="${txts }">  姓名|QQ|电话
</form>
<table  class="table table-hover">
<tr>
<td>姓名</td>
<td>电话</td>
<td>QQ</td>
<td>意向类别/班级</td>
<td>状态</td>
<td>营销人员</td>
<td>查看</td>
</tr>
	<c:forEach items="${queryStu }" var="w">
		<tr>
			<td>${w.refername }</td>
			<td>${w.tel }</td>
			<td>${w.QQ }</td>
			<td>${w.intention_subject }/${w.intention_class }</td>
			<td>${w.state }</td>
			<td>${w.marketer }</td>
			<td><a href="queryref.html?id=${w.id}">查看</a></td>
		</tr>
	</c:forEach>
	<tr>
	<td></td>
	<td><a href="queryStu.html?txt=${txt }&page=1"><button type="button" class="btn btn-link">首页</button></a></td>
	<td><button type="button" class="btn btn-link"><a href="queryStu.html?txt=${txt }&page=${pag>1 ? pag-1 : 1}">上一页</a></button></td>
	<td><button type="button" class="btn btn-link"><a href="queryStu.html?txt=${txt }&page=${pag < numq ? pag +1: numq }">下一页</a></button></td>
	<td><button type="button" class="btn btn-link"><a href="queryStu.html?txt=${txt }&page=${numq }">尾页</a></button></td>
	<td>${qupag }/${numq }</td>
	<td></td>
	</tr>
</table>
</body>
<script type="text/javascript">
$("[name='txts']").blur(function(){
	$("#frm").submit();
})
</script>
</html>