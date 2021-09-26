<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Shopping Home</title>
</head>
<body>

<ul>
    <li><a href="${contextPath}/product/browse">Product Management</a></li>
    <li><a href="${contextPath}/card">View Card</a></li>
</ul>

</body>
</html>
