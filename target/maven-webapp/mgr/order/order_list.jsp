<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<style type="text/css">
	*{
		padding: 0;
		margin: 0;
	}
	td{
		border: none;
		padding: 2px 20px;
		text-align: center;
		font-size:15px;
	}
	th{
		border: none;
		padding: 2px 20px;
		text-align: center;
	}
	tr:nth-child(even) {
		background-color: gainsboro;
		border: none;
	}
	table{
		width:100%;
		border-spacing:0;
	}
	a{
		color: blue;
		text-decoration: none;
	}
	a:link,
	a:visited,
	a:active{
		color: blue;
	}
	a:hover{
		color: red;
	}
	p{
		display: inline-block;
		padding: 0 5px;
	}
	tr:last-child {
		background-color: white;
	}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<table>
	
		<tr>
			<th>订单号</th>
			<th>用户名</th>
			<th>地址id</th>
			<th>总价</th>
			<th>付款方式</th>
			<th>邮费</th>
			<th>订单状态</th>
			<th>支付/配送时间</th>
			<th>结束/关闭时间</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>操作</th>
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
				<td><a href="ResAllOrderServlet?optype=4&order_no=${pmd.order_no}">查看</a>   <a href="ResAllOrderServlet?optype=3&opType=1&order_no=${pmd.order_no}">发货</a>   <a href="ResAllOrderServlet?optype=3&opType=2&order_no=${pmd.order_no}">取消</a></td>
			</tr>
			
		</c:forEach>
		<tr>
			<td colspan="12">
				<c:forEach var="pageNo" begin="1" end="${pageModel.totalCount}" step="1">
					<a href="ResAllOrderServlet?pageNo=${pageNo}&pageSize=1&opType=1">${pageNo}  </a>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>