<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sec:authorize access="hasRole('ROLE_USER')">
<%@include file="cartPage.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@include file="adminPage.jsp" %>
</sec:authorize>