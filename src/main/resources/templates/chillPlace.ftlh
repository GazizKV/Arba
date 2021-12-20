<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'restPlace.page.title'/></title>
    <link rel="stylesheet"
          href="<@spring.url '/css/cssFile.css'/>"
          type="text/css"
          media="screen"/>
</head>
<html>
<body>
<h1><@spring.message 'restPlace.page.header'/></h1>
<h2>Description of chill place</h2>
<p>${place.description}</p>
<form method="post" action="/chillPlaces/${place.id}/delete">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Delete">
</form>
<form method="get" action="/chillPlaces">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Back">
</form>
<h5>Load photo</h5>
<form action="/chillPlace/upLoadPhoto/${place.id}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="text" name="description" placeholder="Photo description"/><br>
    <input type="file" name="file"><br>
    <input type="submit" value="Photo Upload">
</form>
<hr>
<div><p>File upload message: ${uploadMessage}</p></div>
</body>
</html>