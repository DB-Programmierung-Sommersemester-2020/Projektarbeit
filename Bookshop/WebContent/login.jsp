<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<title>Büchersuche</title>
</head>
<body>
  <div id="Content">
    <h2>Login</h2>
    <form action="kaufinfo">
      <fieldset>
        <legend>Logindaten</legend>
        <div>
          <label for="user">Email: </label> <input type="email"
            name="user" />
        </div>
        <div>
          <label for="passwd">Password: </label> <input type="password"
            name="passwd">
        </div>
        <p/>
      <input class="mybutton" type="submit" value="Daten senden" />
      </fieldset>

      

    </form>

    <h2>Neuer Kunde</h2>
    <fieldset>
        <legend>Kundenregistrierung</legend>
    <button type="button" class="mybutton" onclick="location.href='registrierung.jsp'">Registrierung</button>
    </fieldset>
  </div>
</body>
</html>