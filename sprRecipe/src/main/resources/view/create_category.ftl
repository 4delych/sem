<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создать категорию</title>
    <link rel="stylesheet" href="/res/style.css">
</head>
<body>
<h1>Создать категорию</h1>
<form action="/create-category" method="post">
    <label for="categoryName">Название категории:</label>
    <input type="text" id="categoryName" name="categoryName" required>
    <button type="submit">Создать</button>
</form>
</body>
</html>
