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
	<table>
	
		<tr>
			<th>id</th>
			<th>用户名</th>
			<th>收货人</th>
			<th>电话/固定电话</th>
			<th>详细地址</th>
			<th>邮编</th>
			<th>创建时间</th>
			<th>更新时间</th>
		</tr>

		<c:forEach items="${pageModel.data}" var="pmd">
			
			<tr>
				<td>${pmd.id}</td>
				<td>${pmd.user.username}</td>
				<td>${pmd.receiver_name}</td>
				<td>${pmd.receiver_phone}/${pmd.receiver_mobile}</td>
				<td>${pmd.receiver_province}-${pmd.receiver_city}-${pmd.receiver_district}-${pmd.receiver_address}</td>
				<td>${pmd.receiver_zip}</td>
				<td>${pmd.front_create_time}</td>
				<td>${pmd.front_update_time}</td>
				<!-- <td> <a href="ResAllUserServlet?user_id=${pmd.id}&opType=3">删除</a> 
				<a href="ResAllUserServlet?user_id=${pmd.id}&opType=2">查看</a> </td> -->
			</tr>
			
		</c:forEach>
		<tr>
			<td colspan="8">
				<c:forEach var="pageNo" begin="1" end="${pageModel.totalCount}" step="1">
					<p><a href="ResAllAddressServlet?pageNo=${pageNo}&opType=1&pageSize=10">${pageNo}</a></p>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>