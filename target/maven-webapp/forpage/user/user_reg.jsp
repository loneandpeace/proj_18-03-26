<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="../../css/register.css" />
</head>
<body>
	<div class="divclass">
			<img id="logoimg" src="../../img/forpage_img/icon/logo.PNG" />
			<hr />
		</div>
		<div id="maincontainer" class="divclass">
				<img src="../../img/forpage_img/loginreg_img/login_logo.jpg" />
				<div class="logincontainer2">
					
					<span>注册新用户</span>
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<span id="guidtoregister">我已经注册，现在就&nbsp;<a href="login.html">登录</a></span>
					<br />
					<div id="boderline2">
						<p id="loginlable">用户注册</p>
						<table id="table">
							<form action="UserRegisterServlet" method="post">
								<tr>
									<td class="td">用户名</td>
									<td><input  type="text" name="username" placeholder="请输入用户名" required="required"/></td>
								</tr>
								<tr>
									<td class="td">密&emsp;码</td>
									<td><input  type="password" name="password1" placeholder="请设定登录密码" required="required"/></td>
								</tr>
								<tr>
									<td class="td">确认密码</td>
									<td><input  type="password" name="password2" placeholder="请再次输入密码" required="required"/></td>
								</tr>
								<tr>
									<td class="td">邮&emsp;箱</td>
									<td><input  type="text" name="email" placeholder="请输入邮箱" required="required"/></td>
								</tr>
								<tr>
									<td class="td">电&emsp;话</td>
									<td><input  type="text" name="phone" placeholder="请输入电话号码" required="required"/></td>
								</tr>
								<tr>
									<td class="td">问&emsp;题</td>
									<td><input  type="text" name="question" placeholder="请输入找回密码的问题" required="required"/></td>
								</tr>
								<tr>
									<td class="td">答&emsp;案</td>
									<td><input  type="text" name="answer" placeholder="请输入找回问题的答案" required="required"/></td>
								</tr>
								<tr>
									<td colspan="2"><input id="inputbtn" type="submit" value="提&emsp;交"></td>
								</tr>
							</form>
						</table>
					</div>
				</div>
		<div id="clear"></div>	
				<div id="clear"></div>
		<div id="foot" class="divclass">
			<div id="footer" class="divclass" align="center" style="margin-top: 15px;">
				<hr />
				<p style="font-size: 10px;">
					Copyright 2007 - 2016 vancl.com All Rights Reserved 京ICP证100557号 
					京公网安备11011502002400号 出版物经营许可证新出发京批字第直110138号
				</p>
				<p style="font-size: 10px;">凡客诚品（北京）科技有限公司</p>
			</div>
		</div>
		
		
		</div>
		
			
		<br />
</body>
</html>