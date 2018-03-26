<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		padding: 0;
		margin: 0;
	}
	table{
		margin: 15px;
	}
	td{
		padding: 2px 5px;
	}
	select,td:nth-child(2) input{
		width: 150px;
	}
	tr:last-child input{
		padding: 0px 15px
	}
</style>
</head>
<body>
	<form action="ResAllUserServlet?opType=4" method="post">
	<input type="hidden" name="pageNo" value="1">
		<table>
			<tr>
				<td>用户名</td>
				<td>
					<input type="text" name="username" required="required"/>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" required="required"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="reset" value="重置">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>