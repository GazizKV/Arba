<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<html>
<head>
    <title>Accounts</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/cssFile.css'/>"/>
    <script src="/javaScript/javascript.js"></script>
</head>
<body>
<form method="get" action="/profile">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Back to profile">
</form>
<table id="accounts_table">
    <tr>
        <th>Action</th>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <#list accounts as account>
        <tr>
            <td>
                <form method="post" action="/accounts/${account.id}/delete">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>${account.id}</td>
            <td>${account.firstName}</td>
            <td>${account.lastName}</td>
            <td>${account.email}</td>
        </tr>
    </#list>
</table>
</body>
</html>
