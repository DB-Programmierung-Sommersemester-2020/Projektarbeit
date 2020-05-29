<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<script type="application/javascript" src="js/emailValidator.js"></script>
<script type="application/javascript" src="js/passwordValidator.js"></script>
<script type="application/javascript" src="js/autocompletion.js"></script>
<script type="application/javascript" src="js/initScriptOnRegistration.js"></script>
<title>Büchersuche</title>
</head>
<body>
<div id="Content">
<h2>Wir begrüßen Sie als Neukunden</h2>

<form action="register" method="GET">
 <table>
  <tr>
    <td>Nachname:</td> <td><input type="text" name="nachname" size="30"/></td> 
  </tr>
  <tr>
    <td>Vorname:</td> <td><input type="text" name="vorname" size="30"/></td> 
  </tr>
   <tr>
    <td>PLZ:</td> <td><input id="plz" type="text" name="plz" size="30" autocomplete="off"/></td> 
  </tr>
   <tr>
    <td>Wohnort:</td> <td><input id="ort" type="text" name="ort" size="30"/></td> 
  </tr>
   <tr>
    <td>Strasse:</td> <td><input type="text" name="street" size="30"/></td> 
  </tr>
  <tr>
    <td>Email:</td> <td><input id="email" type="text" name="email" size="30"/></td> 
  </tr>
  <tr>
    <td>Passwort:</td> <td><input id="passwd" type="password" name="passwd" size="30"/></td> 
  </tr>
  <tr>
    <td><input type="radio" name="kind" checked="checked" value="Privatkunde">Privatkunde</td> 
    <td><input type="radio" name="kind" value="Geschaeftskunde">Geschaeftskunde</td> 
  </tr>
  <tr>
    <td> &nbsp; </td> <td><input type="submit" class="mybutton" Registrieren"/></td> 
  </tr>
 
  </table>
</form>
</div>
</body>
</html>