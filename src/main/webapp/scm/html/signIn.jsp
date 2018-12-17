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
        <link href="<c:url value="/scm/css/signUp.css"/>" rel="stylesheet" type="text/css" >
        <link href="<c:url value="/scm/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css" >
    </jsp:attribute>

    <jsp:body>
        <c:url var="login" value="/login" />
        <div class="scm-auto-background scm-row-container">
            <div class="scm-auto-text scm-column-container">С нами удобнее</div>
            <div class="scm-flex-center scm-column-container scm-main-row">
                <form:form action="${login}" commandName="user" class="scm-form">
                    <div class="scm-center-title scm-form-title">Вход</div>

                    <div class="scm-form-row">
                        <form:input path="userLogin" size="28" class="scm-input-text scm-row-container"
                                    required="required" maxlength="25" autocomplete="off" />
                        <form:label path="userLogin" class="scm-form-label scm-row-container">Логин</form:label>
                    </div>

                    <div class="scm-form-row">
                        <form:password path="userPassword" size="28" class="scm-input-text scm-row-container"
                                       required="required" maxlength="25" autocomplete="off" />
                        <form:label path="userPassword" class="scm-form-label scm-row-container">Пароль</form:label>
                    </div>

                    <input type="submit" value="Войти" >
                </form:form>
            </div>
        </div>
    </jsp:body>
</scm:page_wrapper>