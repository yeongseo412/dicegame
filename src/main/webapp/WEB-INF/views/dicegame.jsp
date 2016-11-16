<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Dice game</title>
</head>
<body>
	<h2>PLAY THE GAME</h2>

	<table>
		<tr>
			<th width="120">Name</th>
			<th width="200">Face value</th>
			<th width="200">Current cell</th>
		</tr>
		<tr>
			<td>${playerName}</td>
			<td>${faceValue1}</td>
			<td>${currentCell1}</td>
		</tr>
		<tr>
			<td>Alpha Dice</td>
			<td>${faceValue2}</td>
			<td>${currentCell2}</td>
		</tr>
	</table>

	<form action="${pageContext.request.contextPath}/roll" method="get">
		<input type="submit" value="roll" />
	</form>

</body>
</html>