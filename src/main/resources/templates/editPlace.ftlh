<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'restPlace.page.title'/></title>
    <link rel="stylesheet"
          href="<@spring.url '/css/cssFile.css'/>"
          type="text/css"
          media="screen"/>
    <script src="/javaScript/javascript.js"></script>
</head>
<html>
<body>
<h1>${place.name}</h1>
<h2>Description of chill place</h2>
<p>${place.description}</p>
<p>address: ${place.address}</p>
<p>phone: ${place.phone}</p>
<form method="get" action="/profile">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Back to profile">
</form>
<h5>Load photo</h5>
<form method="post" action="/chillPlace/upLoadPhoto/${place.id}" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="file">Выберете фото для загрузки</label><br>
    <input type="file" name="file"><br>
    <label for="description">Введите описание фото</label><br>
    <input type="text" name="description" placeholder="description"/><br>
    <input type="submit" value="File Upload">
</form>
<div><p>File upload message: ${uploadMessage}</p></div>
<hr>
<form method="post" action="/editPlace/delete/${place.id}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="delete">That button is delete this place</label>
    <input type="submit" value="Delete" id="delete">
</form>
</body>
</html>