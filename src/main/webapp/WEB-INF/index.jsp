<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	<meta charset="utf-8">
	<title>Lintubongari</title>
	<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>

	<h1>🦃 Lintubongari!</h1>

	<table>
	<tr>
		<th>Laji</th>
		<th>Paikka</th>
		<th>Pvm</th>
	</tr>
	<c:forEach items="${linnut}" var="lintu">

	<tr>
		<td>
			<c:out value="${lintu.laji }" />
		</td>
		<td>
			<c:out value="${lintu.bongattuPaikka }" />
		</td>
		<td>
			<c:out value="${lintu.bongattuPvm }" />
		</td>
		<td><a href="deleteBongattuLintu?id=${lintu.getId() }">x</a></td>
	</tr>
</c:forEach>

</table>
	<h2>Lisää bongattuja lintuja:</h2>
	<form id="" action="addBongattuLintu" method="post">
		<input name="laji" type="text" required placeholder="mikä lintu" autofocus /><br>
		<input name="paikka" type="text" required placeholder="missä nähty" autofocus /><br>
		<input name="pvm" type="text" required placeholder="koska nähty" autofocus /><br>
	
		<input type="submit" value="Lisää" />
	</form>	

</body>
</html>