<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Вход</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/homePage.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/signUp.css"/>" >
</head>
<body>
<div class="headr">
    <header>
        <div class="name"><p class="lable">TransportLogistics</p></div>
        <nav1 class="one">
            <ul class="topmenu">
                <li><a href="#">Авторизация<i class="fa fa-angle-down"></i></a>
                    <ul class="submenu">
                        <li><a href="<c:url value="/html/signIn.jsp"/>">Вход</a></li>
                        <li><a href="<c:url value="/html/signUp.jsp"/>">Регистрация</a></li>
                    </ul>
                </li>
            </ul>
        </nav1>

    </header>
</div>

<div class="small">
    <article>
        <form action="" class="ui-form">
            <h3>Вход</h3>
            <div class="form-row">
                <input id="surname" type="text" autocomplete="off"><label for="surname">Логин</label>
            </div>
            <div class="form-row">
                <input id="password" type="password" autocomplete="off"><label for="password">Пароль</label>
            </div>

            <p><input type="submit" value="Войти" ></p>
        </form>
    </article>
</div>

<div class="foot">
    <footer>
        <div class="cop"><p class="pp">&copy;2017 By Arina Kondrashevich<br>
            Privacy Policy</p>
        </div>
    </footer>
</div>
</body>
</html>