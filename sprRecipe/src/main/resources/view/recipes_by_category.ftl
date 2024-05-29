<html lang="en">
<#include "menu.ftl">

<head>
    <title>${category.categoryName}</title>
</head>

<body>
<table>
    <thead>
    <tr>
        <th>Название рецепта</th>
        <th>Описание</th>
    </tr>
    </thead>
    <tbody>
    <#list recipes as recipe>
        <tr>
            <td><a href="/recipe/${recipe.recipe_id}">${recipe.name}</a></td>
            <td>${recipe.description}</td>
        </tr>
    </#list>
    </tbody>

    <a href="/categories">Назад</a>
</table>
</body>

</html>