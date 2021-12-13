<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'product.page.title'/></title>
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
<h1><@spring.message 'product.page.header'/></h1>
<h2><@spring.message 'product.page.description'/></h2>

<form action="/product" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <@spring.bind path="productForm"/>
    <p class="error">${spring.status.errorMessage}</p>
    <label for="name"><@spring.message 'product.page.enterName'/></label>
    <#assign placeHoldersVariable><@spring.message code='product.page.placeholder.productName'/></#assign>
    <@spring.formInput "productForm.name" "placeholder=${placeHoldersVariable}"/>
    <@spring.showErrors "<br>" "error"/>
    <br>
    <br>
    <label for="mass"><@spring.message 'product.page.enterMass'/></label>
    <#assign placeHoldersVariable><@spring.message code='product.page.placeholder.productMass'/></#assign>
    <@spring.formInput "productForm.mass" "placeholder=${placeHoldersVariable}"/>
    <@spring.showErrors "<br>" "error"/>
    <br>
    <br>
    <label for="vin"><@spring.message 'product.page.enterVin'/></label>
    <#assign placeHoldersVariable><@spring.message code='product.page.placeholder.productVin'/></#assign>
    <@spring.formInput "productForm.vin" "placeholder=${placeHoldersVariable}"/>
    <@spring.showErrors "<br>" "error"/>
    <br>
    <br>
    <label for="date"><@spring.message 'product.page.enterProductProducedDate'/></label>
    <#assign placeHoldersVariable><@spring.message code='product.page.placeholder.productDate'/></#assign>
    <@spring.formInput "productForm.date" "placeholder=${placeHoldersVariable}"/>
    <@spring.showErrors "<br>" "error"/>
    <br>
    <br>
    <input type="submit" value="<@spring.message 'product.page.submit.value'/>">
</form>
</body>
</html>