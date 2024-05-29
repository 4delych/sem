<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создать ингредиент</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Создать ингредиент</h1>
<form action="/admin/create-ingredient" method="post">
    <label for="name">Название ингредиента:</label>
    <input type="text" id="name" name="name" required>
    <button type="submit">Создать</button>
</form>

<a href="/admin/ingredients">К ингредиентам</a>
</body>
</html>
