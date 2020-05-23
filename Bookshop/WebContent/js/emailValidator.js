
function configEmailErrorContainer()
{
  var emailInput  = document.getElementById("email");
  var rect = emailInput.getBoundingClientRect();
  var div = document.createElement("div");
  document.body.appendChild(div);
  
  div.id = "emailErrorContainer"
  div.style.color = "red";
  div.innerHTML   = "E-Mail hat falsches Format";
  div.style.position = 'absolute';
  div.style.top = (rect.top) + "px";
  div.style.left = (rect.right + 2) + "px";
  div.style.visibility = "hidden";
}

function showEmailError(show)
{
  var errorMsg  = document.getElementById("emailErrorContainer");
  
  if( show )
    errorMsg.style.visibility = "visible";
  else
    errorMsg.style.visibility = "hidden";
}


function clearEmailErrorMsg()
{
  showEmailError(false);
}


function validateEmail()
{
   var emailInput = document.getElementById("email").value;
  
	var emailFormat = /^[a-zA-Z]{4}[0-9]{4}(@stud\.((hs-kl)|(fh-kl))\.de){1}$/;
	var emailOk = emailFormat.test(emailInput);
	
	if( emailOk == true )
	{
	  showEmailError(false);
	}
	else
	{
	  showEmailError(true);
	}
}
