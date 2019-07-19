<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
</head>
<body>
<table class="table table-hover">
<tr><td>姓名</td><td></td><td></td><td>${qrefer.refername }</td></tr>
<tr><td>电话</td><td></td><td></td><td>${qrefer.tel }</td></tr>
<tr><td>QQ</td><td></td><td></td><td>${qrefer.QQ }</td></tr>
<tr><td>咨询人</td><td></td><td></td><td>${qrefer.marketer }</td></tr>
<tr><td>意向级别</td><td></td><td></td><td>${qrefer.intention_level }</td></tr>
<tr><td>意向学科</td><td></td><td></td><td>${qrefer.intention_subject }</td></tr>
<tr><td>来源</td><td></td><td></td><td>${qrefer.source }</td></tr>
<tr><td>备注</td><td></td><td></td><td>${qrefer.remarks }</td></tr>
</table>
<a href="query.jsp">返回</a>
</body>
</html>