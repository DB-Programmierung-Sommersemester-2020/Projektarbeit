// Fügt der Registrationsseite JavaScript-Funktionalität hinzu
window.onload = function()
{
  // Email-Validierung
  document.getElementById("email").onblur = validateEmail;
  document.getElementById("email").onkeyup = clearEmailErrorMsg;
  document.getElementById("email").onfocus = clearEmailErrorMsg;
  configEmailErrorContainer();

  // Password-Validierung
  document.getElementById("passwd").onkeyup = validatePasswd;
  configPasswdContainer();

  // Auto-Vervollständigung
  document.getElementById("plz").onblur = ortCompletion;
  document.getElementById("plz").onkeyup = removeOrt;
};