<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'profile.page.title'/></title>
    <style>
        a {
            color: red;
        }
        div, input, form {
            margin: 20px;
        }
    </style>
</head>
<html>
<body>
<h1>Chill place's photos</h1>
<h2>Description chil place</h2>

<div>
    <c:forEach items="${streamList}" var="file">
        <tr>
            <td>|   ${file.encoding}    |</td>
            <td>|   ${file.separator}   |</td>
        </tr>
    </c:forEach>
</div>

<form method="get" action="/chillPlaces">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Chill places">
</form>
<form method="get" action="/accounts">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Accounts only for ADMIN">
</form>
<form method="get" action="/fileUpload">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Upload file">
</form>
<h2><a href="/logout" >Log Out</a></h2>
</body>
</html>