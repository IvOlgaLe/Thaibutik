<!-- BEGIN TOP BAR -->
<div class="pre-header">
    <div class="container">
        <div class="row">
            <!-- BEGIN TOP BAR LEFT PART -->
            <div class="col-md-6 col-sm-6 additional-shop-info">
                <ul class="list-unstyled list-inline">
                    <li><i class="fa fa-phone"></i><span>+1 666 777 88 99</span></li>
                    <!-- BEGIN CURRENCIES -->
<%--                    <li class="shop-currencies">
                        <a href="javascript:void(0);" class="current">$</a>
                        <a href="javascript:void(0);">RUB</a>
                    </li>--%>
                    <!-- END CURRENCIES -->
<%--                    <!-- BEGIN LANGS -->
                    <li class="langs-block">
                        <a href="javascript:void(0);" class="current">English</a>
                        <div class="langs-block-others-wrapper"><div class="langs-block-others">
                            <a href="javascript:void(0);">Russian</a>
                        </div></div>
                    </li>
                    <!-- END LANGS -->--%>
                </ul>
            </div>
            <!-- END TOP BAR LEFT PART -->
            <!-- BEGIN TOP BAR MENU -->
            <div class="col-md-6 col-sm-6 additional-nav">
                <ul class="list-unstyled list-inline pull-right">
                    <li><a href="WishList">My Wishlist</a></li>
                    <li><a href="Checkout">Checkout</a></li>
                    <c:if test="${!empty sessUser}">
                        <li><a href="MyAccount">Hi, ${sessUser.name}</a></li>
                        <li><a href="processLogout">Log Out</a></li>
                    </c:if>
                    <c:if test="${empty sessUser}">
                        <li><a href="Login">Log In | Register</a></li>
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
        <a class="site-logo" href="Index"><img src="/resources/corporate/img/logos/logo_shop.png" alt="ThaiButik"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN CART -->
        <div class="top-cart-block">
            <div class="top-cart-info">
                <a href="javascript:void(0);" class="top-cart-info-count">${cartItemsNumber}</a>
                <a href="javascript:void(0);" class="top-cart-info-value">$ ${cartTotalPrice}</a>
            </div>
            <i class="fa fa-shopping-cart"></i>

            <div class="top-cart-content-wrapper">
                <div class="top-cart-content">
                    <ul class="scroller" style="height: 250px;">
                        <li>
                            <a href="product.jsp"><img src="/resources/pages/img/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                            <span class="cart-content-count">x 1</span>
                            <strong><a href="product.jsp">Rolex Classic Watch</a></strong>
                            <em>$1230</em>
                            <a href="javascript:void(0);" class="del-goods">&nbsp;</a>
                        </li>
                    </ul>
                    <div class="text-right">
                        <a href="ShoppingCart" class="btn btn-default">View Cart</a>
                        <a href="Checkout" class="btn btn-primary">Checkout</a>
                    </div>
                </div>
            </div>
        </div>
        <!--END CART -->

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation">
            <ul>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="javascript:;">
                        ${categoryName}
                    </a>

                    <!-- BEGIN DROPDOWN MENU -->
                    <ul class="dropdown-menu">
                        <li><a href="ProductList">First Link</a></li>
                        <li><a href="ProductList">Second Link</a></li>
                    </ul>
                    <!-- END DROPDOWN MENU -->
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="javascript:;">
                        ${categoryName}
                    </a>

                    <!-- BEGIN DROPDOWN MENU -->
                    <ul class="dropdown-menu">
                        <li><a href="ProductList">First Link</a></li>
                        <li><a href="ProductList">Second Link</a></li>
                    </ul>
                    <!-- END DROPDOWN MENU -->
                </li>

                <!-- BEGIN TOP SEARCH -->
                <li class="menu-search">
                    <span class="sep"></span>
                    <i class="fa fa-search search-btn"></i>
                    <div class="search-box">
                        <form action="processSearch">
                            <div class="input-group">
                                <input type="text" name="searchWord" placeholder="Search" class="form-control">
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