<html lang="en">
<#include "menu.ftl">
<head>
    <title>Профиль пользователя</title>
</head>

<body>
<h1>Профиль</h1>
<div>
    <strong>Имя:</strong> ${user.username}<br>
    <strong>Имя:</strong> ${user.firstName}<br>
    <strong>Фамилия:</strong> ${user.lastName}<br>
    <a href="/logout">Выйти</a>
    <#if user.role = "ROLE_ADMIN">
        <a href="/admin">Панель администратора</a>
    </#if>
</div>
</body>
</html>
