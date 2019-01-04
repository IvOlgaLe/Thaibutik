<%@include file="links_top.jsp" %>
<title>Search Result | ThaiButik</title>

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
            <li class="active">Search result</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-9 col-sm-7">
                <div class="content-search margin-bottom-20">
                    <div class="row">
                        <div class="col-md-6">
                            <h1>Search result for <em>${searchWord}</em></h1>
                        </div>
                        <div class="col-md-6">
                            <form action="${contextPath}/processSearch">
                                <div class="input-group">
                                    <input type="text" name="name" placeholder="Search again" class="form-control">
                                    <span class="input-group-btn">
                        <button class="btn btn-primary" type="submit">Search</button>
                      </span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <form action="${contextPath}/processSearch">
                    <div class="row list-view-sorting clearfix">
                        <div class="col-md-10 col-sm-10">
                            <div class="pull-left">
                                <label class="control-label">Show&nbsp;by&nbsp;price:</label>
                                <div class="pull-left">
                                    <input name="lowPrice" type="number" tabindex="1"/> -
                                    <input name="highPrice" type="number" tabindex="2"/>
                                </div>
                            </div>
                            <div class="pull-left">
                                <label class="control-label">Sort&nbsp;By:</label>
                                <select name="orderBy" class="form-control input-sm">
                                    <option value="i.price*(1-i.discount/100)" selected="selected">Default</option>
                                    <option value="p.name">Name (A - Z)</option>
                                    <option value="p.name DESC">Name (Z - A)</option>
                                    <option value="i.price*(1-i.discount/100)">Price (Low &gt; High)</option>
                                    <option value="i.price*(1-i.discount/100) DESC">Price (High &gt; Low)</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-10 col-sm-10">
                            <div class="pull-left">
                                <label class="control-label">Type:</label>
                                <input name="itemType" type="text" tabindex="3"/>
                            </div>
                            <div class="pull-left">
                                <label class="control-label">Size:</label>
                                <input name="itemSize" type="text" tabindex="4"/>
                            </div>
                            <div class="pull-left">
                                <input name="name" type="hidden" value="${searchWord}"/>
                                <button class="btn btn-primary" type="submit">Apply</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <!-- BEGIN PRODUCT LIST -->
            <div class="row product-list">
                <c:forEach var="product" items="${productList}">
                    <!-- PRODUCT ITEM START -->
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="${imgPrefix}${product.imageSource}" class="img-responsive"
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