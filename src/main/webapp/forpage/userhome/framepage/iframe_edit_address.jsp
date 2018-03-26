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
				text-align: center;
				font-size: 13px;
			}
			div>p{
				font-size: 15px;
			}
			p:first-child{
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
			#div02 table *{
				padding: 1px 0;
				font-size: 13px;
			}
			a{
				text-decoration: none;
			}
</style>
</head>
<body>
<div id="div02">
			<p>修改地址：</p>
			<form action="UpdateAddressServlet" method="post">
			<input type="hidden" name="id" value="${editAddress.id}">
			<input type="hidden" name="pageNo" value="1">
				<table>
					<tr>
						<td><span>* 收 货 人：</span></td>
						<td><input type="text" name="receiver_name" value="${editAddress.receiver_name}" required="required"/></td>
					</tr>
					<tr>
						<td><span>* 固定电话：</span></td>
						<td><input type="text" name="receiver_phone" value="${editAddress.receiver_phone}" required="required"/></td>
					</tr>
					<tr>
						<td><span>* 手 机：</span></td>
						<td><input type="text" name="receiver_mobile" value="${editAddress.receiver_mobile}" required="required"/></td>
					</tr>
					<tr>
						<td>
							<span>* 地 区：</span>
						</td>
						<td>
							<select  name="receiver_province" required="required">
								<option>${editAddress.receiver_province}</option>
								<option>省份1</option>
								<option>省份2</option>
								<option>省份3</option>
								<option>省份4</option>
							</select>
							<select name="receiver_city" required="required">
								<option>${editAddress.receiver_city}</option>
								<option>城市1</option>
								<option>城市2</option>
								<option>城市3</option>
								<option>城市4</option>
							</select>
							<select name="receiver_district" required="required">
								<option>${editAddress.receiver_district}</option>
								<option>A</option>
								<option>B</option>
								<option>C</option>
								<option>D</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><span>* 详细地址：</span></td>
						<td><input type="text" name="receiver_address" value="${editAddress.receiver_address}" required="required"/></td>
					</tr>
					
					<tr>
						<td><span>* 邮政编码：</span></td>
						<td><input type="text" name="receiver_zip" value="${editAddress.receiver_zip}" required="required"/></td>
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