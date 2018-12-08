<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Главная</title>
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css" >
    <link href="<c:url value="/css/homePage.css"/>" rel="stylesheet" type="text/css" >
    <link href="<c:url value="/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css" >
    <link rel="shortcut icon" href="<c:url value="/images/car-icon.png"/>" type="image/png">
</head>
<body>
<header class="scm-header">
    <div class="scm-header-name">
        <a href="<c:url value="/html/homePage.jsp"/>" >
            <img class="scm-car-icon" src="<c:url value="/images/car-icon.png"/>">
            TransportLogistics
        </a>
    </div>
    <nav class="scm-navigation">
        <ul class="scm-menu">
            <li>
                <div class="scm-menu-title">Мой профиль
                    <i class="fa fa-angle-right"></i>
                    <i class="fa fa-angle-down"></i>
                </div>
                <ul class="scm-submenu">
                    <li class="scm-bottom-border"><a href="<c:url value="/html/signIn.jsp"/>">Вход</a></li>
                    <li><a href="<c:url value="/html/signUp.jsp"/>">Регистрация</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>

<div class="scm-main">
    <article class="scm-container">
        <div class="scm-column-container">
            <div class="scm-title">О нас</div>
            <div class="scm-text-with-indent">
                <img src="<c:url value="/images/others/cars.png"/>" class="cars" alt="Cars">
                Компания <b>«TransportLogistic»</b> специализируется на международных грузоперевозках комплектных и сборных грузов автомобильным
                    транспортом по направлениям: Европа—Беларусь, Россия – Беларусь, Прибалтика — Беларусь, Европа – Россия,
                    Прибалтика – Россия, Европа – Казахстан и Средняя Азия, Прибалтика – Казахстан и Средняя Азия,
                    Украина – Беларусь, Прибалтика – Украина, перевозки внутри Европы (Германия – Прибалтика, Германия – Польша и др.)
                    Компания является постоянным и надёжным партнёром многих крупных
                    белорусских предприятий в предоставлении транспортно-экспедиционных и логистических услуг.
            </div>
            <div class="scm-column-container">
                <div class="scm-row-container">
                    <div class="scm-list">
                        <div class="circle">1</div>
                        <div class="scm-about-company">
                            <b>Мы стремимся сделать мир лучше.</b>
                            Постоянно повышаем качество сервиса в области логистики. Мы ведем свой бизнес открыто и развиваем предпринимательство.
                            <br>
                            <b>Мы строим большую компанию.</b>
                            Успех который постоен на профессионализме, саморазвитие и самореализации наших сотрудников.
                            <br>
                            <b>Доставляем радость и качественный сервис.</b>
                            Удовлетворяем потребности клиента и решаем любые задачи, сохраняя при этом высочайшее качество продукта и клиентского сервиса.
                        </div>
                    </div>
                </div>

                <div class="scm-row-container">
                    <div class="scm-list">
                        <div class="circle">2</div>
                        <div class="scm-about-company">
                            <b>Честность и открытость.</b>
                            Мы ничего не скрываем от клиентов и всегда готовы исправлять ошибки.
                            Выполняем на себя обязательства перед сотрудниками. Честны и открыты с партнерами компании.
                            <br>
                            <b>Уважение и поддержка.</b>
                            Мы уважаем любой труд в нашей компании и поддерживаем коллег.
                            Стремимся создать хорошие условия для комфортной работы, профессионального и личного развития сотрудников.
                            <br>
                            <b>Нет ничего невозможного.</b>
                            Только мы сами определяем границы наших возможностей.
                            Мы ставим перед собой большие и амбициозные цели, добиваясь результатов с помощью упорного труда и настойчивости.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </article>
</div>

<div class="scm-footer-container">
    <footer class="scm-footer">
        <div class="scm-horizontal-line"></div>
        <div>© 2018 TransportLogistics Minsk, Belarus</div>
    </footer>
    <div class="scm-after-footer"></div>
</div>
</body>
</html>