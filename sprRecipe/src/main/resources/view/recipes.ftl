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

<form action="/recipes" method="get">
    <label for="ingredient">Фильтр по ингредиентам:</label>
    <select id="ingredient" name="ingredientIds" multiple>
        <#list ingredients as ingredient>
            <option value="${ingredient.id}"
                    <#if selectedIngredients??>
                        <#if selectedIngredients?seq_contains(ingredient.id)>
                            selected
                        </#if>
                    </#if>
            >${ingredient.name}</option>
        </#list>
    </select>
    <button type="submit">Фильтровать</button>
    <button><a href="/recipes">Сбросить фильтр</a></button>
</form>


<table>
    <thead>
    <tr>
        <th>Название</th>
        <th>Категория</th>
        <#if user.role == "ROLE_ADMIN">
            <th>Действие</th>
        </#if>
    </tr>
    </thead>
    <tbody>
    <#list recipes as recipe>
        <tr>
            <td><a href="/recipe/${recipe.recipe_id}">${recipe.name}</a></td>
            <td>${recipe.category.categoryName}</td>
            <#if user.role == "ROLE_ADMIN">
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
