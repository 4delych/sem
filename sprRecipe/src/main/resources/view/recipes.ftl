<!DOCTYPE html>
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
    </tr>
    </thead>
    <tbody>
    <#list recipes as recipe>
        <tr>
            <td>${recipe.name}</td>
            <td>${recipe.description}</td>
            <td>${recipe.category}</td>
        </tr>
    </#list>
    </tbody>
</table>
<a href="/create-recipe">Создать новый рецепт</a>
</body>
</html>