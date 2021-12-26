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
<div>
    <p>Photos</p>
    <#list place.listPhotoId as id>
        <p><b>${id}</b></p>
    </#list>
</div>
<p>address: ${place.address}</p>
<p>phone: ${place.phone}</p>
<form method="get" action="/chillPlaces">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Back to shillPlaces">
</form>
</body>
</html>