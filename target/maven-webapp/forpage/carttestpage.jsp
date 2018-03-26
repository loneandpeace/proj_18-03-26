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
	<a>共  ${cartCount} 件商品   </a><a href="SelectOptionServlet?opType=3">全选</a> <a href="SelectOptionServlet?opType=4">取消全选</a>
	<table>
			<tr>
				<th>id</th>
				<th>用户名</th>
				<th>商品</th>
				<th>数量</th>
				<th>选择状态</th>
				
				<th>创建/更新时间</th>
				<th>操作</th>
			</tr>
		<c:forEach items="${pageModel.data}" var="pmd">
			
			<tr>
				<td>${pmd.id}</td>
				<td>${sessionScope.username}</td>
				<td>${pmd.product.id}-${pmd.product.name}-${pmd.product.price}</td>
				<td>${pmd.quantity}</td>
				<td>${pmd.checked}</td>
				
				<td>${pmd.front_create_time}/${pmd.front_update_time}</td>
				<td> <a href="DeleteProductInCartServlet?id=${pmd.id}">删除</a> <a href="SelectOptionServlet?opType=1&id=${pmd.id}">选择</a> <a href="SelectOptionServlet?opType=2&id=${pmd.id}">取消选择</a>  <a href="UpdateCartProductInfoServlet?opType=1&id=${pmd.id}">修改数量</a></td>
			</tr>
			
		</c:forEach>
		<tr>
			<td colspan="7" align="center">
				<c:forEach var="pageNo" begin="1" end="${pageModel.totalCount}" step="1">
			 		<a href="ResAllProductInCartServlet?pageNo=${pageNo}">${pageNo}</a>
				</c:forEach>
			</td>
		</tr>
	</table>
	<form action="GenerateOrderServlet">
	<select name="shipping_id">
	<c:forEach items="${userAddress.data}" var="address">
		<option value="${address.id}">${address.receiver_name}-${address.receiver_province}-${address.receiver_city}</option>
	</c:forEach>
	<input type="submit" value="下单">
	</select>
	</form>    
	<a href="http://localhost:8080/homework_sp/forpage/ResAllOrderServlet?pageNo=1&pageSize=1&opType=1">查看订单</a>
</body>
</html>