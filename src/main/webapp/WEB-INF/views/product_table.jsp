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
            <li class="active">Products</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h1>Products Table</h1>
                <div class="goods-page">
                    <c:if test="${not empty errorDeleteMsg}">
                        ${errorDeleteMsg}
                    </c:if>
                    <div class="goods-data clearfix">
                        <a href="${contextPath}/editProduct/0" class="btn btn-default">Add Product</a>
                    </div>
                    <c:if test="${not empty productList}">
                        <div class="goods-data clearfix">
                            <div class="table-wrapper-responsive">
                                <table summary="Product Table">
                                    <tr>
                                        <th class="goods-page-description">Product Id</th>
                                        <th class="goods-page-description">Name</th>
                                        <th class="goods-page-description">Brand</th>
                                        <th class="goods-page-description">Image Source</th>
                                        <th class="goods-page-description">Description</th>
                                        <th class="goods-page-description">Items</th>
                                        <th class="goods-page-description">Delete</th>
                                        <th class="goods-page-description">Edit</th>
                                    </tr>
                                    <c:forEach var="product" items="${productList}">
                                        <tr>
                                            <td>${product.id}</td>
                                            <td><a href="${contextPath}/product/${product.id}/0">${product.name}</a></td>
                                            <td>${product.brand.name}</td>
                                            <td>${product.imageSource}</td>
                                            <td>${product.description}</td>
                                            <td>
                                                <a href="${contextPath}/itemsTable/${product.id}">${product.itemList.size()}</a>
                                            </td>
                                            <td><a href="${contextPath}/processDeleteProduct/${product.id}">Delete</a>
                                            </td>
                                            <td><a href="${contextPath}/editProduct/${product.id}">Edit</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${empty productList}">
                        <div class="goods-data clearfix">
                            <h2>There is no products in the DB</h2>
                        </div>
                    </c:if>
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