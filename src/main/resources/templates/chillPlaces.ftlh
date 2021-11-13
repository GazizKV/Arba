<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>RestPlace</title>
</head>
<body>
<table id="accounts_table">
    <tr>
        <th>Action</th>
        <th>Title</th>
        <th>Service rate</th>
        <th>Contacts</th>
    </tr>
    <#list chillPlaces as chillPlace>
        <tr>
            <td>
                <form method="post" action="/chillPlaces/${chillPlace.id}/select">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Select">
                </form>
            </td>
            <td>${chillPlace.name}</td>
            <td>${chillPlace.service_rate}</td>
            <td>${chillPlace.contact}</td>
            <td></td>
        </tr>
    </#list>
</table>
</body>
</html>