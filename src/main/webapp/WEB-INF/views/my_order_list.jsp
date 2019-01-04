<%@include file="links_top.jsp" %>
<title>ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li><a href="${contextPath}/myAccount">My Account</a></li>
            <li class="active">My Orders</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h1>My Order List</h1>
                <c:if test="${not empty exceptionList}">
                    <p>${exceptionList.get(0).getMessage()}</p>
                </c:if>
                <!-- BEGIN ORDER PAGE -->
                <div class="panel-group order_page accordion scrollable" id="order_page">
                    <c:if test="${not empty orderList}">
                        <!-- BEGIN ORDER -->
                        <c:forEach var="order" items="${orderList}">
                            <div id="order ${order.id}" class="panel panel-default">
                                <div class="panel-heading">
                                    <h2 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#order_page"
                                           href="#order${order.id}_content"
                                           class="accordion-toggle">
                                            Order: ${order.id} | Order Date: ${order.orderDate} |
                                            Items: ${order.totalQuantity} |
                                            Total Price: $ ${order.totalPrice}
                                            Order Status: ${order.orderState.name} |
                                            Delivery Date : ${order.deliveryDate}
                                        </a>
                                    </h2>
                                </div>
                                <div id="order${order.id}_content" class="panel-collapse collapse in">
                                    <div class="goods-data clearfix">
                                        <div class="table-wrapper-responsive">
                                            <table summary="Order">
                                                <tr>
                                                    <th class="goods-page-image"></th>
                                                    <th class="goods-page-description"></th>
                                                    <th class="goods-page-quantity">Quantity</th>
                                                    <th class="goods-page-price">Unit price</th>
                                                    <th class="goods-page-price">Subtotal</th>
                                                </tr>
                                                <c:forEach var="orderDetail" items="${order.orderDetailList}">
                                                    <tr>
                                                        <td class="goods-page-image">
                                                            <a href="${imgPrefix}/products/${orderDetail.productImageSource}"><img
                                                                    src="${imgPrefix}/products/${orderDetail.productImageSource}"
                                                                    alt="${orderDetail.productName}"></a>
                                                        </td>
                                                        <td class="goods-page-description">
                                                            <h3>
                                                                <a href="${contextPath}/product/${orderDetail.productId}/${orderDetail.itemId}">${orderDetail.productName}</a>
                                                            </h3>
                                                            <p><strong>${orderDetail.brandName}</strong></p>
                                                            <p>${orderDetail.itemType} ${orderDetail.itemSize}</p>
                                                        </td>
                                                        <td class="goods-page-quantity">
                                                            <p><strong>${orderDetail.quantity}</strong></p>
                                                        </td>
                                                        <td class="goods-page-price">
                                                            <strong><span>$</span>${orderDetail.price}</strong>
                                                        </td>
                                                        <td class="goods-page-price">
                                                            <strong><span>$</span>${orderDetail.quantity*orderDetail.price}
                                                            </strong>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <!-- END ORDER -->
                    </c:if>
                </div>
                <!-- END ORDER PAGE -->
            </div>
        </div>
        <!-- END CONTENT -->
    </div>
</div>

<%@include file="footer.jsp" %>

<%@include file="links_bottom.jsp" %>

</body>
<!-- END BODY -->
</html>