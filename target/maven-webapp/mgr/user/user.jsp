<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<frameset rows="40px,*" frameborder="1" border="2px sloid gray;">
<frame src="user_guid.jsp" scrolling="no">
<frame src="ResAllUserServlet?pageNo=1&pageSize=10&opType=1" scrolling="yes" name="cate_frame">
</frameset>
<!-- <body>cate_list.jsp</body> -->

</html>