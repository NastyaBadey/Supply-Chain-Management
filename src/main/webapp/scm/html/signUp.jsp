<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="scm" tagdir="/WEB-INF/tags" %>

<scm:page_wrapper>
    <jsp:attribute name="scm_head">
        <meta charset="utf-8">
        <title>Регистрация</title>
        <link href="<c:url value="/scm/images/car-icon.png"/>" rel="shortcut icon" type="image/png">
        <link href="<c:url value="/scm/css/main.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/signUp.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css">
    </jsp:attribute>

    <jsp:body>
        <c:url var="register" value="/register"/>
        <div class="scm-auto-background scm-row-container">
            <div class="scm-auto-text scm-column-container">С нами удобнее</div>
            <div class="scm-flex-center scm-column-container scm-main-row">
                <form:form action="${register}" commandName="user" class="scm-form">
                    <div class="scm-center-title scm-form-title">Регистрация</div>

                    <div class="scm-form-row">
                        <div class="scm-row-container">
                            <form:radiobutton path="userRole" id="owner" class="scm-input-radio" value="2"
                                              checked="checked" label="Владелец груза"/>
                        </div>
                        <div class="scm-row-container">
                            <form:radiobutton path="userRole" id="carrier" class="scm-input-radio" value="1"
                                              label="Перевозчик"/>
                                <%-- то же самое, что и label="Перевозчик":
                                <label for="carrier">Перевозчик</label>--%>
                        </div>
                    </div>

                    <div class="scm-form-row">
                        <form:input path="userLogin" size="28" class="scm-input-text scm-row-container"
                                    required="required" maxlength="25" autocomplete="off"/>
                        <form:label path="userLogin" class="scm-form-label scm-row-container">Логин</form:label>
                    </div>

                    <div class="scm-form-row">
                        <form:password path="userPassword" size="28" class="scm-input-text scm-row-container"
                                       required="required" maxlength="25" autocomplete="off"/>
                        <form:label path="userPassword" class="scm-form-label scm-row-container">Пароль</form:label>
                    </div>

                    <div class="scm-form-row">
                        <form:input path="userEmail" type="email" size="28" class="scm-input-text scm-row-container"
                                    required="required" maxlength="25" autocomplete="off"/>
                        <form:label path="userEmail" class="scm-form-label scm-row-container">Email</form:label>
                    </div>

                    <input type="submit" value="Зарегистрироваться">
                </form:form>
            </div>
        </div>
    </jsp:body>
</scm:page_wrapper>