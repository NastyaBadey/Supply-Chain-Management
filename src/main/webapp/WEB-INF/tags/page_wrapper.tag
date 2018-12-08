<%@ tag description="Page template" pageEncoding="UTF-8" %>
<%@ attribute name="scm_head" fragment="true" %>
<%@ attribute name="scm_header" fragment="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:invoke fragment="scm_head" />
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
                <jsp:invoke fragment="scm_header" />
            </li>
        </ul>
    </nav>
</header>

<div class="scm-main">
    <article class="scm-container">
        <div class="scm-column-container">
            <jsp:doBody/>
        </div>
    </article>
</div>

<div class="scm-footer-container">
    <footer class="scm-footer">
        <div class="scm-horizontal-line"></div>
        <div>© 2018 TransportLogistics. Minsk, Belarus</div>
    </footer>
    <div class="scm-after-footer"></div>
</div>
</body>
</html>