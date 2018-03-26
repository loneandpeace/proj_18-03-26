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
			<th>parent_id</th>
			<th>name</th>
			<th>status</th>
			<th>sort_order</th>
			<th>create_time</th>
			<th>update_time</th>
			<th>operation</th>
		</tr>

		<c:forEach items="${pageModel.data}" var="pmd">
			
			<tr>
				<td>${pmd.id}</td>
				<td>${pmd.parent_id}</td>
				<td>${pmd.name}</td>
				<td>${pmd.status}</td>
				<td>${pmd.sort_order}</td>
				<td>${pmd.front_create_time}</td>
				<td>${pmd.front_update_time}</td>
				<td> <a href="DeleteCateServlet?cateid=${pmd.id}">删除</a> <a href="UpdateCateInfoServlet?cateid=${pmd.id}">修改</a> </td>
			</tr>
			
		</c:forEach>
		<tr>
			<td  colspan="8">
				<c:forEach var="pageNo" begin="1" end="${pageModel.totalCount}" step="1">
					<a href="SearchCateServlet?pageNo=${pageNo}&info=${info}">${pageNo}</a>
				</c:forEach>
			</td>
		</tr>
	</table>
	
	
</body>
</html>