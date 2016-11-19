<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Configure</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/configure">
		<input type="text" size="3" name="cell"/>th cell ->
		<input type="text" size="3" name="newCell"/>th cell 
		
		<input type="submit" value="Apply"/>
	</form>

	<c:forEach var="cell" items="${map}" varStatus="status">
		<p>
			${status.index}cell goes to <c:out value="${cell}" />cell
			<br/>
		</p>
	</c:forEach>

	<form action="${pageContext.request.contextPath}/">
		<input type="submit" value="finish"/>
	</form>
	
</body>
</html>