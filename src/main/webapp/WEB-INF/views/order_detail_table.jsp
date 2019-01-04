<%@include file="links_top.jsp" %>
<title>Order Detail Table | ThaiButik</title>

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
            <li><a href="${contextPath}/orderTable">Orders</a></li>
            <li class="active">Order Details</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h1>Order Details Table</h1>
                <div class="goods-page">
                    <div class="goods-data clearfix">
                        <div class="table-wrapper-responsive">
                            <table summary="One Order Table">
                                <tr>
                                    <th class="goods-page-quantity">Order Id</th>
                                    <th class="goods-page-quantity">User Id</th>
                                    <th class="goods-page-description">Order Date</th>
                                    <th class="goods-page-description">Total Quantity</th>
                                    <th class="goods-page-description">Total Price, $</th>
                                    <th class="goods-page-description">Delivery Address</th>
                                    <th class="goods-page-description">Delivery Info</th>
                                    <th class="goods-page-description">Order Status</th>
                                    <th class="goods-page-description">Delivery Date</th>
                                    <th class="goods-page-description">Update DD</th>
                                    <th class="goods-page-description">Save</th>
                                </tr>
                                    <form id="editOrderForm" method="GET"
                                          action="${contextPath}/processEditOrder/${order.id}">
                                        <tr>
                                            <td>${order.id}</td>
                                            <td>${order.userId}</td>
                                            <td>${order.orderDate}</td>
                                            <td>${order.totalQuantity}</td>
                                            <td>${order.totalPrice}</td>
                                            <td>${order.deliveryAddress}</td>
                                            <td>${order.deliveryInfo}</td>
                                            <td>
                                                <select name="orderStateId">
                                                    <option value="${order.orderState.id}">${order.orderState.name}</option>
                                                    <c:forEach var="orderState" items="${orderStateList}">
                                                        <option value="${orderState.id}">${orderState.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td>${order.deliveryDate}</td>
                                            <td><input name="deliveryDate" type="date" value="${order.deliveryDate}"></td>
                                            <td><button class="btn btn-primary" type="submit">Save</button></td>
                                        </tr>
                                    </form>
                            </table>
                        </div>
                        <br>
                        <div class="table-wrapper-responsive">
                            <table summary="Order Detail Table">
                                <tr>
                                    <th class="goods-page-description">Product Id</th>
                                    <th class="goods-page-description">Item Id</th>
                                    <th class="goods-page-description">Product Name</th>
                                    <th class="goods-page-description">Brand Name</th>
                                    <th class="goods-page-description">Type</th>
                                    <th class="goods-page-description">Size</th>
                                    <th class="goods-page-description">Quantity</th>
                                    <th class="goods-page-description">Price, $</th>
                                    <th class="goods-page-description">Subtotal, $</th>
                                </tr>
                                <c:forEach var="orderDetail" items="${order.orderDetailList}">
                                    <tr>
                                        <td>${orderDetail.productId}</td>
                                        <td>${orderDetail.itemId}</td>
                                        <td>${orderDetail.productName}</td>
                                        <td>${orderDetail.brandName}</td>
                                        <td>${orderDetail.itemType}</td>
                                        <td>${orderDetail.itemSize}</td>
                                        <td>${orderDetail.quantity}</td>
                                        <td>${orderDetail.price}</td>
                                        <td>${orderDetail.quantity*orderDetail.price}</td>
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