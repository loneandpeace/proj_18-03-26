<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/cart.css" />
<script src="../../js/cart.js"></script>

<title>Insert title here</title>
</head>
<body>
		<div class="divclass">
			<img id="logoimg" src="../../img/forpage_img/icon/logo.PNG" />
			<hr />
		</div>
		
		<div class="divclass">
			<ul>
				<li>1.我的购物车</li>
				<li>2.填写核对信息单</li>
				<li>3.成功提交订单</li>
			</ul>
		</div>
		<div class="divclass">
			<img src="../../img/forpage_img/icon/购物车满.png" height="27px" style="margin-left: 15px;"/>
			<p>我的购物车</p>
			<br />
			<p style="font-size: 12px;padding-left: 15px;"><font color="#CC3333">温馨提示：</font>1.选购清单中的商品无法保留库存，请您及时结算。2.商品的价格和库存将以订单提交时为准。3.促销活动满减优惠将均摊至商品小计中。</p>
		</div>
		
		
		<div id="divgoodslist" class="divclass">
			
			<!-- <table>
				
				<form>
					<tr id="infobar" style="background-color: gainsboro;">
						<td><input type="checkbox" name="selectall" /><span>&nbsp;全选</span></td>
						<td colspan="2"><span>商品名称</span></td>
						<td><span>数量</span></td>
						<td><span>状态</span></td>
						<td><span>创建日期</span></td>
						<td><span>更新日期</span></td>
						<td><span>小计</span></td>
						<td><span>操作</span></td>
					</tr>
				</form>
			</table> -->
			<table>
				<form>
				<div id="print">
					
				</div>
				</form>
			</table>
			
		</div>
		
		
		
		
		
		<div id="gosecond" class="divclass">
			<div id="goforordercheck">
				<form>
					<!-- <input type="checkbox" name="chooseall"/> -->
					<span><a onclick="selectAll()">&nbsp;全选<a/></span>&emsp;<a onclick="unselectAll()">全不选</a>&emsp;&emsp;&emsp;<span id="count">&nbsp;数量共计：  1  件</span>
					<br />
					<p>产品金额总计(不含运费)：<font style="color: #CC3333;font-size: 35px;">￥00.00</font></p>
				</form>
					<div id="buttongroup">
					<a href="index.html">&lt;&lt; 继续购物</a>&emsp;
					<a href="orderlist.html">￥ 去结算 &gt;</a>
					</div>
					
				
				
			</div>
		</div>
		
		
			<div id="footer" class="divclass" align="center" style="margin-top: 15px;">
				<hr />
				<p style="font-size: 10px;">
					Copyright 2007 - 2016 vancl.com All Rights Reserved 京ICP证100557号 
					京公网安备11011502002400号 出版物经营许可证新出发京批字第直110138号
				</p>
				<br />
				<p style="font-size: 10px;">凡客诚品（北京）科技有限公司</p>
			</div>
			
	</body>
</html>