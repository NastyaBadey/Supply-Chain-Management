<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="scm" tagdir="/WEB-INF/tags" %>

<scm:page_wrapper>
    <jsp:attribute name="scm_head">
        <meta charset="utf-8">
        <title>Профиль</title>
        <link href="<c:url value="/scm/images/car-icon.png"/>" rel="shortcut icon" type="image/png">
        <link href="<c:url value="/scm/css/main.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/rates.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/scm/css/fontAwesome/css/all.css"/>" rel="stylesheet" type="text/css">
        <script src="<c:url value="/scm/js/rates.js"/>"></script>
        <script src="<c:url value="/scm/js/jquery/jquery-3.3.1.min.js"/>"></script>
    </jsp:attribute>

    <jsp:body>
        <c:url var="addRate" value="/addRate"/>
        <div class="scm-main-auto-background scm-row-container">
            <div class="scm-column-container scm-rates-main-block">
                <div class="scm-row-container scm-flex-center scm-rates-title-name">Тарифы</div>
                <div class="scm-flex-center scm-row-container">
                    <c:choose>
                        <c:when test="${!empty ratesAndDeliveryMethods.deliveryMethods}">
                            <form:form action="${addRate}" commandName="ratesAndDeliveryMethods"
                                       class="scm-rates-form">
                                <div class="scm-rates-form-row">
                                    <form:label path="selectedDeliveryMethodId"
                                                class="scm-rates-label scm-60">Тип доставки: </form:label>
                                    <c:choose>
                                        <c:when test="${ratesAndDeliveryMethods.selectedDeliveryMethodId eq null}">
                                            <form:select path="selectedDeliveryMethodId"
                                                         class="scm-rates-input scm-rates-select" required="required">
                                                <c:forEach var="dm" items="${ratesAndDeliveryMethods.deliveryMethods}">
                                                    <form:option value="${dm.deliveryMethodId}">${dm.deliveryMethodName}</form:option>
                                                </c:forEach>
                                            </form:select>
                                        </c:when>
                                        <c:otherwise>
                                            <form:hidden path="rate.rateId"/>
                                            <form:select path="selectedDeliveryMethodId"
                                                         class="scm-rates-input scm-rates-select" required="required" readonly="true">
                                                <c:forEach var="dm" items="${ratesAndDeliveryMethods.deliveryMethods}">
                                                    <c:if test="${dm.deliveryMethodId eq ratesAndDeliveryMethods.selectedDeliveryMethodId}">
                                                        <form:option value="${dm.deliveryMethodId}" selected="selected">${dm.deliveryMethodName}</form:option>
                                                    </c:if>
                                                </c:forEach>
                                            </form:select>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <div class="scm-rates-form-row">
                                    <form:label path="rate.ratePricePerKg"
                                                class="scm-rates-label scm-60">Тариф за 1 кг за 1 км, BYN: </form:label>
                                    <form:input path="rate.ratePricePerKg" size="10" class="scm-rates-input scm-20"
                                                required="required" maxlength="5" autocomplete="off"/>
                                </div>

                                <div class="scm-rates-form-row">
                                    <form:label path="rate.averageSpeed"
                                                class="scm-rates-label scm-60">Средняя скорость, км/ч: </form:label>
                                    <form:input path="rate.averageSpeed" size="10" class="scm-rates-input scm-20"
                                                required="required" maxlength="5" autocomplete="off"/>
                                </div>
                                <div class="scm-rates-btn">
                                    <c:choose>
                                        <c:when test="${ratesAndDeliveryMethods.selectedDeliveryMethodId eq null}">
                                            <input type="submit" value="Добавить тариф">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="submit" value="Сохранить">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </form:form>
                        </c:when>

                        <c:otherwise>
                            <div class="scm-rates-empty-form">Тарифы для всех способов доставки добавлены</div>
                        </c:otherwise>
                    </c:choose>

                </div>

                <div id="rate_table" class="scm-flex-center scm-row-container"></div>
            </div>
        </div>
    </jsp:body>
</scm:page_wrapper>