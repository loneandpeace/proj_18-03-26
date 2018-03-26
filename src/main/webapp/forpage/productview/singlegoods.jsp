<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/singlegoodscss.css" />
	</head>
	<body>
		
		
		<div id="topback" style="background-color: whitesmoke; border-bottom: 1px solid gray;">
			<div id="guidbar" class="divclass01" style="background-color: whitesmoke;text-align: right;">
				<span class="topspan">您好，欢迎光临 &nbsp;&nbsp;&nbsp;&nbsp;</span>
				<span class="topspan"><a href="login.html">登录</a></span>
				<span class="topspan">&nbsp;|&nbsp;</span>
				<span class="topspan"><a href="register.html">注册</a></span>
				<span class="topspan"><a href="userpage.html">&nbsp;&nbsp;&nbsp;用户中心</a></span>
				<span class="topspan"><a href="#">&nbsp;网站公告</a></span>
			</div>
		</div>
		

		<div id="header" class="divclass01">
			<div align="right" style="padding-right: 15px;">
				<form action="#" method="get">
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
			<p id="guid" style="color: gray;font-size: 15px;">
				&emsp;
				<span><a href="index.html">首页</a></span>&emsp;>&emsp;
				<span><a href="#">男装</a></span>&emsp;>&emsp;
				<span><a href="conmodity_view_page.html">T恤</a></span>
			</p>
		</div>
		
		
		<div  class="divclass01" style="margin: 10px auto;">
			<span style="font-size: 20px;"><b>
				<span style="color: #CC3333;">【预售】</span>T恤 学霸 巴普洛夫的狗 白色 
			</b><span style="color: #CC3333;font-size: 13px;">&emsp;预计下单之日起15个工作日发货</span></span>
			<div id="linkbar">
				<span><a href="#link1">图案展示</a></span><span>&nbsp;|&nbsp;</span>
				<span><a href="#link2">作者简介</a></span><span>&nbsp;|&nbsp;</span>
				<span><a href="#link3">产品尺码</a></span><span>&nbsp;|&nbsp;</span>
				<span><a href="#link4">洗涤保养</a></span>&nbsp;
			</div>
			
		</div>
		
		
		<div id="conmodity" class="divclass01">
			<hr size="1px" style="margin:0 0 10px 0;" />
			
			<div id="conmoditydiv1">
				<div style="float: left; margin: 10px 10px;">
					<a href="../../img/forpage_img/product/singlegoodsbig.png" target="asd"><img src="../../img/forpage_img/product/singlegoodsbig.png" height="50px" width="50px"/></a>
				</div>
				<div id="conmoditydiv101">
				<iframe src="../../img/forpage_img/product/singlegoodsbig.png" name="asd" scrolling="no" height="380px" width="410px" style="border: 1px solid gainsboro;"></iframe>
				</div>
			</div>
			
			<div id="conmoditydiv2">
				<div id="conmoditydiv201">
					<p style="font-size: 13px;">原价：<s>￥199.00</s> <span style="font-size: 25px;color: #CC3333;">&nbsp;&nbsp;<b>现价：￥98.00</b></span> </p>
					<form action="addProductToCartServlet" method="post">
					
						<input type="hidden" name="product_id" value="4" />
						
						<p class="detials">
							<span>颜色：</span><!--<input type="radio" value="颜色" name="_color"/><span>白</span>-->
							&emsp;<div class="choose">白色</div>
						</p>
							
						<p class="detials">
							<span>尺码：</span>
							<!--<input type="radio" value="S" name="_size" /><span>S&nbsp;&nbsp;&nbsp;</span>
							<input type="radio" value="M" name="_size" /><span>M&nbsp;&nbsp;&nbsp;</span>
							<input type="radio" value="L" name="_size" /><span>L&nbsp;&nbsp;&nbsp;</span>-->
							<div class="choose">S</div>
							<div class="choose">M</div>
							<div class="choose">L</div>
						</p>
						<p class="detials">
						<span>数量：</span>
						<select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
						</p>
						<input id="specc" class="buttons" type="submit" value="加入购物车" />
						<input id="specc" class="buttons" type="button" value="立即购买" />
					</form>
				</div>
			</div>
			<hr />
		</div>
		
		<div class="divclass01">
			<img src="../../img/forpage_img/product/11.jpg" />
			<a name="link1"/>
			<img src="../../img/forpage_img/product/dog_03.jpg" />
			<img src="../../img/forpage_img/product/dog_04.jpg" />
			<a name="link2"/>
			<img src="../../img/forpage_img/product/dog_06.jpg" />
			<a name="link3"/>
			<img src="../../img/forpage_img/product/pc-1111.jpg" />
			<a name="link4"/>
			<img src="../../img/forpage_img/product/dog_10.jpg" />
		</div>
		
		<div id="comment" class="divclass01">
			<div id="commentleft">
				<table>
					<tr>
						<td style="border-bottom: hidden;">商品推荐</td>
					</tr>
					<tr>
						<td><a href="">&nbsp;<img src="../../img/forpage_img/goods/1.jpg" height="50px"/><p>兄弟T恤</p></a></td>
					</tr>
				</table>
			</div>
			<div id="commentright">
				<table>
					<tr>
						<td id="topline" colspan="3">最新评论(1)</td>
					</tr>
					<tr>
						<td>价格实惠，买了好多件！</td>
						<td>颜色：白色</td>
						<td rowspan="2">ycf****dfh</td>
					</tr>
					<tr>
						<td>2018/01/03</td>
						<td>尺码：s</td>
					</tr>
					<tr>
						<td id="bottomline" colspan="3"align="right"><a href="">下一页</a></td>
					</tr>
				</table>
			</div>
			<div id="clear"></div>
		</div>
		
		
		
		
		
		
		
		<br />
		<br />
		
		<div id="helper" class="divclass01 helper">
			<ul id="_ul">
				<li class="add"><a href="#"><img src="../../img/forpage_img/footer/2018-01-05_142229.png" /></a></li><div class="ahh"></div>
				<li class="add"><a href="#"><img src="../../img/forpage_img/footer/2018-01-05_142217.png" /></a></li><div class="ahh"></div>
				<li class="add"><a href="#"><img src="../../img/forpage_img/footer/2018-01-05_142205.png" /></a></li>
			</ul>
			<ul>
				<li><a href="#">关于我们</a></li><span>|</span>
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
			
			
		<br />
		
	</body>
</html>