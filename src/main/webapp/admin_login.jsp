<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	div{
		width: 300px;
		hight: 500px;
		margin: 100px auto;
	}
	#btn{
		width: 200px;
		height: 27px;
	}
	.input{
		width: 138px;
	}
	table{
		border: solid black 1px;
		border-spacing: 0;
	}
	tr{
		background-color: whitesmoke;
	}
	td:nth-child(2) input{
		width: 110px;
	}
	body{
		background-color: steelblue;
	}
	td:first-child{
		padding: 12px 0px;
		padding-left: 25px;
	}
	td:last-child{
		padding: 12px 0px;
	}
	td:only-child{
		padding: 8px 15px;
	}
	tr:first-child td{
		padding-top: 23px;
		text-align: center;
		font-size: 18px;
		font-weight: bold;
	}
	#autologin{
		position: relative;
		bottom: 2px;
		display: inline-block;
		font-size: 11px;
	}
</style>
<script src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	window.onload=function(){
		var token=getCookie('token');
		//alert(token);
		var parent=document.getElementsByTagName("body")[0];
		var script=document.createElement("script");
		script.src="http://localhost:8080/homework_sp/loginactive?shortcut=1";
		//window.location.href="http://localhost:8080/homework_sp/mgr/home/back_end.jsp";
		script.type="text/javascript";
		parent.appendChild(script);
	}
	function getCookie(c_name)
	{
		if (document.cookie.length>0)
		  {
		  c_start=document.cookie.indexOf(c_name + "=");
		  if (c_start!=-1)
		    { 
		    c_start=c_start + c_name.length+1 ;
		    c_end=document.cookie.indexOf(";",c_start);
		    if (c_end==-1) c_end=document.cookie.length;
		    return unescape(document.cookie.substring(c_start,c_end));
		    } 
		  }
		return "";
	}
</script>
</head>
<body>
	<div id="container">
		<table>
			<form action="loginactive" method="get">
				<tr>
					<td colspan="2">后台登录</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input class="input" type="text" name="username" required="required"></td>
				</tr>
				<tr>
					<td>密&emsp;码:</td>
					<td><input class="input" type="password" name="password" required="required"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input class="asd" type="checkbox" name="autologin" value="true"><p id="autologin">&emsp;自动登录</p></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input class="asd" id="btn" type="submit" value="登录"></td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>