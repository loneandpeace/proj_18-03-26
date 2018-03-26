<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	form{
		display: inline-block;
		position: absolute;
		right: 30px;
		top: 7px;
	}
	p{
		display: inline-block;
		margin-top: 9px;
		margin-left: 5px;
	}
	input{
		border-radius: 3px;
	}
	input:last-child{
		height: 27px;
		padding-left: 5px;
		padding-right: 5px;
	}
	input:first-child{
		height: 22px;
	}
	a{
		text-decoration: none;
		font-size: 13px;
		padding: 2px 15px; 
	}
	a:link{
		background-color: gainsboro;
		color: black;
		border: 1px solid black;
		border-radius: 3px;
	}
	a:visited,
	a:active{
		text-decoration: none;
		color: black;
	}
	a:hover{
		background-color: whitesmoke;
		color: black;
	}
</style>
</head>
<body>
<p><a href="ResAllProductServlet?pageNo=1" target="product_frame">全部</a></p>
<p><a href="CateIdInfoServlet" target="product_frame">添加</a></p>
<form action="SearchProductServlet" target="product_frame">
	<input type="text" placeholder="请输入商品名" required="required" name="info">
	<input type="hidden" value="1" name="pageNo">
	<input type="submit" value="&nbsp;提交查询&nbsp;">
</form>
</html>