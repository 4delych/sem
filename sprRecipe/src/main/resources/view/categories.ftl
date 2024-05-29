<!DOCTYPE html>
<#include "menu.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список категорий</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Список категорий</h1>
<table>
    <thead>
    <tr>
        <th>Название категории</th>
    </tr>
    </thead>
    <tbody>
    <#list categories as category>
        <tr>
            <td>${category.categoryName}</td>
        </tr>
    </#list>
    </tbody>
</table>
<a href="/create-category">Создать новую категорию</a>
</body>
</html>
