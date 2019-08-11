<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="<%=basePath%>css/index.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<body>
	<table>
		<tr>
			<td></td>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品描述</td>
		</tr>
		<c:forEach items="${slist }" var = "s">
			<tr>
				<td>${s.sid }</td>
				<td>${s.sname }</td>
				<td>${s.sex }</td>
				<td>${s.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>