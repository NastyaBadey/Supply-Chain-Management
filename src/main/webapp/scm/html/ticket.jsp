<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="scm" tagdir="/WEB-INF/tags" %>

<scm:page_wrapper>
    <jsp:attribute name="scm_head">
        <meta charset="utf-8">
        <title>Заявка</title>
        <link href="<c:url value="/scm/images/car-icon.png"/>" rel="shortcut icon" type="image/png">
        <link href="<c:url value="/scm/css/main.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/ticket.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css">
    </jsp:attribute>

    <jsp:body>
        <c:url var="addTicket" value="/addTicket"/>
        <div class="scm-profile-main-auto-background scm-row-container">
            <div class="scm-column-container scm-profile-main-block">
                <div class="scm-row-container scm-flex-center scm-profile-title-name">Оформление заявки на перевозку
                </div>

                <div class="scm-row-container">
                    <div class="scm-column-container">
                        <form:form action="${addTicket}" commandName="ticketAndCargoAndMethod" class="scm-profile-form">
                            <div class="scm-ticket-center-title ">Информация о грузе</div>
                            <div class="scm-row-container scm-ticket-row">
                                <div class="scm-column-container scm-ticket-column">
                                    <form:input path="cargo.cargoName" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"
                                                placeholder="Название"/>
                                </div>

                                <div class="scm-column-container scm-ticket-column">
                                    <form:input path="cargo.cargoLength" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"
                                                placeholder="Длина"/>
                                </div>

                                <div class="scm-column-container scm-ticket-column">
                                    <form:input path="cargo.cargoHeight" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"
                                                placeholder="Высота"/>
                                </div>

                            </div>

                            <div class="scm-row-container scm-ticket-row">
                                <div class="scm-column-container scm-ticket-column">
                                    <form:input path="cargo.cargoWeight" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"
                                                placeholder="Вес"/>
                                </div>

                                <div class="scm-column-container scm-ticket-column">
                                    <form:input path="cargo.cargoWidth" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"
                                                placeholder="Ширина"/>
                                </div>

                                <div class="scm-column-container scm-ticket-column">
                                    <form:input path="ticket.cargoQuantity" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"
                                                placeholder="Количество груза"/>
                                </div>
                            </div>

                            <%--<div class="scm-ticket-center-title ">Желаемый способ доставки</div>
                            <div class="scm-row-container">
                                <div class="scm-column-container ">
                                    <input type="radio" value="Авто">
                                    Авто
                                </div>
                                <div class="scm-column-container ">
                                    <input type="radio" value="ЖД">
                                    Жд
                                </div>
                                <div class="scm-column-container ">
                                    <input type="radio" value="Морской транспорт">
                                    Морской транспорт
                                </div>
                                <div class="scm-column-container ">
                                    <input type="radio" value="Авиатранспорт">
                                    Авиатранспорт
                                </div>

                            </div>--%>

                            <div class="scm-ticket-center-title scm-route-title">Маршрут</div>
                            <div class="scm-row-container scm-ticket-row">
                                <div class="scm-column-container  scm-ticket-column">
                                    <div class="scm-row-container scm-ticket-row">Место отправки:</div>
                                    <div class="scm-row-container scm-ticket-row">
                                        <form:input path="departureLocality.country" size="18"
                                                    class="scm-profile-input scm-70"
                                                    required="required" maxlength="60" autocomplete="off"
                                                    placeholder="Страна"/>
                                    </div>
                                    <div class="scm-row-container scm-ticket-row">
                                        <form:input path="departureLocality.localityName" size="18"
                                                    class="scm-profile-input scm-70"
                                                    required="required" maxlength="60" autocomplete="off"
                                                    placeholder="Город"/>
                                    </div>
                                </div>
                                <div class="scm-column-container ">
                                    <div class="scm-row-container scm-ticket-row">Место назначения:</div>
                                    <div class="scm-row-container scm-ticket-row">
                                        <form:input path="destinationLocality.country" size="18"
                                                    class="scm-profile-input scm-70"
                                                    required="required" maxlength="60" autocomplete="off"
                                                    placeholder="Страна"/>
                                    </div>
                                    <div class="scm-row-container scm-ticket-row">
                                        <form:input path="destinationLocality.localityName" size="18"
                                                    class="scm-profile-input scm-70"
                                                    required="required" maxlength="60" autocomplete="off"
                                                    placeholder="Город"/>
                                    </div>
                                </div>
                            </div>

                            <div class="scm-row-container scm-ticket-row">
                                <div class="scm-ticket-btn">
                                    <input type="submit" value="Просмотреть предложения">
                                </div>
                                <div class="scm-ticket-btn">
                                    <input type="submit" value="Сохранить">
                                </div>
                            </div>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</scm:page_wrapper>