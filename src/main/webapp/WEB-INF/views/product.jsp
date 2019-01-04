<%@include file="links_top.jsp" %>
<link href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css">
<!-- for slider-range -->
<link href="/resources/plugins/rateit/src/rateit.css" rel="stylesheet" type="text/css">
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li><a href="${contextPath}/catalog">Catalog</a></li>
            <c:if test="${not empty category.id}">
                <li><a href="${contextPath}/category/${category.id}">${category.name}</a></li>
            </c:if>
            <li class="active">${product.name}</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-9 col-sm-7">
                <div class="product-page">
                    <div class="row">
                        <form:form id="cartForm" method="GET" action="${contextPath}/addToCart/${item.id}">
                            <div class="col-md-6 col-sm-6">
                                <div class="product-main-image">
                                    <img src="${imgPrefix}/products/${product.imageSource}" alt="${product.name}"
                                         class="img-responsive" data-BigImgsrc="${product.name}"
                                         src="${imgPrefix}/products/${item.imageSource}">
                                </div>
                                <div class="product-other-images">
                                    <c:forEach var="item" items="${product.itemList}">
                                        <c:if test="${not empty fn:trim(item.imageSource)}">
                                            <a href="${imgPrefix}/products/${item.imageSource}" class="fancybox-button"
                                               rel="photos-lib"><img alt="${product.name}"
                                                                     src="${imgPrefix}/products/${item.imageSource}"></a>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <h1>${product.name}</h1>
                                <div class="price-availability-block clearfix">
                                    <div class="price">
                                        <strong><span>$</span><fmt:formatNumber type="number" maxFractionDigits="2"
                                                                                value="${item.price*(1-item.discount/100)}"/></strong>
                                        <c:if test="${item.discount > 0}">
                                            <em>$<span>${item.price}</span></em>
                                        </c:if>
                                    </div>
                                    <div class="availability">
                                        Availability:
                                        <strong><c:if test="${item.available}">In Stock</c:if>
                                            <c:if test="${not item.available}">Not Available Now</c:if>
                                        </strong>
                                    </div>
                                </div>
                                <div class="description">
                                    <p>Brand: ${product.brand.name}</p>
                                    <p>Type: ${item.itemType}</p>
                                    <p>Size: ${item.itemSize}</p>
                                </div>
                                <div class="product-page-options">
                                    <div class="pull-left">
                                        <label class="control-label">Type / Size:</label>
                                        <select name="itemId" onchange="if (this.value) window.location.href=this.value"
                                                class="form-control input-sm">
                                            <option>Select item</option>
                                            <c:forEach var="item" items="${product.itemList}">
                                                <option value="${contextPath}/product/${product.id}/${item.id}">
                                                        ${item.itemType} / ${item.itemSize} -
                                                    $ <fmt:formatNumber type="number" maxFractionDigits="2"
                                                                        value="${item.price*(1-item.discount/100)}"/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <c:if test="${item.available}">
                                    <div class="product-page-cart">
                                        <div class="product-quantity">
                                            <input name="itemQuantity" type="number" value="1" min="1" max="99"
                                                   class="form-control input-sm">
                                        </div>
                                        <input name="itemId" type="hidden" value="${item.id}">
                                        <button class="btn btn-primary add2cart" type="submit">Add to cart<i
                                                class="fa fa-check"></i></button>
                                    </div>
                                </c:if>
                            </div>
                        </form:form>
                    </div>

                    <div class="product-page-content">
                        <ul id="myTab" class="nav nav-tabs">
                            <li class="active"><a href="#Description" data-toggle="tab">Description</a></li>
                            <%-- <li class="active"><a href="#Reviews" data-toggle="tab">Reviews</a></li>--%>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade" id="Description">
                                <p>${product.description}</p>
                            </div>
                        </div>
                    </div>
                    <c:if test="${item.discount > 0}">
                        <div class="sticker sticker-sale"></div>
                    </c:if>
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