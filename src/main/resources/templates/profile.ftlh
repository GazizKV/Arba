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
<h1>${account.lastName} ${account.firstName}</h1>
<h2>email: ${account.email}</h2>
<h2>role: ${account.role}</h2>
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
<#list places as place>
    <div class="chillPlaceComponentContainer">
        <div id="chillPlaceComponent_photo"><img src="image" alt="photo">${place.id}</div>
        <div id="chillPlaceComponent_title_keyWords">
            <h3>${place.name}</h3>
            <form method="post" action="/editPlace/get/${place.id}">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input type="submit" value="edit">
            </form>
            <p>${place.description}</p>
        </div>
        <div id="chillPlaceComponent_contact"><p>phone: ${place.phone}</p><br><p>address: ${place.address}</p></div>
    </div>
</#list>
</body>
</html>