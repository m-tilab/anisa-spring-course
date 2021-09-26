<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


    <title>Title</title>

</head>
<body>

<div class="container">
    <h1>Edit Organization</h1>

    <c:set var="actionPath" value="add" />

    <c:if test="${organization != ''}">
        <c:set var="actionPath" value="update" />
    </c:if>

    <!-- default modelAttribute is command -->
    <form:form method="post" action="${contextPath}/organization/${actionPath}" modelAttribute="organization">

        <form:hidden path="organizationId" />

        <div class="mb-3">
            <form:label path="companyName">Company Name</form:label>
            <form:input path="companyName" cssClass="form-control" />
        </div>
        <div class="mb-3">
            <form:label path="yearOfIncorporation">yearOfIncorporation</form:label>
            <form:input path="yearOfIncorporation" cssClass="form-control" />
        </div>
        <div class="mb-3">
            <form:label path="postalCode">postalCode</form:label>
            <form:input path="postalCode" cssClass="form-control"/>
        </div>
        <div class="mb-3">
            <form:label path="employeeCount">employeeCount</form:label>
            <form:input path="employeeCount" cssClass="form-control" />
        </div>
        <div class="mb-3">
            <form:label path="slogan">slogan</form:label>
            <form:input path="slogan" cssClass="form-control" />
        </div>

        <div class="mb-3">
            <input type="submit" value="save" class="btn btn-primary">
            <input type="button" value="cancel" class="btn">
        </div>
    </form:form>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
