<!DOCTYPE html>
<#include "menu.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список рецептов</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Список рецептов</h1>
<table>
    <thead>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Категория</th>
        <#if user.role = "ROLE_ADMIN">
            <th>Действие</th>
        </#if>
    </tr>
    </thead>
    <tbody>
    <#list recipes as recipe>
        <tr>
            <td><a href="/recipe/${recipe.recipe_id}">${recipe.name}</a></td>
            <td>${recipe.description}</td>
            <td>${recipe.category.categoryName}</td>
            <#if user.role = "ROLE_ADMIN">
                <td>
                    <form action="/admin/delete-recipe/${recipe.recipe_id}" method="post">
                        <button type="submit">Удалить</button>
                    </form>
                </td>
            </#if>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>
