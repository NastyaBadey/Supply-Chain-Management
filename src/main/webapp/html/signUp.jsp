<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="scm" tagdir="/WEB-INF/tags" %>

<scm:page_wrapper>
    <jsp:attribute name="scm_head">
        <meta charset="utf-8">
        <title>Регистрация</title>
        <link href="<c:url value="/images/car-icon.png"/>" rel="shortcut icon" type="image/png">
        <link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css" >
        <link href="<c:url value="/css/signUp.css"/>" rel="stylesheet" type="text/css" >
        <link href="<c:url value="/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css" >
    </jsp:attribute>

    <jsp:attribute name="scm_header">
        <div class="scm-menu-title">Мой профиль
            <i class="fa fa-angle-right"></i>
        </div>
        <ul class="scm-submenu">
            <li class="scm-bottom-border"><a href="<c:url value="/html/signIn.jsp"/>">Вход</a></li>
            <li><a href="<c:url value="/html/signUp.jsp"/>">Регистрация</a></li>
        </ul>
    </jsp:attribute>

    <jsp:body>
        <div class="scm-center-form">
            <form action="" class="scm-form">
                <div class="scm-center-title scm-form-title">Регистрация</div>

                <div class="scm-form-row">
                    <div class="scm-row-container">
                        <input id="owner" name="user_role" type="radio" class="scm-input-radio" value="cargo_owner" checked>
                        <label for="owner">Владелец груза</label>
                    </div>
                    <div class="scm-row-container">
                        <input id="carrier" name="user_role" type="radio" class="scm-input-radio" value="carrier">
                        <label for="carrier">Перевозчик</label>
                    </div>
                </div>

                <div class="scm-form-row">
                    <input id="surname" size="28" class="scm-input-text scm-row-container" required maxlength="25" autocomplete="off">
                    <label for="surname" class="scm-form-label scm-row-container">Логин</label>
                </div>

                <div class="scm-form-row">
                    <input id="password" type="password" size="28" class="scm-input-text scm-row-container" required maxlength="25" autocomplete="off">
                    <label for="password" class="scm-form-label scm-row-container">Пароль</label>
                </div>

                <div class="scm-form-row">
                    <input id="email" type="email" size="28" class="scm-input-text scm-row-container" required maxlength="25" autocomplete="off">
                    <label for="email" class="scm-form-label scm-row-container">Email</label>
                </div>

                <input type="submit" value="Зарегистрироваться" >
            </form>
        </div>
    </jsp:body>
</scm:page_wrapper>