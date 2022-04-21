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
    <script src="/javaScript/javascript.js"></script>
</head>
<body>
<hr>
<form method="get" action="/profile">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Профиль">
</form>
<hr>
<form action="/chillPlaces/search" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="Title searcher">Поиск по имени</label>
    <input type="text" name="searchString" value="">
    <input type="submit" value="Искать">
</form>
<#list chillPlaces as chillPlace>
    <div class="chillPlaceComponentContainer">
        <div id="chillPlaceComponent_photo"><img src="image" alt="photo">${chillPlace.id}</div>
        <div id="chillPlaceComponent_title_keyWords">
            <div class="row-box">
                <h3>${chillPlace.name}</h3>
                <form method="post" action="/chillPlace/${chillPlace.id}/select">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" style="display: none">
                    <input type="submit" value="Подробнее">
                </form>
            </div>
            <p>${chillPlace.description}</p>
        </div>
        <div id="chillPlaceComponent_badges">
            <#list chillPlace.badgeSet as badge>
                <p>${badge.name}</p>
            </#list>
        </div>
        <div id="chillPlaceComponent_contact">
            <p>${chillPlace.phone}</p>
            <p>${chillPlace.address}</p>
        </div>
    </div>
</#list>
</body>
</html>