<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'restPlace.page.title'/></title>
    <style>
        .error {
            color: red;
        }
        input, label {
            margin: 10px;
        }
    </style>
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
</body>
</html>