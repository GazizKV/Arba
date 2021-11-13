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
<h2><@spring.message 'restPlace.page.description'/></h2>
<p>Text description: ${restPlace.description}</p>
</body>
</html>