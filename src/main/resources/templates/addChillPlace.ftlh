<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title>AddRestPlace</title>
    <link rel="stylesheet"
          href="<@spring.url '/css/cssFile.css'/>"
          type="text/css"
          media="screen"/>
</head>
<html>
<body>
<h1>Add rest place</h1>
<form method="get" action="/profile">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Back to profile page">
</form>
<form action="/addChillPlace/insertIntoDataBaseNewChillPlace" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="name">Enter chillPlace's name or title:</label>
    <@spring.formInput "chillPlaceDto.name" "placeholder='place name'"/><br/>
    <label for="description">Enter description of chill place:</label>
    <@spring.formInput "chillPlaceDto.description" "placeholder='place description'"/><br/>
    <input type="submit" value="Add chilPlace">
</form>
<hr>
<div><p>File upload message: ${uploadMessage}</p></div>
</body>
</html>