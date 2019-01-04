<%@include file="links_top.jsp" %>
<title>ThaiButik</title>

<!--- for slider on the index page -->
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
      rel="stylesheet" type="text/css">
<link href="/resources/css/slider.css" rel="stylesheet">

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<!-- BEGIN SLIDER -->
<div class="page-slider margin-bottom-35">
    <div id="carousel-example-generic" class="carousel slide carousel-slider">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <!-- First slide -->
            <div class="item carousel-item-one active">
                <div class="container">
                    <div class="carousel-position-one text-center">
                        <h2 class="margin-bottom-20 animate-delay carousel-title-v3 border-bottom-title text-uppercase"
                            data-animation="animated fadeInDown">
                            Natural cosmetic <br/><span class="color-red-v2">Thai Butik</span><br/> Irk
                        </h2>
                        <p class="carousel-subtitle-v2" data-animation="animated fadeInUp">Lorem ipsum dolor sit amet
                            constectetuer diam <br/>
                            adipiscing elit euismod ut laoreet dolore.</p>
                    </div>
                </div>
            </div>

            <!-- Second slide -->
            <div class="item carousel-item-two">
                <div class="container">
                    <div class="carousel-position-four text-center">
                        <h2 class="animate-delay carousel-title-v4" data-animation="animated fadeInDown">
                            Sales
                        </h2>
                        <p class="carousel-subtitle-v2" data-animation="animated fadeInDown">
                            up to 50%
                        </p>
                        <p class="carousel-subtitle-v3 margin-bottom-30" data-animation="animated fadeInUp">
                            Don't miss
                        </p>
                        <a class="carousel-btn" href="${contextPath}/catalog" data-animation="animated fadeInUp">See
                            More Details</a>
                    </div>
                </div>
            </div>

            <!-- Third slide -->
            <div class="item carousel-item-three">
                <div class="container">
                    <div class="carousel-position-four text-center">
                            <span class="carousel-subtitle-v3 margin-bottom-15" data-animation="animated fadeInDown">
                                Ads Place
                            </span>
                        <p class="carousel-subtitle-v4" data-animation="animated fadeInDown">
                            Thai Butik
                        </p>
                        <p class="carousel-subtitle-v3" data-animation="animated fadeInDown">
                            Buy It Today
                        </p>
                    </div>
                </div>
            </div>

            <!-- Fourth slide -->
            <div class="item carousel-item-four">
                <div class="center-block">
                    <div class="center-block-wrap">
                        <div class="center-block-body">
                            <h2 class="carousel-title-v1 margin-bottom-20" data-animation="animated fadeInDown">
                                The most <br/>
                                wanted Product
                            </h2>
                            <a class="carousel-btn" href="${contextPath}/catalog" data-animation="animated fadeInUp">Buy
                                It Now!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control carousel-control-shop" href="#carousel-example-generic" role="button"
           data-slide="prev">
            <i class="fa fa-angle-left" aria-hidden="true"></i>
        </a>
        <a class="right carousel-control carousel-control-shop" href="#carousel-example-generic" role="button"
           data-slide="next">
            <i class="fa fa-angle-right" aria-hidden="true"></i>
        </a>
    </div>
</div>
<!-- END SLIDER -->

<div class="main">
    <div class="container">
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-7">

                <!-- BEGIN PRODUCT LIST -->
                <div class="row product-list">
                    <c:forEach var="product" items="${productList}">
                        <!-- PRODUCT ITEM START -->
                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <div class="product-item">
                                <div class="pi-img-wrapper">
                                    <img src="${imgPrefix}/products/${product.imageSource}" class="img-responsive"
                                         alt="${product.name}">
                                </div>
                                <h3>
                                    <a href="${contextPath}/product/${product.id}/0">${product.name}</a>
                                </h3>
                                <div class="pi-price">$ <fmt:formatNumber type="number" maxFractionDigits="2"
                                                                          value="${product.itemList.get(0).price*(1-product.itemList.get(0).discount/100)}"/></div>
                                <c:if test="${product.itemList.get(0).discount > 0}">
                                    <em><span> (was $${product.itemList.get(0).price})</span></em>
                                </c:if>
                            </div>
                        </div>
                        <!-- PRODUCT ITEM END -->
                    </c:forEach>
                </div>
                <!-- END PRODUCT LIST -->
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