<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="utf-8"
         isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>All organizations</title>

</head>
<body>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>companyName</th>
            <th>yearOfIncorporation</th>
            <th>postalCode</th>
            <th>employeeCount</th>
            <th>slogan</th>
            <th>actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="organization" items="${organizations}">
            <tr>
                <td>
                    <c:out value="${organization.companyName}"/>
                </td>
                <td>
                    <c:out value="${organization.yearOfIncorporation}"/>
                </td>
                <td>
                    <c:out value="${organization.postalCode}"/>
                </td>
                <td>
                    <c:out value="${organization.employeeCount}"/>
                </td>
                <td>
                    <c:out value="${organization.slogan}"/>
                </td>
                <td>
                    <a href="${contextPath}/organization/edit?organizationId=${organization.organizationId}">Edit</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>


    <p>${data1}</p>
    <p>${data2}</p>
</div>


<a href="${contextPath}/">Back to Home</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

