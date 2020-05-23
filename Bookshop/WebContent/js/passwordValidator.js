function configPasswdContainer()
{
  var passwdInput  = document.getElementById("passwd");
  var rect = passwdInput.getBoundingClientRect();
  
  var div = document.createElement("div");
  div.id = "passwdErrorContainer"
  div.style.position = 'absolute';
  div.style.top = (rect.top) + "px";
  div.style.left = (rect.right + 2) + "px";
  div.style.visibility = "hidden";
  
  document.body.appendChild(div);
}

function showPasswd(strenght)
{
  var passwdMsg  = document.getElementById("passwdErrorContainer");
  passwdMsg.style.visibility = "visible";
  
  if( strenght == 3 )
  {
    passwdMsg.style.color = "green";
    passwdMsg.innerHTML   = "Password sehr sicher";
  }
  else if( strenght == 2 )
  {
    passwdMsg.style.color = "black";
    passwdMsg.innerHTML   = "Password sicher";
  }
  else if( strenght == 1 )
  {
    passwdMsg.style.color = "blue";
    passwdMsg.innerHTML   = "Password akzeptabel";
  }
  else
  {
    passwdMsg.style.color = "red";
    passwdMsg.innerHTML   = "Password unsicher";
  }
}



function validatePasswd()
{
   var passwdInput = document.getElementById("passwd").value;
  
   var hasLenght = passwdInput.length > 5? true : false;
   
   
   var numbersReg = /[0-9]+[^0-9]+[0-9]+/;
   var hasNumbers = numbersReg.test(passwdInput);
   
   var specialCharReg = /[!§$&?]+/;
   var hasSpecialChar = specialCharReg.test(passwdInput);
   
	
	if( hasLenght && hasNumbers && hasSpecialChar )
	{
	  showPasswd(3);
	}
	else if( hasLenght  && hasSpecialChar )
	{
	  showPasswd(2);
	}
	else if( hasLenght  )
   {
     showPasswd(1);
   }
	else
	{
	  showPasswd(0);
	}
}
