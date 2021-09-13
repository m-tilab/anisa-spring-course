<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="utf-8"
    isELIgnored="false"
%>

<!DOCTYPE html>
<html>

<body>
    <c:forEach var="organization" items="${organizations}">
        <c:out value="${organization.companyName}"/> : {slogan: <c:out value="${organization.slogan}"/>}
        <br>
    </c:forEach>
</body>
</html>

