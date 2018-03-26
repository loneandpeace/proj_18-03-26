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


<table>
		<tr>
			<td>订单号</td>
			<td>用户id</td>
			<td>地址id</td>
			<td>总价</td>
			<td>付款方式</td>
			<td>邮费</td>
			<td>订单状态</td>
			<!-- <td>支付/配送时间</td>
			<td>结束/关闭时间</td> -->
			<!-- <td>创建时间</td>
			<td>更新时间</td> -->
			<!-- <td>操作</td> -->
		</tr>
		
		<tr>
			<td>${orderVo.order_no}</td>
			<td>${username}</td>
			<td>${orderVo.address.receiver_name}-${orderVo.address.receiver_phone}-${orderVo.address.receiver_province}-${orderVo.address.receiver_city}-${orderVo.address.receiver_district}-${orderVo.address.receiver_address}</td>
			<td>${orderVo.payment}</td>
			<td>${orderVo.payment_type}</td>
			<td>${orderVo.postage}</td>
			<td>${orderVo.status}</td>
			<!-- <td>${orderVo.payment_time}/${pmd.send_time}</td>
			<td>${orderVo.end_time}/${pmd.close_time}</td> -->
			<!-- <td>${orderVo.create_time}</td>
			<td>${orderVo.update_time}</td> -->
		</tr>
	
	</table>


<hr>
<table>
		<!-- <tr>
			<td>订单号:${orderVo.order_no}</td>
		</tr> -->
		<tr>
			<!-- <td>用户</td> -->
			<td>商品名</td>
			<td>商品图片</td>
			<td>单价</td>
			<td>应付</td>
			<td>数量</td>
			<td>总价</td>
			<td>创建时间</td>
			<td>更新时间</td>
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