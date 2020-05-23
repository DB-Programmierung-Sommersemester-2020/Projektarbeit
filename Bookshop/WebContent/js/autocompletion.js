function removeOrt()
{ 
  document.getElementById("ort").value = "";
}

// AJAX-Request: Übergebene PLZ liefert Ortsname
function ortCompletion()
{  
  var plzInput  = document.getElementById("plz");
  var plz = plzInput.value;
    
  if( (plz.length != 5) || (isNaN(plz) == true) )
  {
    removeOrt();
    return;
  }
   
  var httpRequest = new XMLHttpRequest();
  
  httpRequest.onreadystatechange = function(e)
  {
     if (e.target.readyState == XMLHttpRequest.DONE ) 
     {
        var orte = e.target.responseText.split(";");
        var firstOrt = orte[0].substring(5, orte[0].length).trim();
        var ortInput  = document.getElementById("ort");
        ortInput.value = firstOrt;
     }
  };
  
  var url = "./ort?plz=" + plz;
  httpRequest.open("GET", url );
  httpRequest.send();
}


