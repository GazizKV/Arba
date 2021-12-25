<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'profile.page.title'/></title>
    <link rel="stylesheet"
          href="<@spring.url '/css/cssFile.css'/>"
          type="text/css"
          media="screen"/>
    <script src="/javaScript/javascript.js"></script>
</head>
<html>
<body>
<h1><@spring.message 'profile.page.header'/></h1>
<h2><@spring.message 'profile.page.description'/></h2>
<form method="get" action="/chillPlaces">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="ChillPlaces">
</form>
<form action="/addChillPlace" method="get">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Go to creat or add chillPlace">
</form>
<form method="get" action="/accounts">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Accounts only for ADMIN">
</form>
<h2><a href="/logout">Log Out</a></h2>
</body>
</html>