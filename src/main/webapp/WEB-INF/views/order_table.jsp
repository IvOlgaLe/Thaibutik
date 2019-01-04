<%@include file="links_top.jsp" %>
<title>Order Table | ThaiButik</title>

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
            <li class="active">Orders</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h1>Orders Table</h1>
                <div class="goods-page">
                    <c:if test="${not empty orderList}">
                        <div class="goods-data clearfix">
                            <div class="table-wrapper-responsive">
                                <table summary="Order Table">
                                    <tr>
                                        <th class="goods-page-description">Order Id</th>
                                        <th class="goods-page-description">User Id</th>
                                        <th class="goods-page-description">Order Date</th>
                                        <th class="goods-page-description">Total Quantity</th>
                                        <th class="goods-page-description">Total Price, $</th>
                                        <th class="goods-page-description">Delivery Address</th>
                                        <th class="goods-page-description">Delivery Info</th>
                                        <th class="goods-page-description">Order Status</th>
                                        <th class="goods-page-description">Delivery Date</th>
                                        <th class="goods-page-description">Order Detail</th>
                                        <th class="goods-page-description">Edit</th>
                                    </tr>
                                    <c:forEach var="order" items="${orderList}">
                                        <tr>
                                            <td>${order.id}</td>
                                            <td>${order.userId}</td>
                                            <td>${order.orderDate}</td>
                                            <td>${order.totalQuantity}</td>
                                            <td>${order.totalPrice}</td>
                                            <td>${order.deliveryAddress}</td>
                                            <td>${order.deliveryInfo}</td>
                                            <td>${order.orderState.name}</td>
                                            <td>${order.deliveryDate}</td>
                                            <td>
                                                <a href="${contextPath}/orderDetailTable/${order.id}">${order.orderDetailList.size()}</a>
                                            </td>
                                            <td>
                                                <a href="${contextPath}/orderDetailTable/${order.id}">Edit</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${empty orderList}">
                        <div class="goods-data clearfix">
                            <h2>There is no orders in the DB</h2>
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