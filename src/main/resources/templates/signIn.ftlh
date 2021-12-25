<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'signIn.page.title'/></title>
    <link rel="stylesheet"
          href="<@spring.url '/css/cssFile.css'/>"
          type="text/css"
          media="screen"/>
    <script src="/javaScript/javascript.js"></script>
</head>
<html>
<body>
<div id="sign_in_form">
    <h1><@spring.message 'signIn.page.header'/></h1>
    <h2><@spring.message 'signIn.page.description'/></h2>
    <form action="/signIn" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <label for="email">Enter email</label>
        <br/>
        <input id="email" type="email" name="email" placeholder="Email"/>
        <br/>
        <label for="password">Enter password</label>
        <br/>
        <input id="password" type="password" name="password" placeholder="Password"/>
        <br/>
        <label>
            <input type="checkbox" name="rememberMe" value="rememberMe">Remember me
        </label><br/>
        <input type="submit" value="Sing In">
    </form>
    <form method="get" action="/signUp">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="To signUp Page">
    </form>
</div>
</body>
</html>