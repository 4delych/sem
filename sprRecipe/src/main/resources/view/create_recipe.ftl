<!DOCTYPE html>
<#include "menu.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создать рецепт</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Создать рецепт</h1>

<form action="/admin/create-recipe" method="post">
    <label for="name">Название:</label>
    <input type="text" id="name" name="name" required>

    <label for="description">Описание:</label>
    <textarea id="description" name="description" required></textarea>

    <label for="category">Категория:</label>
    <select id="category" name="categoryId" required>
        <#list categories as category>
            <option value="${category.categoryId}">${category.categoryName}</option>
        </#list>
    </select>
    <label for="ingredients">Ингредиенты:</label>
    <#list ingredients as ingredient>
        <div>
            <input type="checkbox" id="ingredient-${ingredient.ingredientId}" name="ingredientIds" value="${ingredient.ingredientId}">
            <label for="ingredient-${ingredient.ingredientId}">${ingredient.name}</label>
        </div>
    </#list>

    <button type="submit">Создать рецепт</button>
</form>

<a href="/recipes">К списку рецептов</a>
</body>
</html>
