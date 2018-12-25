<%@include file="links_top.jsp"%>
<%--

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
--%>

  <title>Product Comparison</title>
<%--  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <meta content="Metronic Shop UI description" name="description">
  <meta content="Metronic Shop UI keywords" name="keywords">
  <meta content="keenthemes" name="author">

  <meta property="og:site_name" content="-CUSTOMER VALUE-">
  <meta property="og:title" content="-CUSTOMER VALUE-">
  <meta property="og:description" content="-CUSTOMER VALUE-">
  <meta property="og:type" content="website">
  <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
  <meta property="og:url" content="-CUSTOMER VALUE-">

  <link rel="shortcut icon" href="favicon.ico">
  <!-- Fonts START -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css"> 
  <!-- Fonts END -->--%>

<%--  <!-- Global styles START -->
&lt;%&ndash;  <link href="/resources/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">&ndash;%&gt;
  <link href="/resources/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <spring:url value="/resources/plugins/font-awesome/css/font-awesome.min.css" var="font_awesomeCSS" />
  <spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCSS" />
  <link href="${font_awesomeCSS}" rel="stylesheet" />
  <link href="${bootstrapCSS}" rel="stylesheet" />
&lt;%&ndash;  <spring:url value="/resources/crunchify.js" var="crunchifyJS" />&ndash;%&gt;
&lt;%&ndash;  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="${crunchifyJS}"></script>&ndash;%&gt;--%>

  <!-- Global styles END --> 
   
