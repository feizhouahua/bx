<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td>姓名</td><td></td><td></td><td>${refer.refername }</td></tr>
<tr><td>电话</td><td></td><td></td><td>${refer.tel }</td></tr>
<tr><td>QQ</td><td></td><td></td><td>${refer.QQ }</td></tr>
<tr><td>咨询人</td><td></td><td></td><td>${refer.marketer }</td></tr>
<tr><td>意向级别</td><td></td><td></td><td>${refer.intention_level }</td></tr>
<tr><td>意向学科</td><td></td><td></td><td>${refer.intention_subject }</td></tr>
<tr><td>来源</td><td></td><td></td><td>${refer.source }</td></tr>
<tr><td>备注</td><td></td><td></td><td>${refer.remarks }</td></tr>

<tr><td>跟踪信息</td><td></td><td></td><td><a href="trackadd.jsp">添加跟踪</a></td></tr>
</table>
<a href="table.jsp">返回</a>
</body>
</html>