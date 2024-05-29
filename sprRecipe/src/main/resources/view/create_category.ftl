<!DOCTYPE html>
<#include "menu.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создать категорию</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Создать категорию</h1>
<form action="/admin/create-category" method="post">
    <label for="categoryName">Название категории:</label>
    <input type="text" id="categoryName" name="categoryName" required>
    <button type="submit">Создать</button>
</form>

<a href="/admin">Назад</a>
</body>
</html>
