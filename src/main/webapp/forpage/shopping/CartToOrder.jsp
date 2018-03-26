<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/orderlist_css.css" />
<title>Insert title here</title>
</head>
	<body onload="_onload()">
		<div class="divclass">
			<img id="logoimg" src="../../img/forpage_img/icon/logo.PNG" />
			<hr />
		</div>
		
		<div class="divclass">
			<ul>
				<li>1.我的购物车</li>
				<li id="colorchange">2.填写核对信息单</li>
				<li>3.成功提交订单</li>
			</ul>
		</div>
		
		<div id="spec" class="divclass">
			<div class="container">
				<p>收货地址：</p>
				<div class="asd">
					<div class="littlecon con11">
						<p class="linehighta">
							<p>&nbsp;&nbsp;张三</p>
							<p>&nbsp;&nbsp;186*****123</p>
							<p>&nbsp;&nbsp;天津市 天津市 XX区</p>
							<p>&nbsp;&nbsp;XX路 XX号</p>
						</p>
					</div>
					<div class="littlecon con12">
						<p class="linehighta"><font color="red" style="font-weight: 900;">+</font><a href="userpage.html">&nbsp;添加新地址</a></p>
					</div>
				</div>
			</div>
			<hr />
			<div class="container">
				<p>配送方式：</p>
				<div class="asd">
					<div class="littlecon con21">
						<p class="linehighta">周一至周五、工作日送货</p>
					</div>
					<div class="littlecon con22">
						<p class="linehighta">周六、周日、假日送货</p>
					</div>
					<div class="littlecon con23">
						<p class="linehighta">周一至周日均可送货</p>
					</div>
				</div>
			</div>	
			<hr />
			<div class="container">
				<p>支付方式：</p>
				<div class="asd">
					<div class="littlecon con31">
						<p class="linehighta">在线支付</p>
					</div>
					<div class="littlecon con32">
						<p class="linehighta">货到付款</p>
					</div>
					<div class="littlecon con33">
						<p class="linehighta">货到付款（pos机)</p>
					</div>
				</div>
			</div>
		</div>
		
		<div id="posi" class="divclass">
			<br />
			<p align="right"><a href="cart.html">返回购物车，修改商品 >></a></p>
			<div id="info_continer">
			<table>
				<tr>
					<td>商品名称</td>
					<td>尺码</td>
					<td>单价</td>
					<td>数量</td>
					<td>优惠</td>
					<td>小计</td>
				</tr>
				<tr>
					<td>T恤 巴普洛夫的狗 白色</td>
					<td>S</td>
					<td>￥98.00</td>
					<td>1</td>
					<td>-</td>
					<td>￥98.00</td>
				</tr>
			</table>
			</div>
			<p class="pad" align="right">商品金额小计:￥98.00   +  运费:￥10.00   =  应付:￥108.00</p>
			<p class="pad" align="right" style="font-size: 30px;color: #CC3333;font-family: '微软雅黑';font-weight: 600;">金额：￥108.00元</p>
			<br />
			<form>
				<a id="btn" href="pay.html">去付款</a>
				<!--<input  type="button" value="去付款"/>-->
			</form>
		</div>
		
		
		<br />
		<br />
		<br />
		<br />
		
		
	</body>
</html>