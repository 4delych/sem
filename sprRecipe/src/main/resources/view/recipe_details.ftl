<html lang="en">
<#include "menu.ftl">
<head>
    <title>${recipe.name}</title>
</head>

<body>
    <h1>${recipe.name}</h1>

    <p>${recipe.description}</p>
    <p>${recipe.category.categoryName}</p>
    <a href = "/recipes">Назад</a>
</body>
</html>