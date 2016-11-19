<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>DICE GAME</h1>
	
	<form action="${pageContext.request.contextPath}/dicegame" method="get">
		<input type="text" name="name"/>
		<input type="submit" value="PLAY"/>
	</form>
	
	<form action="${pageContext.request.contextPath}/configure" method="post">
		<input type="submit" value="Configure" />
	</form>
	
	<input type="button" onclick="window.close();" value="Exit" />
</body>
</html>
