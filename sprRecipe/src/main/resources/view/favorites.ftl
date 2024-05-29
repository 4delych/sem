<!DOCTYPE html>
<#include "menu.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Избранные рецепты</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Избранные рецепты</h1>
<table>
    <thead>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Категория</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
    <#list favorites as favorite>
        <tr>
            <td>${favorite.recipe.name}</td>
            <td>${favorite.recipe.description}</td>
            <td>${favorite.recipe.category.categoryName}</td>
            <td>
                <form action="/favorites/remove/${favorite.id}" method="post">
                    <input type="hidden" name="favoriteId" value="${favorite.id}">
                    <button type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>
