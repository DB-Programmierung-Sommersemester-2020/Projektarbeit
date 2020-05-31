<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Büchersuche</title>
</head>
<body>
	<div id="Content">
		<h2>Danke für Ihre Bestellung</h2>

		<button type="button" class="mybutton"
			onclick="location.href='index.html'">Zurück zur Büchersuche</button>
		<br /> <br />Übersicht über alle Ihre Bestellungen.
		<hr />
		<table border="1">
			<tr>
				<th>Einkaufsdatum</th>
				<th>ISBN</th>
				<th>Titel</th>
				<th>Preis</th>
			</tr>
			<c:forEach items="${purchases}" var="purchases">
				<tr>
					<td>${purchases.getSalesTimeStamp()}</td>
					<td>${purchases.getBook().getId()}</td>
					<td>${purchases.getBook().getTitle()}</td>
					<td>${purchases.getBook().getBookPrise().getPrise()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:scriptlet>session.invalidate();</jsp:scriptlet>
</body>
</html>