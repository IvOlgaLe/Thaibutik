<!-- BEGIN TOP BAR -->
<div class="pre-header">
    <div class="container">
        <div class="row">
            <!-- BEGIN TOP BAR LEFT PART -->
            <div class="col-md-6 col-sm-6 additional-shop-info">
                <ul class="list-unstyled list-inline">
                    <li><i class="fa fa-phone"></i><span>+1 666 777 88 99</span></li>
                </ul>
            </div>
            <!-- END TOP BAR LEFT PART -->
            <!-- BEGIN TOP BAR MENU -->
            <div class="col-md-6 col-sm-6 additional-nav">
                <ul class="list-unstyled list-inline pull-right">
                  <%--  <li><a href="${contextPath}/wishList">My Wishlist</a></li>--%>
                    <li><a href="${contextPath}/checkout">Checkout</a></li>
                    <c:if test="${!empty sessUser}">
                        <li><a href="${contextPath}/myAccount">Hi, ${sessUser.name}</a></li>
                        <li><a href="${contextPath}/processLogout">Log Out</a></li>
                    </c:if>
                    <c:if test="${empty sessUser}">
                        <li><a href="${contextPath}/login">Log In | Register</a></li>
                    </c:if>
                </ul>
            </div>
            <!-- END TOP BAR MENU -->
        </div>
    </div>
</div>
<!-- END TOP BAR -->

<!-- BEGIN HEADER -->
<div class="header">
    <div class="container">
        <a class="site-logo" href="${contextPath}/index"><img src="${imgPrefix}/logos/logo_shop.png" alt="ThaiButik">THAI BUTIK</a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN CART -->
        <div class="top-cart-block">
            <div class="top-cart-info">
                <a href="${contextPath}/shoppingCart" class="top-cart-info-count">
                    ${not empty cart.totalQuantity ? cart.totalQuantity : 0}</a>
                <a href="${contextPath}/shoppingCart" class="top-cart-info-value">
                    $ ${not empty cart.totalPrice ? cart.totalPrice : 0}</a>
            </div>
            <i class="fa fa-shopping-cart"></i>

            <div class="top-cart-content-wrapper">
                <div class="top-cart-content">
                    <ul class="scroller" style="height: 250px;">
                        <c:forEach var="cartDetail" items="${cart.cartDetailList}">
                            <li>
                                <a href="${imgPrefix}/products/${cartDetail.productImageSource}">
                                    <img src="${imgPrefix}/products/${cartDetail.productImageSource}"
                                         alt="${cartDetail.productName}" width="60" height="34"></a>
                                <span class="cart-content-count">x ${cartDetail.quantity}</span>
                                <strong><a href="${contextPath}/product/0/${cartDetail.productId}/${cartDetail.itemId}">
                                        ${cartDetail.productName}</a></strong>
                                <strong><span>$<fmt:formatNumber type="number" maxFractionDigits="2"
                                                                        value="${cartDetail.price*(1-cartDetail.discount/100)}"/></span></strong>
                                <a href="${contextPath}/deleteItemFromCart/${cartDetail.itemId}" class="del-goods">&nbsp;</a>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="text-right">
                        <a href="${contextPath}/shoppingCart" class="btn btn-default">View Cart</a>
                        <a href="${contextPath}/checkout" class="btn btn-primary">Checkout</a>
                    </div>
                </div>
            </div>
        </div>
        <!--END CART -->

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation">
            <ul>
                <c:if test="${adminFlag}">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown">
                            Admin
                        </a>
                        <!-- BEGIN DROPDOWN MENU -->
                        <ul class="dropdown-menu">
                            <li><a href="${contextPath}/adminDashboard">Admin Dashboard</a></li>
                            <li><a href="${contextPath}/productTable">Products</a></li>
                            <li><a href="${contextPath}/orderTable">Orders</a></li>
                        </ul>
                        <!-- END DROPDOWN MENU -->
                    </li>
                </c:if>
                <c:forEach var="group" items="${groupList}">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="">
                        ${group.name}
                    </a>
                    <!-- BEGIN DROPDOWN MENU -->
                    <ul class="dropdown-menu">
                        <c:forEach var="category" items="${group.categoryList}">
                        <li><a href="${contextPath}/category/${category.id}">${category.name}</a></li>
                        </c:forEach>
                    </ul>
                    <!-- END DROPDOWN MENU -->
                </li>
                </c:forEach>

                <!-- BEGIN TOP SEARCH -->
                <li class="menu-search">
                    <span class="sep"></span>
                    <i class="fa fa-search search-btn"></i>
                    <div class="search-box">
                        <form action="${contextPath}/processSearch">
                            <div class="input-group">
                                <input type="text" name="name" placeholder="Search" class="form-control">
                                <span class="input-group-btn">
                                  <button class="btn btn-primary" type="submit">Search</button>
                                </span>
                            </div>
                        </form>
                    </div>
                </li>
                <!-- END TOP SEARCH -->
            </ul>
        </div>
        <!-- END NAVIGATION -->
    </div>
</div>
<!-- Header END -->