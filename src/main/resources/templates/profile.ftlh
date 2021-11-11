<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'profile.page.title'/></title>
    <style>
        a {
            color: red;
        }
    </style>
</head>
<html>
<body>
<h1><@spring.message 'profile.page.header'/></h1>
<h2><@spring.message 'profile.page.description'/></h2>
<h2><a href="/logout" >Log Out</a></h2>
</body>
</html>