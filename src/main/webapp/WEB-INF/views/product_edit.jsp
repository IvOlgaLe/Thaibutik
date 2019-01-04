<%@include file="links_top.jsp" %>
<title>Product Table | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li><a href="${contextPath}/adminDashboard">Admin Page</a></li>
            <li><a href="${contextPath}/productTable">Products</a></li>
            <li class="active">Edit / Add Product</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h1>Edit / Add Product</h1>
                <div class="goods-page">
                    <div class="goods-data clearfix">
                        <div class="table-wrapper-responsive">
                            <table summary="Shopping cart">
                                <tr>
                                    <c:if test="${not empty product.id}">
                                        <th class="goods-page-description">Product Id</th>
                                    </c:if>
                                    <th class="goods-page-description">Name</th>
                                    <th class="goods-page-description">Brand</th>
                                    <th class="goods-page-description">Category</th>
                                    <th class="goods-page-description">Image Source</th>
                                    <th class="goods-page-description">Description</th>
                                    <th class="goods-page-description">Items</th>
                                    <c:if test="${not empty product.id}">
                                        <th class="goods-page-description">Delete</th>
                                    </c:if>
                                    <th class="goods-page-description">Save</th>
                                </tr>
                                <form id="editProductForm" method="GET"
                                      action="${contextPath}/processEditProduct" modelAttribute="editedProduct">
                                    <tr>
                                        <c:if test="${not empty product.id}">
                                            <td><input name="id" type="text" readonly value="${product.id}"></td>
                                        </c:if>
                                        <td><input name="name" type="text" value="${product.name}" required></td>
                                        <td>
                                            <select name="brandId" required>
                                                <c:if test="${not empty product.id}">
                                                    <option value="${product.brand.id}">${product.brand.name}</option>
                                                </c:if>
                                                <c:forEach var="brand" items="${brandList}">
                                                    <option value="${brand.id}">${brand.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name="categoryId" required>
                                                <c:forEach var="category" items="${categoryList}">
                                                    <option value="${category.id}">${category.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><input name="imageSource" type="text" value="${product.imageSource}" required>
                                        </td>
                                        <td><input name="description" type="text" value="${product.description}" required>
                                        </td>
                                        <td>
                                            <a href="${contextPath}/itemsTable/${product.id}">${product.itemList.size()}</a>
                                        </td>
                                        <c:if test="${not empty product.id}">
                                            <td><a href="${contextPath}/processDeleteProduct/${product.id}">Delete</a>
                                            </td>
                                        </c:if>
                                        <td>
                                            <button class="btn btn-primary" type="submit">Save</button>
                                        </td>
                                    </tr>
                                </form>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END CONTENT -->
    </div>
</div>

<%@include file="links_bottom.jsp" %>
</body>
<!-- END BODY -->
</html>