<%--  <!-- Page level plugin styles START -->
  <link href="/resources/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="/resources/plugins/owl.carousel/assets/owl.carousel.css" rel="stylesheet">
  <link href="/resources/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"><!-- for slider-range -->
  <!-- Page level plugin styles END -->--%>

  <!-- Theme styles START -->
 <%-- <link href="/resources/pages/css/components.css" rel="stylesheet">
  <link href="/resources/corporate/css/style.css" rel="stylesheet">
  <link href="/resources/pages/css/style-shop.css" rel="stylesheet" type="text/css">
  <link href="/resources/corporate/css/style-responsive.css" rel="stylesheet">
  <link href="/resources/corporate/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="/resources/corporate/css/custom.css" rel="stylesheet">--%>
  <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp"%>
   <%-- <!-- BEGIN STYLE CUSTOMIZER -->
    <div class="color-panel hidden-sm">
      <div class="color-mode-icons icon-color"></div>
      <div class="color-mode-icons icon-color-close"></div>
      <div class="color-mode">
        <p>THEME COLOR</p>
        <ul class="inline">
          <li class="color-red current color-default" data-style="red"></li>
          <li class="color-blue" data-style="blue"></li>
          <li class="color-green" data-style="green"></li>
          <li class="color-orange" data-style="orange"></li>
          <li class="color-gray" data-style="gray"></li>
          <li class="color-turquoise" data-style="turquoise"></li>
        </ul>
      </div>
    </div>
    <!-- END BEGIN STYLE CUSTOMIZER --> 

    <!-- BEGIN TOP BAR -->
    <div class="pre-header">
        <div class="container">
            <div class="row">
                <!-- BEGIN TOP BAR LEFT PART -->
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    <ul class="list-unstyled list-inline">
                        <li><i class="fa fa-phone"></i><span>+1 456 6717</span></li>
                        <!-- BEGIN CURRENCIES -->
                        <li class="shop-currencies">
                            <a href="javascript:void(0);">€</a>
                            <a href="javascript:void(0);">£</a>
                            <a href="javascript:void(0);" class="current">$</a>
                        </li>
                        <!-- END CURRENCIES -->
                        <!-- BEGIN LANGS -->
                        <li class="langs-block">
                            <a href="javascript:void(0);" class="current">English </a>
                            <div class="langs-block-others-wrapper"><div class="langs-block-others">
                              <a href="javascript:void(0);">French</a>
                              <a href="javascript:void(0);">Germany</a>
                              <a href="javascript:void(0);">Turkish</a>
                            </div></div>
                        </li>
                        <!-- END LANGS -->
                    </ul>
                </div>
                <!-- END TOP BAR LEFT PART -->
                <!-- BEGIN TOP BAR MENU -->
                <div class="col-md-6 col-sm-6 additional-nav">
                    <ul class="list-unstyled list-inline pull-right">
                        <li><a href="my_account.jsp">My Account</a></li>
                        <li><a href="wish_list.jsp">My Wishlist</a></li>
                        <li><a href="checkout.jsp">Checkout</a></li>
                        <li><a href="page-login.html">Log In</a></li>
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
        <a class="site-logo" href="index.jsp"><img src="/resources/corporate/img/logos/logo-shop-red.png" alt="Metronic Shop UI"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN CART -->
        <div class="top-cart-block">
          <div class="top-cart-info">
            <a href="javascript:void(0);" class="top-cart-info-count">3 items</a>
            <a href="javascript:void(0);" class="top-cart-info-value">$1260</a>
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
                <li>
                  <a href="product.jsp"><img src="/resources/pages/img/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                  <span class="cart-content-count">x 1</span>
                  <strong><a href="product.jsp">Rolex Classic Watch</a></strong>
                  <em>$1230</em>
                  <a href="javascript:void(0);" class="del-goods">&nbsp;</a>
                </li>
                <li>
                  <a href="product.jsp"><img src="/resources/pages/img/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                  <span class="cart-content-count">x 1</span>
                  <strong><a href="product.jsp">Rolex Classic Watch</a></strong>
                  <em>$1230</em>
                  <a href="javascript:void(0);" class="del-goods">&nbsp;</a>
                </li>
                <li>
                  <a href="product.jsp"><img src="/resources/pages/img/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                  <span class="cart-content-count">x 1</span>
                  <strong><a href="product.jsp">Rolex Classic Watch</a></strong>
                  <em>$1230</em>
                  <a href="javascript:void(0);" class="del-goods">&nbsp;</a>
                </li>
                <li>
                  <a href="product.jsp"><img src="/resources/pages/img/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                  <span class="cart-content-count">x 1</span>
                  <strong><a href="product.jsp">Rolex Classic Watch</a></strong>
                  <em>$1230</em>
                  <a href="javascript:void(0);" class="del-goods">&nbsp;</a>
                </li>
                <li>
                  <a href="product.jsp"><img src="/resources/pages/img/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                  <span class="cart-content-count">x 1</span>
                  <strong><a href="product.jsp">Rolex Classic Watch</a></strong>
                  <em>$1230</em>
                  <a href="javascript:void(0);" class="del-goods">&nbsp;</a>
                </li>
                <li>
                  <a href="product.jsp"><img src="/resources/pages/img/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                  <span class="cart-content-count">x 1</span>
                  <strong><a href="product.jsp">Rolex Classic Watch</a></strong>
                  <em>$1230</em>
                  <a href="javascript:void(0);" class="del-goods">&nbsp;</a>
                </li>
                <li>
                  <a href="product.jsp"><img src="/resources/pages/img/cart-img.jpg" alt="Rolex Classic Watch" width="37" height="34"></a>
                  <span class="cart-content-count">x 1</span>
                  <strong><a href="product.jsp">Rolex Classic Watch</a></strong>
                  <em>$1230</em>
                  <a href="javascript:void(0);" class="del-goods">&nbsp;</a>
                </li>
              </ul>
              <div class="text-right">
                <a href="shopping_cart.jsp" class="btn btn-default">View Cart</a>
                <a href="checkout.jsp" class="btn btn-primary">Checkout</a>
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
                Woman 
                
              </a>
                
              <!-- BEGIN DROPDOWN MENU -->
              <ul class="dropdown-menu">
                <li class="dropdown-submenu">
                  <a href="ProductList">Hi Tops <i class="fa fa-angle-right"></i></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="ProductList">Second Level Link</a></li>
                    <li><a href="ProductList">Second Level Link</a></li>
                    <li class="dropdown-submenu">
                      <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="javascript:;">
                        Second Level Link 
                        <i class="fa fa-angle-right"></i>
                      </a>
                      <ul class="dropdown-menu">
                        <li><a href="ProductList">Third Level Link</a></li>
                        <li><a href="ProductList">Third Level Link</a></li>
                        <li><a href="ProductList">Third Level Link</a></li>
                      </ul>
                    </li>
                  </ul>
                </li>
                <li><a href="ProductList">Running Shoes</a></li>
                <li><a href="ProductList">Jackets and Coats</a></li>
              </ul>
              <!-- END DROPDOWN MENU -->
            </li>
            <li class="dropdown dropdown-megamenu">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="javascript:;">
                Man
                
              </a>
              <ul class="dropdown-menu">
                <li>
                  <div class="header-navigation-content">
                    <div class="row">
                      <div class="col-md-4 header-navigation-col">
                        <h4>Footwear</h4>
                        <ul>
                          <li><a href="ProductList">Astro Trainers</a></li>
                          <li><a href="ProductList">Basketball Shoes</a></li>
                          <li><a href="ProductList">Boots</a></li>
                          <li><a href="ProductList">Canvas Shoes</a></li>
                          <li><a href="ProductList">Football Boots</a></li>
                          <li><a href="ProductList">Golf Shoes</a></li>
                          <li><a href="ProductList">Hi Tops</a></li>
                          <li><a href="ProductList">Indoor and Court Trainers</a></li>
                        </ul>
                      </div>
                      <div class="col-md-4 header-navigation-col">
                        <h4>Clothing</h4>
                        <ul>
                          <li><a href="ProductList">Base Layer</a></li>
                          <li><a href="ProductList">Character</a></li>
                          <li><a href="ProductList">Chinos</a></li>
                          <li><a href="ProductList">Combats</a></li>
                          <li><a href="ProductList">Cricket Clothing</a></li>
                          <li><a href="ProductList">Fleeces</a></li>
                          <li><a href="ProductList">Gilets</a></li>
                          <li><a href="ProductList">Golf Tops</a></li>
                        </ul>
                      </div>
                      <div class="col-md-4 header-navigation-col">
                        <h4>Accessories</h4>
                        <ul>
                          <li><a href="ProductList">Belts</a></li>
                          <li><a href="ProductList">Caps</a></li>
                          <li><a href="ProductList">Gloves, Hats and Scarves</a></li>
                        </ul>

                        <h4>Clearance</h4>
                        <ul>
                          <li><a href="ProductList">Jackets</a></li>
                          <li><a href="ProductList">Bottoms</a></li>
                        </ul>
                      </div>
                      <div class="col-md-12 nav-brands">
                        <ul>
                          <li><a href="ProductList"><img title="esprit" alt="esprit" src="/resources/pages/img/brands/esprit.jpg"></a></li>
                          <li><a href="ProductList"><img title="gap" alt="gap" src="/resources/pages/img/brands/gap.jpg"></a></li>
                          <li><a href="ProductList"><img title="next" alt="next" src="/resources/pages/img/brands/next.jpg"></a></li>
                          <li><a href="ProductList"><img title="puma" alt="puma" src="/resources/pages/img/brands/puma.jpg"></a></li>
                          <li><a href="ProductList"><img title="zara" alt="zara" src="/resources/pages/img/brands/zara.jpg"></a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </li>
            <li><a href="product.jsp">Kids</a></li>
            <li class="dropdown dropdown100 nav-catalogue">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="javascript:;">
                New
                
              </a>
              <ul class="dropdown-menu">
                <li>
                  <div class="header-navigation-content">
                    <div class="row">
                      <div class="col-md-3 col-sm-4 col-xs-6">
                        <div class="product-item">
                          <div class="pi-img-wrapper">
                            <a href="product.jsp"><img src="/resources/pages/img/products/model4.jpg" class="img-responsive" alt="Berry Lace Dress"></a>
                          </div>
                          <h3><a href="product.jsp">Berry Lace Dress</a></h3>
                          <div class="pi-price">$29.00</div>
                          <a href="javascript:;" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                      </div>
                      <div class="col-md-3 col-sm-4 col-xs-6">
                        <div class="product-item">
                          <div class="pi-img-wrapper">
                            <a href="product.jsp"><img src="/resources/pages/img/products/model3.jpg" class="img-responsive" alt="Berry Lace Dress"></a>
                          </div>
                          <h3><a href="product.jsp">Berry Lace Dress</a></h3>
                          <div class="pi-price">$29.00</div>
                          <a href="javascript:;" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                      </div>
                      <div class="col-md-3 col-sm-4 col-xs-6">
                        <div class="product-item">
                          <div class="pi-img-wrapper">
                            <a href="product.jsp"><img src="/resources/pages/img/products/model7.jpg" class="img-responsive" alt="Berry Lace Dress"></a>
                          </div>
                          <h3><a href="product.jsp">Berry Lace Dress</a></h3>
                          <div class="pi-price">$29.00</div>
                          <a href="javascript:;" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                      </div>
                      <div class="col-md-3 col-sm-4 col-xs-6">
                        <div class="product-item">
                          <div class="pi-img-wrapper">
                            <a href="product.jsp"><img src="/resources/pages/img/products/model4.jpg" class="img-responsive" alt="Berry Lace Dress"></a>
                          </div>
                          <h3><a href="product.jsp">Berry Lace Dress</a></h3>
                          <div class="pi-price">$29.00</div>
                          <a href="javascript:;" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </li>
            <li class="dropdown active">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="javascript:;">
                Pages 
                
              </a>
                
              <ul class="dropdown-menu">
                <li><a href="index.jsp">Home Default</a></li>
                <li><a href="index.jsp">Home Header Fixed</a></li>
                <li><a href="trashbin/shop-index-light-footer.html">Home Light Footer</a></li>
                <li><a href="ProductList">Product List</a></li>
                <li><a href="search_result.jsp">Search Result</a></li>
                <li><a href="product.jsp">Product Page</a></li>
                <li><a href="trashbin/shop-shopping-cart-null.html">Shopping Cart (Null Cart)</a></li>
                <li><a href="shopping_cart.jsp">Shopping Cart</a></li>
                <li><a href="checkout.jsp">Checkout</a></li>
                <li><a href="about_us.jsp">About</a></li>
                <li><a href="contact_us.jsp">Contacts</a></li>
                <li><a href="my_account.jsp">My account</a></li>
                <li><a href="wish_list.jsp">My Wish List</a></li>
                <li class="active"><a href="goods_compare.jsp">Product Comparison</a></li>
                <li><a href="profile_form.jsp">Standart Forms</a></li>
                <li><a href="faq.jsp">FAQ</a></li>
                <li><a href="trashbin/shop-privacy-policy.html">Privacy Policy</a></li>
                <li><a href="terms_conditions.jsp">Terms &amp; Conditions</a></li>
              </ul>
            </li>
            
            
            <li><a href="http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes&amp;utm_source=download&amp;utm_medium=banner&amp;utm_campaign=metronic_frontend_freebie" target="_blank">Admin theme</a></li>

            <!-- BEGIN TOP SEARCH -->
            <li class="menu-search">
              <span class="sep"></span>
              <i class="fa fa-search search-btn"></i>
              <div class="search-box">
                <form action="#">
                  <div class="input-group">
                    <input type="text" placeholder="Search" class="form-control">
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
    --%>
    <div class="main">
      <div class="container">
        <ul class="breadcrumb">
            <li><a href="Index">Home</a></li>
            <li><a href="">Store</a></li>
            <li class="active">My Wish List</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

          <%@include file="sidebar.jsp"%>

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-7">
            <h1>Product Comparison</h1>
            <div class="goods-page">
              <div class="goods-data compare-goods clearfix">
                <div class="table-wrapper-responsive">                
                  <table summary="Product Details">                  
                    <tr>
                      <td class="compare-info">
                        <p>There are 2 goods in the list.</p>
                      </td>
                      <td class="compare-item">
                        <a href="javascript:;"><img src="/resources/pages/img/products/model3.jpg" alt="Berry Lace Dress"></a>
                        <h3><a href="javascript:;">Cool green dress with red bell</a></h3>
                        <strong class="compare-price"><span>$</span>47.00</strong>
                      </td>
                      <td class="compare-item">
                        <a href="javascript:;"><img src="/resources/pages/img/products/model4.jpg" alt="Berry Lace Dress"></a>
                        <h3><a href="javascript:;">Cool green dress with red bell</a></h3>
                        <strong class="compare-price"><span>$</span>42.00</strong>
                      </td>
                    </tr>

                    <tr>
                      <th colspan="3">
                        <h2>Product Details</h2>
                      </th>
                    </tr>
                    <tr>
                      <td class="compare-info">
                        Attribute
                      </td>
                      <td class="compare-item">
                        Lorem ipsum
                      </td>
                      <td class="compare-item">
                        Duis autem
                      </td>
                    </tr>
                    <tr>
                      <td class="compare-info">
                        Attribute
                      </td>
                      <td class="compare-item">
                        13.00cm x 0.00cm x 0.00cm
                      </td>
                      <td class="compare-item">
                        13.00cm x 0.00cm x 0.00cm
                      </td>
                    </tr>
                    <tr>
                      <td class="compare-info">
                        Attribute
                      </td>
                      <td class="compare-item">
                        110.00g
                      </td>
                      <td class="compare-item">
                        110.00g
                      </td>
                    </tr>

                    <tr>
                      <th colspan="3">
                        <h2>Features</h2>
                      </th>
                    </tr>
                    <tr>
                      <td class="compare-info">
                        Attribute
                      </td>
                      <td class="compare-item">
                        13 cm
                      </td>
                      <td class="compare-item">
                        –
                      </td>
                    </tr>
                    <tr>
                      <td class="compare-info">
                        Attribute
                      </td>
                      <td class="compare-item">
                        In Stock
                      </td>
                      <td class="compare-item">
                        In Stock
                      </td>
                    </tr>
                    <tr>
                      <td class="compare-info">&nbsp;</td>
                      <td class="compare-item">
                        <a class="btn btn-primary" href="javascript:;">Add to cart</a><br>
                        <a class="btn btn-default" href="javascript:;">Delete</a>
                      </td>
                      <td class="compare-item">
                        <a class="btn btn-primary" href="javascript:;">Add to cart</a><br>
                        <a class="btn btn-default" href="javascript:;">Delete</a>
                      </td>
                    </tr>
                  </table>
                  <p class="padding-top-20"><strong>Notice:</strong> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam sit nonummy nibh euismod tincidunt ut laoreet dolore magna aliquarm erat sit volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl aliquip commodo consequat. </p>
                </div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>

  <%@include file="footer.jsp"%>

  <%@include file="fast_view_product.jsp"%>

  <%@include file="links_bottom.jsp"%>

</body>
<!-- END BODY -->
</html>