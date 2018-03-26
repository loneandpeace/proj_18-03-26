<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/userpagecss.css" />
	</head>
	<body>
		<div id="topback" style="background-color: whitesmoke; border-bottom: 1px solid gray;">
			<div id="guidbar" class="divclass01" style="background-color: whitesmoke;text-align: right;">
				<span class="topspan">您好，欢迎光临 &nbsp;&nbsp;&nbsp;&nbsp;</span>
				<span class="topspan"><a href="#">登录</a></span>
				<span class="topspan">&nbsp;|&nbsp;</span>
				<span class="topspan"><a href="#">注册</a></span>
				<span class="topspan"><a href="#">&nbsp;&nbsp;&nbsp;用户中心</a></span>
				<span class="topspan"><a href="#">&nbsp;网站公告</a></span>
			</div>
		</div>

		<div id="header" class="divclass01">
			<div align="right" style="padding-right: 15px;">
				<form>
					<input class="searchbar" type="search" name="search" placeholder="本周特价" style="height:30px;border-color: gainsboro;"/>
					<input class="searchbar" type="button" name="activesearch"  value="&nbsp;&nbsp;搜索&nbsp;&nbsp;" style="font-size: 13px;height:30px;background-color: #CC3333;border: hidden;color: white;"/>
					<a href="cart.html"><input class="searchbar" type="button" name="shopcar" value="&nbsp;&nbsp;购物车&nbsp;&nbsp;"  style="font-size: 13px;height:30px;background-color: #CC3333;border: hidden;color: white;"/></a>
				</form>
			</div>
			<div id="commodityguid">
				<img id="logo" src="../../img/forpage_img/icon/logo.PNG" style="height: 60px;width: auto;padding-left: 10px;"/>
				<div id="sada" style="display: inline-block;">
				<ul>
					<li><a href="index.html">首页</a></li><span>|</span>
					<li><a href="conmodity_view_page.html">T恤</a></li><span>|</span>
					<li><a href="#">外套</a></li><span>|</span>
					<li><a href="#">衬衫</a></li><span>|</span>
					<li><a href="#">卫衣</a></li><span>|</span>
					<li><a href="#">针织衫</a></li><span>|</span>
					<li><a href="#">裤装</a></li><span>|</span>
					<li><a href="#">鞋</a></li>
				</ul>
				</div>
			</div>
		</div>
		
		<div class="divclass01">
			<p id="guid" style="color: gray;font-size: 15px;margin-top: 20px;">
				&emsp;
				<span>您的当前的位置：</span>&emsp;>&emsp;
				<span><a href="index.html">首页</a></span>&emsp;>&emsp;
				<span><a href="iframe_userpage.html" target="iframepage">我的凡客</a></span>
			</p>
		</div>
		
		
		
		<div id="cont" class="divclass01">
			<div id="leftguidbar">
				<p>订单中心</p>
				<ul>
					<li><a href="iframe_orderlist.html" target="iframepage">我的订单</a></li>
					<li>我的积分</li>
				</ul>
				<p>客户服务</p>
				<ul>
					<li>退换货办理</li>
					<li>我要评价</li>
					<li>商品提问</li>
				</ul>
				<p>账户管理</p>
				<ul>
					<li>账户余额</li>
					<li><a href="framepage/ResAllAddressServlet?pageNo=1" target="iframepage">收货地址</a></li>
					<li>账户安全</li>
					<li><a href="iframe_userpage.html" target="iframepage">账户信息</a></li>
				</ul>
			</div>
			
			
			<div id="_iframe">
				<iframe  src="iframe_userpage.html" name="iframepage">
				</iframe>
			</div>
			<div id="clear"></div>
		</div>
		
		
		
		
		<div id="helper" class="divclass01 helper">
			<ul>
				<li><a href="#"><img src="../../img/forpage_img/footer/2018-01-05_142229.png" /></a></li><div class="ahh"></div>
				<li><a href="#"><img src="../../img/forpage_img/footer/2018-01-05_142217.png" /></a></li><div class="ahh"></div>
				<li><a href="#"><img src="../../img/forpage_img/footer/2018-01-05_142205.png" /></a></li>
			</ul>
			<ul>
				<li><a href="#">${user_id}关于我们</a></li><span>|</span>
				<li><a href="#">新手指南</a></li><span>|</span>
				<li><a href="#">配送时间和范围</a></li><span>|</span>
				<li><a href="#">支付方式</a></li><span>|</span>
				<li><a href="#">售后服务</a></li><span>|</span>
				<li><a href="#">帮助中心</a></li>
			</ul>
		</div>
		<br />
		<br />
		<hr />
		<div id="footer" class="divclass01" align="center" style="background-color: white;margin-top: 15px;">
			
			<p style="font-size: 10px;">
				Copyright 2007 - 2016 vancl.com All Rights Reserved 京ICP证100557号 
				京公网安备11011502002400号 出版物经营许可证新出发京批字第直110138号
			</p>
			<p style="font-size: 10px;">凡客诚品（北京）科技有限公司</p>
		</div>
		
		

	</body>
</html>