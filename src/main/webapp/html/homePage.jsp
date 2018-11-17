<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Главная</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/homePage.css"/>" >
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
        <div>
            <div id="text"><img src="<c:url value="/css/homePage.css"/>" class="cars" alt="cars">
                <p>Компания «TransportLogistic» специализируется на международных грузоперевозках комплектных и сборных грузов автомобильным
                    транспортом по направлениям: Европа—Беларусь, Россия – Беларусь, Прибалтика — Беларусь, Европа – Россия,
                    Прибалтика – Россия, Европа – Казахстан и Средняя Азия, Прибалтика – Казахстан и Средняя Азия,
                    Украина – Беларусь, Прибалтика – Украина, перевозки внутри Европы (Германия – Прибалтика, Германия – Польша и др.)
                    Компания является постоянным и надёжным партнёром многих крупных
                    белорусских предприятий в предоставлении транспортно-экспедиционных и логистических услуг.<br><br></p>
            </div>
            <div id="history">О нас</div>
            <div class="onediv">
                <div class="circle">1</div>
                <div class="citx">
                    <b>Мы стремимся
                        сделать мир лучше.</b>
                    Постоянно повышаем качество сервиса в области логистики. Мы ведем свой бизнес открыто и развиваем предпринимательство.
                    <br><b>Мы строим большую
                    компанию.</b>
                    Успех который постоен на профессионализме, саморазвитие и самореализации наших сотрудников.
                    <br><b>Доставляем радость
                    и качественный сервис.</b>
                    Удовлетворяем потребности клиента и решаем любые задачи, сохраняя при этом высочайшее качество продукта и клиентского сервиса.
                </div>
            </div>
            <div class="onediv">
                <div class="circle">2</div>
                <div class="citx">
                    <b>Честность
                        и открытость.</b>
                    Мы ничего не скрываем от клиентов и всегда готовы исправлять ошибки.
                    Выполняем на себя обязательства перед сотрудниками. Честны и открыты с партнерами компании.
                    <br><b>Уважение
                    и поддержка.</b>
                    Мы уважаем любой труд в нашей компании и поддерживаем коллег.
                    Стремимся создать хорошие условия для комфортной работы, профессионального и личного развития сотрудников.
                    <br><b>Нет ничего
                    невозможного.</b>
                    Только мы сами определяем границы наших возможностей.
                    Мы ставим перед собой большие и амбициозные цели, добиваясь результатов с помощью упорного труда и настойчивости.
                </div>
            </div>
        </div>
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