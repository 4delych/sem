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
            <td><a href="/categories/${category.categoryId}">${category.categoryName}</a></td>
            <#if user.role = "ROLE_ADMIN" >
                <td>
                    <form action="/admin/delete-category/${category.categoryId}" method="post">
                        <input type="hidden" name="categoryId" value="${category.categoryId}">
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
