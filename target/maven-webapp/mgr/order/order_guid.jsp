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
	#btn{
		padding: 2px 4px;
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
	<div>
		<p><a href="ResAllOrderServlet?pageNo=1&pageSize=10&optype=1" target="cate_frame">全部</a></p>
		<!-- <p><a href="ParentIdInfoServlet" target="cate_frame">添加</a></p> -->
	</div>
	<form action="ResAllOrderServlet" target="cate_frame">
		<input type="text" placeholder="请输入订单号" required="required" name="order_no">
		<input type="hidden" name="optype" value="5">
		<input id="btn" type="submit" value="&nbsp;提交查询&nbsp;">
	</form>

</body>
</html>