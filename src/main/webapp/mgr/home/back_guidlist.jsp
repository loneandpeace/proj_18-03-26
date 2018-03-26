<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	*{
		padding: 0;
		margin: 0 0;
	}
	ul{
		list-style: none;
		margin-top: 15px;
	}
	a{
		text-decoration: none;
	}
	li{
		/*padding: 6px 0;
		transition: background-color 0.18s,font-size 0.18s;*/
		line-height: 30px;
		padding: 3px 0;
		transition: background-color 0.18s,font-size 0.18s;
	}
	a:link,
	a:visited,
	a:active{
		color: white;
	}

	a:hover li{
		background-color: whitesmoke;
		color: black;
		font-size: 20px;
	}
	div{
		height: 40px;
		background-color: gainsboro;
		padding-top: 20px;
	}
</style>
</head>
<body style="text-align: center;background-color: steelblue;">
	<div align="center">
		<p style="font-weight: bold;color: black;">欢迎,${user.username}</p>
	</div>
	<b>
	<ul>
		<a href="lp.jsp" target="linktarget"><li>基本设置</li></a><!-- <ul><li>aaa</li><li>bbb</li></ul> -->
		<a href="../order/order.jsp" target="linktarget"><li>订单管理</li></a>
		<a href="../product/product.jsp" target="linktarget"><li>产品管理</li></a>
		<a href="../address/address.jsp" target="linktarget"><li>地址管理</li></a>
		<a href="../cate/cate.jsp" target="linktarget"><li>分类管理</li></a>
		<a href="../user/user.jsp" target="linktarget"><li>会员管理</li></a>
	</ul>
	</b>
</body>
</html>