<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>订单列表</p>
<form action="ResAllOrderServlet" method="post">
<input type="hidden" name="opType" value="2">
<input type="text" name="order_no">
<input type="submit" value="查询">
</form>
	<table>
		<tr>
			<td>订单号</td>
			<td>用户id</td>
			<td>地址id</td>
			<td>总价</td>
			<td>付款方式</td>
			<td>邮费</td>
			<td>订单状态</td>
			<td>支付/配送时间</td>
			<td>结束/关闭时间</td>
			<td>创建时间</td>
			<td>更新时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageModel.data}" var="pmd">
			<tr>
				<td>${pmd.order_no}</td>
				<td>${pmd.user.username}</td>
				<td>${pmd.address.receiver_name}-${pmd.address.receiver_phone}-${pmd.address.receiver_province}-${pmd.address.receiver_city}-${pmd.address.receiver_district}-${pmd.address.receiver_address}</td>
				<td>${pmd.payment}</td>
				<td>${pmd.payment_type}</td>
				<td>${pmd.postage}</td>
				<td>${pmd.status}</td>
				<td>${pmd.payment_time}/${pmd.send_time}</td>
				<td>${pmd.end_time}/${pmd.close_time}</td>
				<td>${pmd.create_time}</td>
				<td>${pmd.update_time}</td>
				<td><a href="ResAllOrderServlet?opType=2&order_no=${pmd.order_no}">查看</a>   <a href="OrderOperationServlet?opType=1&order_no=${pmd.order_no}">发货</a>   <a href="OrderOperationServlet?opType=2&order_no=${pmd.order_no}">取消</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalCount}" step="1">
			<a href="ResAllOrderServlet?pageNo=${pageNo}&pageSize=1&opType=1">${pageNo}  </a>
		</c:forEach>
</body>
</html>