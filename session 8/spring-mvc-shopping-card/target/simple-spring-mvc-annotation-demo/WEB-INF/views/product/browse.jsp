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

    <title>Browse All Products</title>

</head>
<body>
<div class="container">

    <h1>Browse All Products</h1>

    <a href="${contextPath}/product/editProduct">Add Product</a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>name</th>
            <th>description</th>
            <th>quantity</th>
            <th>price</th>
            <th>productCategoryId</th>
            <th>creatorUserId</th>
            <th>createDate</th>
            <th>actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>
                    <c:out value="${product.name}"/>
                </td>
                <td>
                    <c:out value="${product.description}"/>
                </td>
                <td>
                    <c:out value="${product.quantity}"/>
                </td>
                <td>
                    <c:out value="${product.price}"/>
                </td>
                <td>
                    <c:out value="${product.productCategoryId}"/>
                </td>
                <td>
                    <c:out value="${product.creatorUserId}"/>
                </td>
                <td>
                    <c:out value="${product.createDate}"/>
                </td>
                <td>
                    <a href="${contextPath}/product/editProduct?productId=${product.productId}">Edit</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <a href="${contextPath}/">Back to Home</a>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>