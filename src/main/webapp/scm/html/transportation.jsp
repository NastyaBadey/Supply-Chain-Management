<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="scm" tagdir="/WEB-INF/tags" %>

<scm:page_wrapper>
    <jsp:attribute name="scm_head">
        <meta charset="utf-8">
        <title>Перевозки</title>
        <link href="<c:url value="/scm/images/car-icon.png"/>" rel="shortcut icon" type="image/png">
        <link href="<c:url value="/scm/css/main.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/ticket.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css">
    </jsp:attribute>

    <jsp:body>
        <c:url var="addTicket" value="/addTicket"/>
        <div class="scm-profile-main-auto-background scm-row-container">
            <div class="scm-column-container scm-profile-main-block">
                <div class="scm-row-container scm-flex-center scm-profile-title-name">Перевозки</div>
                <form class="scm-profile-form">
                    <div class="scm-column-container">
                        <div class="scm-ticket-center-title">Перевозки</div>
                        <table class="tg">
                            <tr>
                                <th width="40">Владелец</th>
                                <th width="120">Груз</th>
                                <th width="120">Количество, шт</th>
                                <th width="90">Тип отправки</th>
                                <th width="40">Тип доставки</th>
                                <th width="80">Статус</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><a href="">Принять заявку</a></td>
                            </tr>

                        </table>

                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</scm:page_wrapper>