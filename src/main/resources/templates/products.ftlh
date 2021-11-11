<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'productsTable.page.title'/></title>
    <style>
        h3 {
            color: red;
        }
    </style>
</head>
<html>
<body>
<h1><@spring.message 'productsTable.page.header'/></h1>
<h2><@spring.message 'productsTable.page.description'/></h2>
<h3><@spring.message 'productsTable.page.message'/></h3>
</body>
</html>