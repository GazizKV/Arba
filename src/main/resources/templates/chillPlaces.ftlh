<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RestPlace</title>
    <link rel="stylesheet"
          href="<@spring.url '/css/cssFile.css'/>"
          type="text/css"
          media="screen"/>
</head>
<body>
<hr>
<form method="get" action="/profile">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Profile">
</form>
<form action="/chillPlaces/insertIntoDataBaseNewChillPlace" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="name">Enter chillPlace's name or title:</label>
    <@spring.formInput "chillPlaceDto.name" "placeholder='place name'"/><br/>
    <label for="description">Enter description of chill place:</label>
    <@spring.formInput "chillPlaceDto.description" "placeholder='place description'"/><br/>
    <input type="submit" value="Creat chillPlace">
</form>
<hr>
<form action="/chillPlaces/search" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="Title searcher">Search by title</label>
    <input type="text" name="searchString">
    <input type="submit">
</form>
<hr>
<div><p>File upload message: ${uploadMessage}</p></div>
<table id="chillPlaces_table">
    <tr>
        <th>Action</th>
        <th>Title</th>
        <th>Service rate</th>
        <th>Description</th>
        <th>Load file or photo into place</th>
        <th>Chill place photos</th>
    </tr>
    <#list chillPlaces as place>
        <tr>
            <td>
                <form method="post" action="/chillPlace/${place.id}/select">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Select">
                </form>
            </td>
            <td>${place.name}</td>
            <td>${place.serviceRate}</td>
            <td>${place.description}</td>
            <td>
                <form action="/chillPlaces/upLoadPhoto/${place.id}" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="text" name="description" placeholder="Photo description"/><br>
                    <input type="file" name="file"><br>
                    <input type="submit" value="Photo Upload">
                </form>
            </td>
            <td>
                <a href="/photo/getPhoto/${place.id}" target="_blank">Link to photo for that chill place</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>