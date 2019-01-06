<!-- BEGIN SIDEBAR -->
<div class="sidebar col-md-3 col-sm-5">
    <div class="sidebar-products clearfix">
        <h2>Bestsellers</h2>
        <!-- BEGIN PRODUCT LIST -->
        <div class="row product-list">
            <div class="col-md-4 col-sm-6 col-xs-12">
                <c:forEach var="product" items="${bestsellersList}">
                    <!-- PRODUCT ITEM START -->
                    <div class="product-item">
                        <div class="pi-img-wrapper">
                            <img src="${imgPrefix}/products/${product.imageSource}" class="img-responsive"
                                 alt="${product.name}">
                        </div>
                        <h3><a href="${contextPath}/product/${product.id}/0">"${product.name}"</a></h3>
                        <div class="pi-price">$ <fmt:formatNumber type="number" maxFractionDigits="2"
                                                                  value="${product.itemList.get(0).price*(1-product.itemList.get(0).discount/100)}"/></div>
                        <c:if test="${product.itemList.get(0).discount > 0}">
                            <em><span> (was $${product.itemList.get(0).price})</span></em>
                        </c:if>
                    </div>
                    <!-- PRODUCT ITEM END -->
                </c:forEach>
            </div>
        </div>
        <!-- END PRODUCT LIST -->
    </div>
</div>
<!-- END SIDEBAR -->