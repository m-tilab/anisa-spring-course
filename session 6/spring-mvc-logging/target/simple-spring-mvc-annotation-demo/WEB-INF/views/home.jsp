<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1><c:out value="${greeting}"/></h1>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<a href="${contextPath}/organizations">list of Organizations</a>


</body>
</html>
