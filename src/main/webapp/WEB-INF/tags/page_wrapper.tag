<%@ tag description="Page template" pageEncoding="UTF-8" %>
<%@ attribute name="scm_head" fragment="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:invoke fragment="scm_head"/>
</head>
<body>
<header class="scm-header">
    <div class="scm-header-name">
        <a href="<c:url value="/homePage"/>">
            <img class="scm-car-icon" src="<c:url value="/scm/images/car-icon.png"/>">
            TransportLogistics
        </a>
    </div>

    <c:choose>
        <c:when test="${profileExists}">
            <c:if test="${currentUserLoginRole eq 1}">
                <div class="scm-user-menu-element">
                    <a href="<c:url value="/carrier/rates"/>">Тарифы</a>
                </div>
                <div class="scm-user-menu-element">
                    <a href="<c:url value="/"/>">Маршруты</a>
                </div>
                <div class="scm-user-menu-element">
                    <a href="<c:url value="/"/>">Перевозки</a>
                </div>
                <div class="scm-user-menu-element">
                    <a href="<c:url value="/"/>">Формирование перевозки</a>
                </div>
            </c:if>

            <c:if test="${currentUserLoginRole eq 2}">
                <div class="scm-user-menu-element">
                    <a href="<c:url value="/cargoOwner/ticketRegistration"/>">Оформление заявки</a>
                </div>
                <div class="scm-user-menu-element">
                    <a href="<c:url value="/"/>">Перевозки</a>
                </div>
            </c:if>
        </c:when>

        <c:otherwise>
            <c:if test="${currentUserId ne null}">
                <div class="scm-help-profile">Создайте профиль для дальнейшей работы</div>
            </c:if>
        </c:otherwise>
    </c:choose>

    <nav class="scm-navigation">
        <ul class="scm-menu">
            <li>
                <c:choose>
                    <c:when test="${currentUserLogin ne null}">
                        <div class="scm-menu-title">${currentUserLogin}
                            <i class="fa fa-angle-right"></i>
                        </div>
                        <ul class="scm-submenu">
                            <c:if test="${currentUserLoginRole eq 1}">
                                <li class="scm-bottom-border"><a href="<c:url value="/carrier/profile"/>">Профиль</a>
                                </li>
                            </c:if>
                            <c:if test="${currentUserLoginRole eq 2}">
                                <li class="scm-bottom-border"><a href="<c:url value="/cargoOwner/profile"/>">Профиль</a>
                                </li>
                            </c:if>

                            <li><a href="<c:url value="/logout"/>">Выход</a></li>
                        </ul>
                    </c:when>

                    <c:otherwise>
                        <div class="scm-menu-title">Мой профиль
                            <i class="fa fa-angle-right"></i>
                        </div>
                        <ul class="scm-submenu">
                            <li class="scm-bottom-border"><a href="<c:url value="/signIn"/>">Вход</a></li>
                            <li><a href="<c:url value="/signUp"/>">Регистрация</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </nav>
</header>

<div class="scm-main">
    <article class="scm-container">
        <div class="scm-column-container">
            <jsp:doBody/>
        </div>
    </article>
</div>

<div class="scm-footer-container">
    <footer class="scm-footer">
        <div class="scm-horizontal-line"></div>
        <div>© 2018 TransportLogistics. Minsk, Belarus</div>
    </footer>
    <div class="scm-after-footer"></div>
</div>
</body>
</html>