<html lang="en">

<head>
    <title>Вход</title>
</head>

<body>
<h1>Вход</h1>
<#if error??>
    <div class="error">${error}</div>
</#if>
<#if logout??>
    <div class="success">${logout}</div>
</#if>
<form method="post">
    <label for="username">email
        <input type="text" name="username" placeholder="email" required autocomplete="new-password">
    </label>
    <label for="password"> password
        <input type="password" name="password" placeholder="password" required autocomplete="new-password">
    </label>
    <input type="submit" value="Войти">
</form>

<div>Нет аккаунта?</div>
<a href="/sign-up">Зарегестрироваться</a>
</body>