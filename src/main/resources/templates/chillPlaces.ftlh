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
<form action="/chillPlaces/fileUpload" method="post" enctype="multipart/form-data">
    <label for="description">Description</label>
    <input type="text" id="description" name="description" placeholder="Enter description...">
    <br>
    <input type="file" name="file">
    <input type="submit" value="File Upload">
</form>
<hr/>
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
                <form method="post" action="/chillPlaces/${chillPlace.name}/select">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Select">
                </form>
            </td>
            <td>${chillPlace.name}</td>
            <td>${chillPlace.serviceRate}</td>
            <td>${chillPlace.contactDto.email}</td>
            <td></td>
        </tr>
    </#list>
</table>
</body>
</html>