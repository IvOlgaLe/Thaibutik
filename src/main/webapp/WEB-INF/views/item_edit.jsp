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
            <li><a href="${contextPath}/itemsTable/${item.productId}">Items Table</a></li>
            <li class="active">Edit / Add Items Page</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h1>Edit Items Page</h1>
                <div class="goods-page">
                    <div class="goods-data clearfix">
                        <div class="table-wrapper-responsive">
                            <table summary="Items Table">
                                <tr>
                                    <c:if test="${not empty item.id}">
                                        <th class="goods-page-description">Item Id</th>
                                    </c:if>
                                    <th class="goods-page-description">Product Id</th>
                                    <th class="goods-page-description">Price, $</th>
                                    <th class="goods-page-description">Type</th>
                                    <th class="goods-page-description">Size</th>
                                    <th class="goods-page-description">Currency</th>
                                    <th class="goods-page-description">Quantity</th>
                                    <th class="goods-page-description">Ordered Quantity</th>
                                    <th class="goods-page-description">Image Source</th>
                                    <th class="goods-page-description">Discount, %</th>
                                    <th class="goods-page-description">Available</th>
                                    <th class="goods-page-description">Edit</th>
                                </tr>
                                <form id="editItemForm" method="GET"
                                      action="${contextPath}/processEditItem" modelAttribute="editedItem">
                                    <tr>
                                        <c:if test="${not empty item.id}">
                                            <td><input name="id" type="text" readonly value="${item.id}"></td>
                                        </c:if>
                                        <td><input name="productId" type="text" value="${item.productId}" required></td>
                                        <td><input name="price" type="text" value="${item.price}" required></td>
                                        <td><input name="itemType" type="text" value="${item.itemType}" required></td>
                                        <td><input name="itemSize" type="text" value="${item.itemSize}" required></td>
                                        <td>
                                            <select name="currencyId" required>
                                                <option value="${item.currencyId}">Default</option>
                                                <c:forEach var="currency" items="${currencyList}">
                                                    <option value="${currency.id}">${currency.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><input name="quantity" type="number" min="0" value="${item.quantity}"
                                                   required></td>
                                        <td><input name="quantOrdered" type="number" min="0"
                                                   value="${item.quantOrdered}" required></td>
                                        <td><input name="imageSource" type="text" value="${item.imageSource}" required>
                                        </td>
                                        <td><input name="discount" type="number" min="0" value="${item.discount}"
                                                   required></td>
                                        <td>
                                            <select name="available" required>
                                                <option value="${item.available}">Default</option>
                                                <option value="true">Yes</option>
                                                <option value="false">No</option>
                                            </select>
                                        </td>
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