<!DOCTYPE html>
<#include "menu.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Recipe</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Edit Recipe</h1>
<form action="/admin/recipe/${recipe.recipe_id}/edit" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" value="${recipe.name}"><br>
    <label for="description">Description:</label><br>
    <textarea id="description" name="description">${recipe.description}</textarea><br>
    <label for="categoryId">Category:</label><br>
    <select id="categoryId" name="categoryId">
        <#list categories as category>
            <option value="${category.categoryId}" <#if category.categoryId == recipe.category.categoryId>selected</#if>>${category.categoryName}</option>
        </#list>
    </select><br>
    <label for="ingredientIds">Ingredients:</label><br>
    <select id="ingredientIds" name="ingredientIds" multiple>
        <#list ingredients as ingredient>
            <option value="${ingredient.ingredientId}" <#if recipe.ingredients?seq_contains(ingredient)>selected</#if>>${ingredient.name}</option>
        </#list>
    </select><br><br>
    <button type="submit">Save Changes</button>
</form>
</body>
</html>
