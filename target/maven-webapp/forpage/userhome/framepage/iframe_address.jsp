<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
			*{
				padding: 0;
				margin: 0;
				font-family: "微软雅黑";
				font-size: 15px;
			}
			table{
				border-spacing: 0;
			}
			.bottomline{
				border-bottom: 1px solid gray;
			}
			.topline{
				border-top: 1px solid gray;
			}
			.innertable{
				width: 940px;
				background-color: whitesmoke;
			}
			.innertable td{
				padding: 5px 20px;
				text-align: left;
				font-size: 13px;
			}
			div>p{
				font-size: 15px;
			}
			.title{
				background-color: gainsboro;
				padding: 5px;
				padding-left: 25px;
				font-weight: 600;
			}
			
			#lable{
				font-size: 18px;
				font-weight: bold;
				background-color: white;
				border-bottom: 2px solid #CC3333;
				padding: 5px 10px;
				padding-top: 10px;
			}
			form{
				padding-left: 70px;
				background-color: whitesmoke;
			}

			#btnn{
				width: 200px;
				margin-left: 5px;
				margin-left: 30px;
				border-radius: 3px;
			}
			#div02{
				margin-top: 0px;
			}
			#div02 table *{
				padding: 1px 0;
				font-size: 13px;
			}
			a{
				text-decoration: none;
			}
			.p{
				display: inline-block;
				padding: 0 5px;
			}
			
			#pageguid{
				text-align: center;
			}
			.bottomline a:link,
			.bottomline a:visited,
			.bottomline a:active {
				color: black;
			}
			.bottomline a:hover{
				color: red;
			}
		</style>
	</head>
	<body>
		<p id="lable">收货地址</p>
		<div id="div01">
			<p class="title">已有地址：</p>
				<table class="innertable">
					<!-- <tr>
						<td>收货人：</td>
						<td>详细地址</td>
						<td>电话/手机</td>
						<td>操作</td>
					</tr>
				 	-->
					<c:forEach items="${pageModel.data}" var="pmd">
					<tr>
						<td style="width: 130px;">收货人：${pmd.receiver_name}</td>
						<td>电话 / 手机：${pmd.receiver_phone} / ${pmd.receiver_mobile}</td>
						<td>邮编：${pmd.receiver_zip}</td>
						<td rowspan="2" class="bottomline"><a href="deleteAddressServlet?id=${pmd.id}">删除</a>&nbsp;/&nbsp;<a href="FindOneAddressServlet?id=${pmd.id}">编辑</a></td>
					</tr>
					<tr>
						<td colspan="2" class="bottomline" style="width: 350px;">收货地址： ${pmd.receiver_province} , ${pmd.receiver_city} , ${pmd.receiver_district} , ${pmd.receiver_address}</td>
						<td class="bottomline">${pmd.front_create_time} / ${pmd.front_update_time}</td>
					</tr>
					</c:forEach>
					
				</table>
				<table style="width: 940px;">
					<tr>
						<td id="pageguid">
							<c:forEach var="pageNo" begin="1" end="${pageModel.totalCount}" step="1">
								<p class="p"><a href="ResAllAddressServlet?pageNo=${pageNo}">${pageNo}</a></p>
							</c:forEach>
						</td>
					</tr>
				</table>
		</div>
		<div id="div02">
		<hr>
			<p class="title">新增地址：</p>
			<form action="AddAddressServlet" method="post">
				<table>
					<tr>
						<td><span>* 收 货 人：</span></td>
						<td><input type="text" name="receiver_name" required="required"/></td>
					</tr>
					<tr>
						<td><span>* 固定电话：</span></td>
						<td><input type="text" name="receiver_phone" required="required"/></td>
					</tr>
					<tr>
						<td><span>* 手 机：</span></td>
						<td><input type="text" name="receiver_mobile" required="required"/></td>
					</tr>
					<tr>
						<td>
							<span>* 地 区：</span>
						</td>
						<td>
							<select  name="receiver_province" required="required">
								<option>省份1</option>
								<option>省份2</option>
								<option>省份3</option>
								<option>省份4</option>
							</select>
							<select name="receiver_city" required="required">
								<option>城市1</option>
								<option>城市2</option>
								<option>城市3</option>
								<option>城市4</option>
							</select>
							<select name="receiver_district" required="required">
								<option>A</option>
								<option>B</option>
								<option>C</option>
								<option>D</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><span>* 详细地址：</span></td>
						<td><input type="text" name="receiver_address" required="required"/></td>
					</tr>
					
					<tr>
						<td><span>* 邮政编码：</span></td>
						<td><input type="text" name="receiver_zip" required="required"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input id="btnn" type="submit" value="提交"/>
						</td>
					</tr>
					
				</table>
			</form>
		</div>
	</body>
</html>