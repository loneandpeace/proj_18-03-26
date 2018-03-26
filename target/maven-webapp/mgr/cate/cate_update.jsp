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
	<form action="UpdateCateServlet" method="get">
		<input type="hidden" name="id" value="${cate.id}">
		<table>
			<tr>
				<td>父级id:</td>
				<td>
					<select name="parentid">
						<option value="0">无父级</option>
						<c:forEach items="${parentidlist}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="name" required="required" value="${cate.name}"></td>
			</tr>
			<tr>
				<td>状态</td>
				<td>
					<select name="status">
						<option value="1">使用中</option>
						<option value="0">失效</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>优先级</td>
				<td><input type="number" name="sortorder" required="required"  value="${cate.sort_order}"></td>
			</tr>
			<tr>
				<td  colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>