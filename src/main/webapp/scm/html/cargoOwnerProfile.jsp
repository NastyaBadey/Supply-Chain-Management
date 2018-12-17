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
        <link href="<c:url value="/scm/css/main.css"/>" rel="stylesheet" type="text/css" >
        <link href="<c:url value="/scm/css/profile.css"/>" rel="stylesheet" type="text/css" >
        <link href="<c:url value="/scm/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css" >
    </jsp:attribute>

    <jsp:body>
        <c:url var="addCargoOwner" value="/addCargoOwner" />
        <div class="scm-profile-main-auto-background scm-row-container">
            <div class="scm-column-container scm-profile-main-block">
                <div class="scm-row-container scm-flex-center scm-profile-title-name">Создание профиля</div>
                <div class="scm-flex-center scm-row-container">
                    <form:form action="${addCargoOwner}" commandName="cargoOwner" class="scm-profile-form">
                        <div class="scm-profile-center-title">Общая информация</div>

                        <div class="scm-profile-form-row">
                            <form:label path="cargoOwnerName" class="scm-profile-label scm-30">Название: </form:label>
                            <form:input path="cargoOwnerName" size="28" class="scm-profile-input scm-70"
                                        required="required" maxlength="60" autocomplete="off" />
                        </div>

                        <div class="scm-profile-form-row">
                            <form:label path="cargoOwnerPhone" class="scm-profile-label scm-30">Телефон: </form:label>
                            <form:input path="cargoOwnerPhone" size="28" class="scm-profile-input scm-70"
                                        required="required" maxlength="20" autocomplete="off" />
                        </div>

                        <div class="scm-profile-form-row">
                            <form:label path="cargoOwnerDesc" class="scm-profile-label scm-30">Описание: </form:label>
                            <form:textarea path="cargoOwnerDesc" class="scm-profile-textarea scm-70"
                                        required="required" maxlength="255" autocomplete="off" />
                        </div>

                        <div class="scm-profile-btn">
                            <input type="submit" value="Сохранить" >
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </jsp:body>
</scm:page_wrapper>