<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="scm" tagdir="/WEB-INF/tags" %>

<scm:page_wrapper>
    <jsp:attribute name="scm_head">
        <meta charset="utf-8">
        <title>Вход</title>
        <link href="<c:url value="/scm/images/car-icon.png"/>" rel="shortcut icon" type="image/png">
        <link href="<c:url value="/scm/css/main.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/profile.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css">
    </jsp:attribute>

    <jsp:body>
        <c:url var="addTicket" value="/addTicket"/>
        <div class="scm-profile-main-auto-background scm-row-container">
            <div class="scm-column-container scm-profile-main-block">
                <div class="scm-row-container scm-flex-center scm-profile-title-name">Оформление заявки на перевозку
                </div>
                <div class="scm-title">Информация о грузе</div>

                <div class="scm-row-container">
                    <div class="scm-column-container">
                        <form:form action="${addTicket}" commandName="ticketAndCargo" class="scm-profile-form">
                            <div class="scm-row-container">
                                <div class="scm-column-container scm-transport-column">
                                    <form:label path="cargo.cargoName"
                                                class="scm-profile-label scm-30">Название: </form:label>
                                    <form:input path="cargo.cargoName" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"/>
                                </div>

                                <div class="scm-column-container scm-transport-column">
                                    <form:label path="cargo.cargoLength"
                                                class="scm-profile-label scm-30">Длина: </form:label>
                                    <form:input path="cargo.cargoLength" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"/>
                                </div>

                                <div class="scm-column-container scm-transport-column">
                                    <form:label path="cargo.cargoHeight"
                                                class="scm-profile-label scm-30">Высота: </form:label>
                                    <form:input path="cargo.cargoHeight" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"/>
                                </div>
                            </div>

                            <div class="scm-row-container">

                                <div class="scm-column-container scm-transport-column">
                                    <form:label path="cargo.cargoWeight"
                                                class="scm-profile-label scm-30">Название: </form:label>
                                    <form:input path="cargo.cargoWeight" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"/>
                                </div>

                                <div class="scm-column-container scm-transport-column">
                                    <form:label path="cargo.cargoWidth"
                                                class="scm-profile-label scm-30">Длина: </form:label>
                                    <form:input path="cargo.cargoWidth" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"/>
                                </div>

                                <div class="scm-column-container scm-transport-column">
                                    <form:label path="ticket.cargoQuantity"
                                                class="scm-profile-label scm-30">Количество груза: </form:label>
                                    <form:input path="ticket.cargoQuantity" size="18" class="scm-profile-input scm-70"
                                                required="required" maxlength="60" autocomplete="off"/>
                                </div>


                            </div>

                        </form:form>
                    </div>
                </div>

            </div>
        </div>

        </div>
    </jsp:body>
</scm:page_wrapper>