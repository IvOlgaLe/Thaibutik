<%@include file="links_top.jsp" %>
<title>Shopping cart | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <c:if test="${not empty sessUser}">
                <li><a href="${contextPath}/myAccount">My Account</a></li>
            </c:if>
            <li class="active">Shopping Cart</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h1>Shopping cart</h1>
                <div class="goods-page">
                    <c:if test="${not empty exceptionList}">
                        <p>${exceptionList.get(0).getMessage()}</p>
                    </c:if>
                    <c:if test="${not empty cart.cartDetailList}">
                        <div class="goods-data clearfix">
                            <div class="table-wrapper-responsive">
                                <table summary="Shopping cart">
                                    <tr>
                                        <th class="goods-page-image"></th>
                                        <th class="goods-page-description"></th>
                                        <th class="goods-page-quantity">Quantity</th>
                                        <th class="goods-page-price">Unit price</th>
                                    </tr>
                                    <c:forEach var="cartDetail" items="${cart.cartDetailList}">
                                        <form:form id="cartDetailForm" method="GET"
                                                   action="${contextPath}/changeCartDetail" modelAttribute="cartDetail">
                                            <input name="cartId" type="hidden" value="${cartDetail.cartId}">
                                            <input name="itemId" type="hidden" value="${cartDetail.itemId}">
                                            <tr>
                                                <td class="goods-page-image">
                                                    <a href="${imgPrefix}${cartDetail.productImageSource}"><img
                                                            src="${imgPrefix}${cartDetail.productImageSource}"
                                                            alt="${cartDetail.productName}"></a>
                                                </td>
                                                <td class="goods-page-description">
                                                    <h3>
                                                        <a href="${contextPath}/product/${cartDetail.productId}/${cartDetail.itemId}">${cartDetail.productName}</a>
                                                    </h3>
                                                    <p><strong>${cartDetail.brandName}</strong></p>
                                                    <p>${cartDetail.itemType} ${cartDetail.itemSize}</p>
                                                </td>
                                                <td class="goods-page-quantity">
                                                    <div class="product-quantity">
                                                        <input name="quantity" type="number"
                                                               value="${cartDetail.quantity}" min="1" max="99"
                                                               class="form-control input-sm">
                                                        <button type="submit">Change quantity</button>
                                                    </div>
                                                </td>
                                                <td class="goods-page-price">
                                                    <strong><span>$</span><fmt:formatNumber type="number"
                                                                                            maxFractionDigits="2"
                                                                                            value="${cartDetail.price*(1-cartDetail.discount/100)}"/></strong>
                                                    <c:if test="${cartDetail.discount > 0}">
                                                        <em>(was $<span>${cartDetail.price})</span></em>
                                                    </c:if>
                                                </td>
                                                <td class="del-goods-col">
                                                    <a class="del-goods"
                                                       href="${contextPath}/deleteItemFromCart/${cartDetail.itemId}">&nbsp;</a>
                                                </td>
                                            </tr>
                                        </form:form>
                                    </c:forEach>
                                </table>
                            </div>

                            <div class="shopping-total">
                                <ul>
                                    <li>
                                        <em>Items</em>
                                        <strong class="price">${cart.totalQuantity}</strong>
                                    </li>
                                    <li class="shopping-total-price">
                                        <em>Total Price</em>
                                        <strong class="price"><span>$</span>${cart.totalPrice}</strong>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <a href="${contextPath}/checkout" class="btn btn-primary">Checkout</a>
                    </c:if>
                    <c:if test="${empty cart.cartDetailList}">
                        <div class="goods-data clearfix">
                            <h2>Your shopping cart is empty</h2>
                        </div>
                    </c:if>
                    <a href="${contextPath}/index" class="btn btn-default">Continue shopping</a>

                </div>
            </div>
        </div>
        <!-- END CONTENT -->
        <%@include file="bestsellers.jsp" %>
    </div>
</div>

<%@include file="footer.jsp" %>

<%@include file="links_bottom.jsp" %>
</body>
<!-- END BODY -->
</html>