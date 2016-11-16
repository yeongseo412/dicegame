<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Result</title>
</head>
<body>
	${playerName}
	${message}
	
	<form action="${pageContext.request.contextPath}/score" method="get">
		<input type="submit" value="Score" />
		<input type="button" onclick="window.close();" value="Exit"/>
	</form>
</body>
</html>