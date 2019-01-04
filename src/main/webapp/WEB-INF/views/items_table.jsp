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
            <li><a href="${contextPath}/productTable">Product Table</a></li>
            <li class="active">Items Table</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h1>Items Table</h1>
                <div class="goods-page">
                    <c:if test="${not empty errorDeleteMsg}">
                        ${errorDeleteMsg}
                    </c:if>
                    <div class="goods-data clearfix">
                        <a href="${contextPath}/editItem/${product.id}/0" class="btn btn-default">Add Item</a>
                    </div>
                    <div class="goods-data clearfix">
                        <div class="table-wrapper-responsive">
                            <table summary="One Product Table">
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
                                <tr>
                                    <td>${product.id}</td>
                                    <td><a href="${contextPath}/product/${product.id}/0">${product.name}</a></td>
                                    <td>${product.brand.name}</td>
                                    <td>${product.imageSource}</td>
                                    <td>${product.description}</td>
                                    <td>${product.itemList.size()}</td>
                                    <td><a href="${contextPath}/deleteProduct/${product.id}">Delete</a></td>
                                    <td><a href="${contextPath}/editProduct/${product.id}">Edit</a></td>
                                </tr>
                            </table>
                        </div>
                        <br>
                        <div class="table-wrapper-responsive">
                            <table summary="Items Table">
                                <tr>
                                    <th class="goods-page-quantity">Item Id</th>
                                    <th class="goods-page-description">Price, $</th>
                                    <th class="goods-page-description">Type</th>
                                    <th class="goods-page-description">Size</th>
                                    <th class="goods-page-description">Quantity</th>
                                    <th class="goods-page-description">Ordered Quantity</th>
                                    <th class="goods-page-description">Image Source</th>
                                    <th class="goods-page-description">Discount, %</th>
                                    <th class="goods-page-description">Available</th>
                                    <th class="goods-page-description">Delete</th>
                                    <th class="goods-page-description">Edit</th>
                                </tr>
                                <c:forEach var="item" items="${product.itemList}">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.price}</td>
                                    <td>${item.itemType}</td>
                                    <td>${item.itemSize}</td>
                                    <td>${item.quantity}</td>
                                    <td>${item.quantOrdered}</td>
                                    <td>${item.imageSource}</td>
                                    <td>${item.discount}</td>
                                    <td>${item.available ? "Yes" : "No"}</td>
                                    <td><a href="${contextPath}/deleteItem/${product.id}/${item.id}">Delete</a></td>
                                    <td><a href="${contextPath}/editItem/${product.id}/${item.id}">Edit</a></td>
                                </tr>
                                </c:forEach>
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