<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台系统</title>
<style type="text/css">
	
</style>
</head>
	<frameset rows="100px,*,40px;" frameborder="1" border="2px sloid gray;">
		<frame src="back_topbar.jsp" scrolling="no"/>
		<frameset cols="150px,*">
			<frame src="back_guidlist.jsp"/>
			<frame src="back_end_welcome.jsp" name="linktarget"/>
		</frameset>
		<frame src="frame_footer.jsp" />
	</frameset>
</html>