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
<form method="post" action="/chillPlace/upLoadPhoto/${place.id}" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="file">Выберете 1 файл для загрузки</label><br>
    <input type="file" name="file"><br>
    <label for="description">Введите описание фото</label><br>
    <input type="text" name="description" placeholder="description"/><br>
    <input type="submit" value="File Upload">
</form>
<hr>
<div><p>File upload message: ${uploadMessage}</p></div>
</body>
</html>