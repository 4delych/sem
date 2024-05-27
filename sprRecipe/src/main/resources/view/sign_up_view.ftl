<html lang="en">

<head>
    <title>Регистрация</title>
</head>

<body>
<h1>Регистрация</h1>
<#if error??>
    <div class="error">${error}</div>
</#if>
<form action="/sign-up" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required autocomplete="new-password">

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required autocomplete="new-password">

    <label for="username">Email:</label>
    <input type="text" id="username" name="username" required autocomplete="new-password">

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required minlength="5" autocomplete="new-password">

    <button type="submit">Зарегистрироваться</button>
</form>


<div>Уже есть аккаунт?</div>
<a href="/sign-in">Войти</a>
</body>