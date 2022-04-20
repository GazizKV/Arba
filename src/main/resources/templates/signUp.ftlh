<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'signUp.page.title'/></title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/cssFile.css'/>"/>
    <script src="/javaScript/javascript.js"></script>
</head>
<html>
<body>
<div class="signUpContainer">
    <h1><@spring.message 'signUp.page.header'/></h1>
    <h2><@spring.message 'signUp.page.description'/></h2>
    <form action="/signUp" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <@spring.bind path="signUpForm"/>
        <p class="error">${spring.status.errorMessage}</p>
        <label for="firstName"><@spring.message 'signUp.form.label.enterFirstName'/></label>
        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.firstName"/></#assign>
        <@spring.formInput "signUpForm.firstName" "placeholder=${i18Tooltip}"/>
        <@spring.showErrors "<br>" "error"/>
        <br>
        <br>
        <label for="lastName"><@spring.message 'signUp.form.label.enterLastName'/></label>
        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.lastName"/></#assign>
        <@spring.formInput "signUpForm.lastName" "placeholder=${i18Tooltip}"/>
        <@spring.showErrors "<br>" "error"/>
        <br>
        <br>
        <label for="email"><@spring.message 'signUp.form.label.enterEmail'/></label>
        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.email"/></#assign>
        <@spring.formInput "signUpForm.email" "placeholder=${i18Tooltip}"/>
        <@spring.showErrors "<br>" "error"/>
        <br>
        <br>
        <label for="password"><@spring.message 'signUp.form.label.enterPassword'/></label>
        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.password"/></#assign>
        <@spring.formPasswordInput "signUpForm.password" "placeholder=${i18Tooltip}"/>
        <@spring.showErrors "<br>" "error"/>
        <br>
        <br>
        <input type="submit" value="Sign Up"><br>
    </form>
    <form method="get" action="/signIn">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="Go to sign in page">
    </form>
    <form method="get" action="/chillPlaces">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="Список мест отдыха">
    </form>
</div>
</body>
</html>