<html lang="en">
<#include "menu.ftl">
<head>
    <title>${recipe.name}</title>
</head>

<body>
    <h1>${recipe.name}</h1>

    <p>${recipe.description}</p>
    <p>${recipe.category.categoryName}</p>
    <form action="/recipe/${recipe.recipe_id}/favorite" method="post">
        <input type="hidden" name="recipeId" value="${recipe.recipe_id}">
        <button type="submit">Добавить в избранное</button>
    </form>
    <a href = "/recipes">Назад</a>
</body>
</html>