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
		padding: 2px 10px;
		text-align: center;
	}
	th{
		border: none;
		padding: 2px 13px;
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
			<th>种类名</th>
			<th>名称</th>
			<th>副标题</th>
			<th>主图片</th>
			<th>副图片</th>
			<th>描述</th>
			<th>价格</th>
			<th>库存</th>
			<th>状态</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${pageModel.data}" var="pmd">
			
			<tr>
				<td>${pmd.id}</td>
				<td>${pmd.cate_name}</td>
				<td>${pmd.name}</td>
				<td>${pmd.subtitle}</td>
				<td>${pmd.main_image}</td>
				<td>${pmd.sub_images}</td>
				<td>${pmd.detail}</td>
				<td>${pmd.price}</td>
				<td>${pmd.stock}</td>
				<td>${pmd.status}</td>
				<td>${pmd.front_create_time}</td>
				<td>${pmd.front_update_time}</td>
				<td> <a href="DeleteProductServlet?productid=${pmd.id}&pageNo=1">删除</a> <a href="UpdateProductInfoServlet?productid=${pmd.id}">修改</a> </td>
			</tr>
			
		</c:forEach>
		
		<tr>
			<td colspan="13">
				<c:forEach var="pageNo" begin="1" end="${pageModel.totalCount}" step="1">
					<p><a href="ResAllProductServlet?pageNo=${pageNo}">${pageNo}</a></p>
				</c:forEach>
			</td>
		</tr>
	</table>
	
	
	
</body>
</html>