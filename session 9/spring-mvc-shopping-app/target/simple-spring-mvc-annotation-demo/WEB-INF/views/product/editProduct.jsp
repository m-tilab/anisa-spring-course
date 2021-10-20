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

    <title>Edit Product</title>

    <style>
        .error {
            color:red;
        }
    </style>

</head>
<body>

<div class="container">
    <h1>Edit Product</h1>

    <c:set var="actionPath" value="add" />

    <c:if test="${organization != ''}">
        <c:set var="actionPath" value="update" />
    </c:if>
    <!-- default modelAttribute is command -->
    <form:form method="post" action="${contextPath}/product/${actionPath}" modelAttribute="product">

        <form:hidden path="productId" />

        <div class="mb-3">
            <form:label path="name">name</form:label>
            <form:input type="text" path="name" cssClass="form-control"/>
            <form:errors path="name" cssClass="error"/>
        </div>
        <div class="mb-3">
            <form:label path="description">description</form:label>
            <form:input type="text" path="description" cssClass="form-control" />
            <form:errors path="description" cssClass="error"/>
        </div>
        <div class="mb-3">
            <form:label path="quantity">quantity</form:label>
            <form:input type="text" path="quantity" cssClass="form-control" />
            <form:errors path="quantity" cssClass="error"/>
        </div>
        <div class="mb-3">
            <form:label path="price">Price</form:label>
            <form:input type="text" path="price" cssClass="form-control" />
            <form:errors path="price" cssClass="error"/>
        </div>
        <div class="mb-3">
            <form:label path="productCategoryId">Product Category</form:label>
            <form:select items="${productCategoryService.getAllProductCategories()}"
                         itemValue="productCategoryId" itemLabel="name" path="productCategoryId" cssClass="form-control" />
        </div>
        <div class="mb-3">
            <form:label path="creatorUserId">creatorUserId</form:label>
            <form:input type="text" path="creatorUserId" cssClass="form-control"/>
        </div>

        <div class="mb-3">
            <input type="submit" value="save" class="btn btn-primary">
            <input type="button" value="cancel" class="btn" onclick="window.location='${contextPath}/product/browse'">
        </div>
    </form:form>

    <form:form method="post" action="${contextPath}/addToCard" modelAttribute="invoiceDetail">

        <form:hidden path="productId" />

        <div class="mb-3">

            <form:label path="quantity">Quantity</form:label>
            <form:input path="quantity" cssClass="form-control"/>
        </div>

        <div class="mb-3">
            <input type="submit" value="save" class="btn btn-primary">
        </div>
    </form:form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
