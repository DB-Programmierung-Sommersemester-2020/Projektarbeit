<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<title>Büchersuche</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
  <div id="Content">
    <h2>Ihr Buch im Detail</h2>

    <form action="warenkorb">
      <table border="1">
        <tr>
          <td>Autorenname:</td>
          <td>${buch.autorenAsString}</td>
        </tr>
        <tr>
          <td>Titel:</td>
          <td>${buch.titel}</td>
        </tr>
        <tr>
          <td>Verlag</td>
          <td>${buch.verlag}</td>
        </tr>
        <tr>
          <td>Preis</td>
          <td>${buch.preis} &euro;</td>
        </tr>
      </table>
      <input type="hidden" name="buchid" value="${buch.id}">
      <p />
      <button type="button" class="mybutton" onclick="location.href='index.html'">Neue Suche</button>
      <input type="submit" class="mybutton" value="In den Warenkorb" />
    </form>
  </div>
</body>
</html>