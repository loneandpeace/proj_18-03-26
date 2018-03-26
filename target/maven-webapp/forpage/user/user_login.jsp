<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/login_register.css" />
<title>凡客 Vancl 登录</title>
<style type="text/css">
	#checkbox{
		height: 15px;
		width: 15px;
	}
	#checkboxspan{
		font-size: 13px;
	}
</style>
<script type="text/javascript">
	function _onsubmit(form){
		
		var url=form.action;
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		var fullurl=url+"?username="+username+"&password="+password;
		doLogin(fullurl);
		return false;
	}
	function doLogin(fullurl){
		var parent=document.getElementsByTagName("body")[0];
		var script=document.createElement("script");
		script.src=fullurl;
		script.type="text/javascript";
		parent.appendChild(script);
		
	}
	
	function loginResult(vo){
		if(vo.errorno==1){
			window.location.href="http://localhost:8080/homework_sp/forpage/shopping/cart_backup.jsp";
		}else {
			document.getElementById("username").value=vo.message;
		}
	}
	
</script>
</head>
<div class="divclass">
			<img id="logoimg" src="../../img/forpage_img/icon/logo.PNG" />
			<hr />
		</div>
		<div id="maincontainer" class="divclass">
				<img src="../../img/forpage_img/loginreg_img/login_logo.jpg" />
				<div class="logincontainer">
					
					<span>凡客 Vancl 登录</span>
					&emsp;&emsp;&emsp;&emsp;
					<span id="guidtoregister">没有账户免费&nbsp;<a href="register.html">注册</a></span>
					<br />
					<div id="boderline">
						<p id="loginlable">用户登录</p>
						<form action="http://localhost:8080/homework_sp/forpage/user/UserLoginServlet" method="post" onsubmit="return _onsubmit(this)">
							<input id="username" type="text" name="username" placeholder="请输入用户名" required="required"/>
							<br />
							<input id="password" type="password" name="password" placeholder="请输入密码" required="required"/>
							<br />
							<input id="checkbox" type="checkbox" name="autologin" value="true"/><span id="checkboxspan">&emsp;自 动 登 录</span>
							<p id="findback"><a href="#">忘记密码</a></p>
							<input type="submit" value="登录"/>
						</form>
					</div>
				</div>
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
		<div id="clear"></div>
	
		<br />
		
	</body>
</html>