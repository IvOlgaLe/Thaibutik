<%@include file="links_top.jsp" %>
<title>${category.name} | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="title-wrapper">
    <div class="container">
        <div class="container-inner">
            <h1><span>${category.name} category</span></h1>
            <em>Over 400 Items are available here</em>
        </div>
    </div>
</div>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li><a href="${contextPath}/catalog">Catalog</a></li>
            <li class="active">${category.name} category</li>
        </ul>

        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-7">
                <form action="${contextPath}/category/${category.id}">
                    <%@include file="search_panel.jsp" %>
                </form>

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
                                    <a href="${contextPath}/product/${product.id}/0?categoryId=${category.id}">${product.name}</a>
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

                <%@include file="bestsellers.jsp" %>
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