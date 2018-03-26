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
	<form action="AddProductServlet" method="get">
	<input type="hidden" name="pageNo" value="1">
		<table>
			<tr>
				<td>类别:</td>
				<td>
					<select name="category_id">
						<c:forEach items="${cateidlist}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>商品名</td>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<td>副标题</td>
				<td><input type="text" name="subtitle" required="required"></td>
			</tr>
			<tr>
				<td>主图片</td>
				<td><input type="text" name="main_image" required="required"></td>
			</tr>
			<tr>
				<td>副图片</td>
				<td><input type="text" name="sub_images" required="required"></td>
			</tr>
			<tr>
				<td>详细描述</td>
				<td><input type="text" name="detail" required="required"></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price" required="required"></td>
			</tr>
			<tr>
				<td>库存量</td>
				<td><input type="number" name="stock" required="required"></td>
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
				<td colspan="2" align="center">
					<input type="reset" value="重置">
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>