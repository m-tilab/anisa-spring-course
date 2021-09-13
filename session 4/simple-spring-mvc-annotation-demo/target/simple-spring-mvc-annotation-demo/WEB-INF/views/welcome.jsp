<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="utf-8"
    isELIgnored="false"
%>

<!DOCTYPE html>
<html>

<body>
    <c:forEach var="messageItem" items="${myWelcomeMessage}">
        <c:out value="${messageItem}"/>
    </c:forEach>
</body>
</html>

