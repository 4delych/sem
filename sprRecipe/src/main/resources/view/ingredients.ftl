<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список ингредиентов</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Список ингредиентов</h1>
<table>
    <thead>
    <tr>
        <th>Название ингредиента</th>
    </tr>
    </thead>
    <tbody>
    <#list ingredients as ingredient>
        <tr>
            <td>${ingredient.name}</td>
            <td>
                <form action="/admin/delete-ingredient/${ingredient.id}" method="post">
                    <button type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </#list>
    </tbody>
</table>

<a href="/admin/create-ingredient">Создать новый ингредиент</a>

<a href="/admin">Назад</a>
</body>
</html>
