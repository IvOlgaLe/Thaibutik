<%@include file="links_top.jsp" %>
<title>Checkout | Thai Butik</title>
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li class="active">Checkout</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN CONTENT -->
            <div class="col-md-12 col-sm-12">
                <h1>Checkout</h1>
                <!-- BEGIN CHECKOUT PAGE -->
                <div class="panel-group checkout-page accordion scrollable" id="checkout-page">
                    <form id="checkout_form" action="${contextPath}/processPlaceOrder" method="GET" role="form">
                    <!-- BEGIN SHIPPING ADDRESS -->
                    <div id="shipping-address" class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">
                                <a data-toggle="collapse" data-parent="#checkout-page" href="#shipping-address-content"
                                   class="accordion-toggle">
                                    Step 1: Delivery Details
                                </a>
                            </h2>
                        </div>
                        <div id="shipping-address-content" class="panel-collapse collapse in">
                                <div class="panel-body row">
                                    <div class="col-md-6 col-sm-6">
                                        <div class="form-group">
                                            <label for="name">Name<span
                                                    class="require">*</span></label>
                                            <input name="userName" type="text" id="name"
                                                   class="form-control" required readonly value="${sessUser.name}">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6">
                                        <div class="form-group">
                                            <label for="address1-dd">Shipping Address<span
                                                    class="require">*</span></label>
                                            <input name="deliveryAddress" type="text" id="address1-dd"
                                                   class="form-control" required value="${sessUser.address}">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6">
                                        <div class="form-group">
                                            <div class="form-group">
                                                <label for="delivery-comments">Add Comments About Your Order</label>
                                                <textarea name="deliveryInfo" id="delivery-comments" rows="3"
                                                          class="form-control"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <button class="btn btn-primary  pull-right" type="submit"
                                                data-toggle="collapse"
                                                data-parent="#checkout-page" data-target="#confirm-content"
                                                id="button-shipping-address">Continue
                                        </button>
                                    </div>
                                </div>
                        </div>
                    </div>
                    <!-- END SHIPPING ADDRESS -->

                    <!-- BEGIN CONFIRM -->
                    <div id="confirm" class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">
                                <a data-toggle="collapse" data-parent="#checkout-page" href="#confirm-content"
                                   class="accordion-toggle">
                                    Step 2: Confirm Order
                                </a>
                            </h2>
                        </div>
                        <div id="confirm-content" class="panel-collapse collapse">
                            <div class="row margin-40">
                                <div class="col-md-12 col-sm-12">
                                    <div class="goods-page">
                                        <!-- BEGIN CART CONTENT -->
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
                                                        <tr>
                                                            <td class="goods-page-image">
                                                                <a href="${imgPrefix}/products/${cartDetail.productImageSource}"><img
                                                                        src="${imgPrefix}/products/${cartDetail.productImageSource}"
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
                                                                    <input name="quantity" type="number" readonly
                                                                           value="${cartDetail.quantity}"
                                                                           class="form-control input-sm">
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
                                                        </tr>
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
                                        <!-- END CART CONTENT -->
                                        <div class="col-md-12">
                                            <a href="${contextPath}/shoppingCart" class="btn btn-default">Edit Order</a>
                                            <button class="btn btn-primary  pull-right" type="submit"
                                                    id="button-confirm" data-toggle="collapse"
                                                    data-parent="#checkout-page" data-target="#payment-content">Continue
                                            </button>
                                            <div class="checkbox pull-right">
                                                <label>
                                                    <input type="checkbox" required> I have read and agree to the <a
                                                        title="Terms & Conditions"
                                                        href="${contextPath}/termsConditions">Terms
                                                    & Conditions </a> &nbsp;&nbsp;&nbsp;
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END CONFIRM -->

                    <!-- BEGIN PAYMENT METHOD -->
                    <div id="payment" class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">
                                <a data-toggle="collapse" data-parent="#checkout-page" href="#payment-content"
                                   class="accordion-toggle">
                                    Step 3: Payment
                                </a>
                            </h2>
                        </div>
                        <div id="payment-content" class="panel-collapse collapse">
                            <div class="panel-body row">
                                <div class="container">
                                    <div class="col-md-6">
                                        <!-- CREDIT CARD FORM STARTS HERE -->
                                        <div class="panel panel-default credit-card-box">
                                            <div class="panel-heading display-table">
                                                <div class="row display-tr">
                                                    <h3 class="panel-title display-td">Payment Details</h3>
                                                    <div class="display-td">
                                                        <img class="img-responsive pull-right"
                                                             src="${imgPrefix}/payments/accepted_c22e0.png">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="panel-body">
                                                <form role="form" id="payment-form" action="${contextPath}/processPlaceOrder">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <div class="form-group">
                                                                <label for="cardNumber">CARD NUMBER</label>
                                                                <div class="input-group">
                                                                    <input
                                                                            type="tel" class="form-control"
                                                                            name="cardNumber"
                                                                            placeholder="Valid Card Number"
                                                                            autocomplete="cc-number"
                                                                            required autofocus
                                                                    />
                                                                    <span class="input-group-addon"><i
                                                                            class="fa fa-credit-card"></i></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-xs-7 col-md-7">
                                                            <div class="form-group">
                                                                <label for="cardExpiry"><span
                                                                        class="hidden-xs">EXPIRATION</span><span
                                                                        class="visible-xs-inline">EXP</span>
                                                                    DATE</label>
                                                                <input
                                                                        type="tel" class="form-control"
                                                                        name="cardExpiry" placeholder="MM / YY"
                                                                        autocomplete="cc-exp" required
                                                                />
                                                            </div>
                                                        </div>
                                                        <div class="col-xs-5 col-md-5 pull-right">
                                                            <div class="form-group">
                                                                <label for="cardCVC">CV CODE</label>
                                                                <input type="tel" class="form-control" name="cardCVC"
                                                                       placeholder="CVC" autocomplete="cc-csc" required
                                                                />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <button class="btn btn-primary btn-lg btn-block left"
                                                                    type="submit">Place Order
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <div class="row" style="display:none;">
                                                        <div class="col-xs-12">
                                                            <p class="payment-errors"></p>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <!-- CREDIT CARD FORM ENDS -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END PAYMENT METHOD -->
                    </div>
                    </form>
                </div>
                <!-- END CHECKOUT PAGE -->
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

<%@include file="footer.jsp" %>

<%@include file="links_bottom.jsp" %>

</body>
<!-- END BODY -->
</html>