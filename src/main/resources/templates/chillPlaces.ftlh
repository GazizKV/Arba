<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RestPlace</title>
</head>
<style>
    label, input {
        margin: 10px;
    }
    table, tr, td {
        border: 1px solid;
    }
</style>
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
<table id="chillPlaces_table">
    <tr>
        <th>Action</th>
        <th>Title</th>
        <th>Service rate</th>
        <th>Contacts</th>
        <th>Load file or photo into place</th>
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
                <form action="/chillPlaces/upLoadPhoto/${place.id}">
                    <input type="text" name="description" placeholder="Photo description"/>
                    <input type="file" name="file">
                    <input type="submit" value="Photo Upload">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>