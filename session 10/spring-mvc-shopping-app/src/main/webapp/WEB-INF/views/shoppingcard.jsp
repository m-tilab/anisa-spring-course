<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>View ShoppingCard</title>
</head>
<body>
<div class="container">
    <h1>View ShoppingCard</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ProductId</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="invoiceDetail" items="${invoice.invoiceDetails}" varStatus="loop">
            <tr>
                <td>
                    <c:out value="${products[loop.index].name}"/>
                </td>
                <td>
                    <c:out value="${invoiceDetail.quantity}"/>
                </td>
                <td>
                    <c:out value="${invoiceDetail.price}"/>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <a href="${contextPath}/clearcard">Clear Card</a>

    <a href="${contextPath}/">Go To Home</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
