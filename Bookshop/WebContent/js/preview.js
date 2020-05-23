window.onload = function()
{
  configPreViewContainer();
  configLinks();
};

// Konfigurtiert die angezeigetn Links mit
// JavaScript-Funktionalität
function configLinks()
{
  var linkTags = document.getElementsByTagName("a");
  
  for( var i=0; i < linkTags.length; i++ )
  {
    linkTags[i].onmouseover = showImage;
    linkTags[i].onmouseout = removeImage;
  }
}

// Konfiguriert einen div-Container, in dem die
// Preview-Bilder angezeigt werden
function configPreViewContainer()
{
  var table = document.getElementById("table");
  var rect = table.getBoundingClientRect();
  var div = document.createElement("div");
  div.id = "preView"
  div.style.position = 'absolute';
  div.style.top = (rect.top) + "px";
  div.style.left = (rect.right + 50) + "px";
  div.style.visibility = "visible";
  document.body.appendChild(div);
}

// Zeigt ein Bild in dem vorbereiteten div-Container an
function showImage(event)
{
  var preview = document.getElementById("preView");

  var image = event.target.id;

  var img = document.createElement("img");
  img.setAttribute("id", "image");
  img.setAttribute("src", "pic/" + image + ".jpg");
  img.setAttribute("width", "120");
  img.setAttribute("style", "visibility:visible");

  preview.appendChild(img);
}

// Löscht das angezeigte Bild, falls eines vorhanden ist
function removeImage()
{
  var preview = document.getElementById("preView");
  if (preview.hasChildNodes())
  {
    preview.removeChild(preview.firstChild);
  }
}
