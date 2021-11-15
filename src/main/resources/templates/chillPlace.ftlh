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
</body>
</html>