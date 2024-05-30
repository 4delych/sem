<!DOCTYPE html>
<html lang="en">
<#include "menu.ftl">

<head>
    <meta charset="UTF-8">
    <title>Random Recipe</title>
</head>
<body>
<h1>Random Recipe</h1>
<form action="/random-recipe" method="post">
    <button type="submit">Get Random Recipe</button>
</form>

<#if recipe??>
    <h2>Recipe Details</h2>
    <pre>${recipe}</pre>
</#if>
</body>
</html>
