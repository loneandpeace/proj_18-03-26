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
	td{
		border: none;
		padding: 2px 20px;
		text-align: center;
		font-size:14px;
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
</head>
<body>
<div style="background-color: #99CCCC;">
	<p>订单信息：</p>
	<hr>
</div>

<table>
		<tr>
			<th>订单号</th>
			<th>用户id</th>
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
		
		<tr>
			<td>${orderVo.order_no}</td>
			<td>${orderVo.user.username}</td>
			<td>${orderVo.address.receiver_name}-${orderVo.address.receiver_phone}-${orderVo.address.receiver_province}-${orderVo.address.receiver_city}-${orderVo.address.receiver_district}-${orderVo.address.receiver_address}</td>
			<td>${orderVo.payment}</td>
			<td>${orderVo.payment_type}</td>
			<td>${orderVo.postage}</td>
			<td>${orderVo.status}</td>
			<td>${orderVo.payment_time}/${orderVo.send_time}</td>
			<td>${orderVo.end_time}/${orderVo.close_time}</td>
			<td>${orderVo.create_time}</td>
			<td>${orderVo.update_time}</td>
			<td><a href="ResAllOrderServlet?optype=3&opType=1&order_no=${orderVo.order_no}">发货</a>   <a href="ResAllOrderServlet?optype=3&opType=2&order_no=${orderVo.order_no}">取消</a></td>
		</tr>
	
	</table>

<div style="background-color: #99CCCC;">
	<p>详情：</p>
	<hr>
</div>
<table>
		<!-- <tr>
			<td>订单号:${orderVo.order_no}</td>
		</tr> -->
		<tr>
			<!-- <td>用户</td> -->
			<th>商品名</th>
			<th>商品图片</th>
			<th>单价</th>
			<th>应付</th>
			<th>数量</td>
			<th>总价</th>
			<th>创建时间</th>
			<th>更新时间</th>
		</tr>
		<c:forEach items="${orderVo.orderItems}" var="pmd">
			<tr>
				<!-- <td>${username}</td> -->
				<td>${pmd.product_name}</td>
				<td>${pmd.product_image}</td>
				<td>${pmd.current_unit_price}</td>
				<td>${pmd.payment}</td>
				<td>${pmd.quantity}</td>
				<td>${pmd.total_price}</td>
				<td>${pmd.front_create_time}</td>
				<td>${pmd.front_update_time}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>