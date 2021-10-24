<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>User Register</title>

    <style>
        .error {
            color:red;
        }
    </style>

</head>
<body>

<div class="container">
    <h1>User Register</h1>

    <form:form method="post" action="${contextPath}/register" modelAttribute="userDTO">



        <div class="mb-3">
            <form:label path="firstname">firstname</form:label>
            <form:input type="text" path="firstname" cssClass="form-control"/>
            <form:errors path="firstname" cssClass="error"/>
        </div>
        <div class="mb-3">
            <form:label path="lastname">lastname</form:label>
            <form:input type="text" path="lastname" cssClass="form-control"/>
            <form:errors path="lastname" cssClass="error"/>
        </div>
        <div class="mb-3">
            <form:label path="username">username</form:label>
            <form:input type="text" path="username" cssClass="form-control"/>
            <form:errors path="username" cssClass="error"/>
        </div>
        <div class="mb-3">
            <form:label path="password">password</form:label>
            <form:input type="password" path="password" cssClass="form-control"/>
            <form:errors path="password" cssClass="error"/>
            <spring:hasBindErrors name="userDTO">
                <span class="error">
                    <c:forEach items="${errors.globalErrors}" var="globalError">
                        <c:if test="${fn:contains(globalError, 'password')}">
                            <c:out value="${globalError.defaultMessage}"/>
                        </c:if>
                    </c:forEach>
                </span>
            </spring:hasBindErrors>
        </div>
        <div class="mb-3">
            <form:label path="reTypePassword">reTypePassword</form:label>
            <form:input type="password" path="reTypePassword" cssClass="form-control"/>
            <form:errors path="password" cssClass="error"/>
        </div>



        <div class="mb-3">
            <input type="submit" value="save" class="btn btn-primary">
            <input type="button" value="cancel" class="btn" onclick="window.location='${contextPath}/product/browse'">
        </div>
    </form:form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
