<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateCartProductInfoServlet" method="post">
		<input type="hidden" name="id" value="${cartforedit.id}">
		<input type="hidden" name="opType" value="2">
		<table>
			<tr>
				<td>数量：</td>
				<td><input type="text" name="quantity"></td>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</from>
</body>
</html>