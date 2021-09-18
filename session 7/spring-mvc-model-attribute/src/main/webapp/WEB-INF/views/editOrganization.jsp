<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <form method="post" action="${contextPath}/organization/${actionPath}">

        <input type="hidden" name="organizationId" value="<c:out value="${organization.organizationId}"/>">

        <div class="mb-3">
            <label>Company Name</label>
            <input type="text" name="companyName" class="form-control" value="<c:out value="${organization.companyName}"/>">
        </div>
        <div class="mb-3">
            <label>yearOfIncorporation</label>
            <input type="text" name="yearOfIncorporation" class="form-control"  value="<c:out value="${organization.yearOfIncorporation}"/>">
        </div>
        <div class="mb-3">
            <label>postalCode</label>
            <input type="text" name="postalCode" class="form-control"  value="<c:out value="${organization.postalCode}"/>">
        </div>
        <div class="mb-3">
            <label>employeeCount</label>
            <input type="text" name="employeeCount" class="form-control" value="<c:out value="${organization.employeeCount}"/>">
        </div>
        <div class="mb-3">
            <label>slogan</label>
            <input type="text" name="slogan" class="form-control"  value="<c:out value="${organization.slogan}"/>">
        </div>

        <div class="mb-3">
            <input type="submit" value="save" class="btn btn-primary">
            <input type="button" value="cancel" class="btn">
        </div>
    </form>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
