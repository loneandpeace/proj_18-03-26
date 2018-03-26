<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
			*{
				padding: 0;
				margin: 0;
			}
			#img1{
				position: absolute;
				left: 20px;
				top: 10px;
			}
			h1{
				position: absolute;
				left: 75px;
				top: 32px;
			}
		/*	input{
				right: 50px;
				top: 30px;
				width: 40px;
				height: 40px;
			}*/
			#img2{
				position: absolute;
				right: 20px;
				top: 33px;
			}
			/*a:hover{
				background: url(../../../img/icon/电商.png);
			}*/
		</style>
	</head>
	<!--slateblue-->
	<body style="background-color: #336699;">
		<div>
		<img id="img1" src="img/电商.png" height="45px" style="margin-top: 20px;"/>
		<h1 style="color: white;display: inline-block;">后台系统</h1>
		</div>
		<div>
			<a href="../../BackLogoutServlet"><img id="img2" src="img/logout.png" height="40px" width="40px"></img></a>
		</div>
	</body>
</html>