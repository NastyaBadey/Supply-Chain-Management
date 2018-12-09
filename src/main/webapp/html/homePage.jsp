<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="scm" tagdir="/WEB-INF/tags" %>

<scm:page_wrapper>
    <jsp:attribute name="scm_head">
        <meta charset="utf-8">
        <title>Главная</title>
        <link href="<c:url value="/images/car-icon.png"/>" rel="shortcut icon" type="image/png">
        <link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css" >
        <link href="<c:url value="/css/homePage.css"/>" rel="stylesheet" type="text/css" >
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
        <div class="scm-main-info">
            TransportLogistics<br>Забота о вашем грузе
        </div>

        <div class="scm-center-container">
            <div class="scm-column-container">
                <div class="scm-row-container scm-title-row">
                    <div class="scm-about-title">О нас</div>
                    <div class="scm-text-with-indent">
                        <%--<img src="<c:url value="/images/cars.png"/>" class="cars" alt="Cars">--%>
                        Компания <b>«TransportLogistic»</b> специализируется на международных грузоперевозках комплектных и сборных грузов автомобильным
                        транспортом по направлениям: Европа—Беларусь, Россия – Беларусь, Прибалтика — Беларусь, Европа – Россия,
                        Прибалтика – Россия, Европа – Казахстан и Средняя Азия, Прибалтика – Казахстан и Средняя Азия,
                        Украина – Беларусь, Прибалтика – Украина, перевозки внутри Европы (Германия – Прибалтика, Германия – Польша и др.)
                        Компания является постоянным и надёжным партнёром многих крупных
                        белорусских предприятий в предоставлении транспортно-экспедиционных и логистических услуг.
                    </div>
                </div>
            </div>

            <div class="scm-title">Что мы можем предложить?</div>
            <div class="scm-row-container">
                <div class="scm-column-container scm-transport-column">
                    <div class="scm-row-container scm-center-title">
                        Автомобильные перевозки
                    </div>
                    <div class="scm-row-container">
                        <img src="<c:url value="/images/auto1.jpg"/>" class="scm-transport-img" alt="Cars">
                    </div>
                    <div class="scm-row-container">
                        Текст ыапывап ываопвыол ывалпооывап
                        ываопвылап ывапоывлап ывалповыап
                    </div>
                </div>

                <div class="scm-column-container scm-transport-column">
                    <div class="scm-row-container scm-center-title">
                        ЖД-перевозки
                    </div>
                    <div class="scm-row-container">
                        <img src="<c:url value="/images/others/train1.jpg"/>" class="scm-transport-img" alt="Cars">
                    </div>
                    <div class="scm-row-container">
                        Текст ыапывап ываопвыол ывалпооывап
                        ываопвылап ывапоывлап ывалповыап
                    </div>
                </div>

                <div class="scm-column-container scm-transport-column">
                    <div class="scm-row-container scm-center-title">
                        Авиа-перевозки
                    </div>
                    <div class="scm-row-container">
                        <img src="<c:url value="/images/air.jpg"/>" class="scm-transport-img" alt="Cars">
                    </div>
                    <div class="scm-row-container">
                        Текст ыапывап ываопвыол ывалпооывап
                        ываопвылап ывапоывлап ывалповыап
                    </div>
                </div>

                <div class="scm-column-container scm-transport-column">
                    <div class="scm-row-container scm-center-title">
                        Морские перевозки
                    </div>
                    <div class="scm-row-container">
                        <img src="<c:url value="/images/others/sea1.jpg"/>" class="scm-transport-img" alt="Cars">
                    </div>
                    <div class="scm-row-container">
                        Текст ыапывап ываопвыол ывалпооывап
                        ываопвылап ывапоывлап ывалповыап
                    </div>
                </div>
            </div>

            <div class="scm-title">Почему именно мы?</div>
            <div class="scm-row-container">
                <div class="scm-column-container">
                    <div class="scm-list">
                        <%--<div class="circle">1</div>--%>
                        <div class="scm-about-company">
                            <div class="scm-text-with-indent">
                                <b>Стремимся сделать мир лучше.</b>
                                Постоянно повышаем качество сервиса в области логистики. Мы ведем свой бизнес открыто и развиваем предпринимательство.
                                <br>
                            </div>
                            <div class="scm-text-with-indent">
                                <b>Строим большую компанию.</b>
                                Успех который постоен на профессионализме, саморазвитие и самореализации наших сотрудников.
                                <br>
                            </div>
                            <div class="scm-text-with-indent">
                                <b>Доставляем радость и качественный сервис.</b>
                                Удовлетворяем потребности клиента и решаем любые задачи, сохраняя при этом высочайшее качество продукта и клиентского сервиса.
                            </div>
                        </div>
                    </div>
                </div>

                <div class="scm-column-container">
                    <div class="scm-list">
                        <%--<div class="circle">2</div>--%>
                        <div class="scm-about-company">
                            <div class="scm-text-with-indent">
                                <b>Честность и открытость.</b>
                                Мы ничего не скрываем от клиентов и всегда готовы исправлять ошибки.
                                Выполняем на себя обязательства перед сотрудниками. Честны и открыты с партнерами компании.
                                <br>
                            </div>
                            <div class="scm-text-with-indent">
                                <b>Уважение и поддержка.</b>
                                Мы уважаем любой труд в нашей компании и поддерживаем коллег.
                                Стремимся создать хорошие условия для комфортной работы, профессионального и личного развития сотрудников.
                                <br>
                            </div>
                            <div class="scm-text-with-indent">
                                <b>Нет ничего невозможного.</b>
                                Только мы сами определяем границы наших возможностей.
                                Мы ставим перед собой большие и амбициозные цели, добиваясь результатов с помощью упорного труда и настойчивости.
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </jsp:body>
</scm:page_wrapper>