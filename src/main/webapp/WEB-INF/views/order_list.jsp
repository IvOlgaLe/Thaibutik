    <%@include file="links_top.jsp"%>
    <title>ThaiButik</title>

    <!--- for slider on the index page -->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
    <link href="/resources/pages/css/slider.css" rel="stylesheet">

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
    <%@include file="header.jsp"%>

    <div class="main">
      <div class="container">
        <ul class="breadcrumb">
          <li><a href="Index">Home</a></li>
          <li><a href="">Store</a></li>
          <li class="active">My Orders</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

          <%@include file="sidebar.jsp"%>

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-7">
            <h1>My Wish List</h1>
            <div class="goods-page">
              <div class="goods-data clearfix">
                <div class="table-wrapper-responsive">
                  <table summary="Shopping cart">
                    <tr>
                      <th class="goods-page-image">Image</th>
                      <th class="goods-page-description">Description</th>
                      <th class="goods-page-stock">Stock</th>
                      <th class="goods-page-price" colspan="2">Unit price</th>
                    </tr>
                    <tr>
                      <td class="goods-page-image">
                        <a href="javascript:;"><img src="/resources/pages/img/products/model3.jpg" alt="Berry Lace Dress"></a>
                      </td>
                      <td class="goods-page-description">
                        <h3><a href="javascript:;">Cool green dress with red bell</a></h3>
                        <p><strong>Item 1</strong> - Color: Green; Size: S</p>
                        <em>More info is here</em>
                      </td>
                      <td class="goods-page-stock">
                        In Stock
                      </td>
                      <td class="goods-page-price">
                        <strong><span>$</span>47.00</strong>
                      </td>
                      <td class="del-goods-col">
                        <a class="del-goods" href="javascript:;">&nbsp;</a>
                        <a class="add-goods" href="javascript:;">&nbsp;</a>
                      </td>
                    </tr>
                    <tr>
                      <td class="goods-page-image">
                        <a href="javascript:;"><img src="/resources/pages/img/products/model4.jpg" alt="Berry Lace Dress"></a>
                      </td>
                      <td class="goods-page-description">
                        <h3><a href="javascript:;">Cool green dress with red bell</a></h3>
                        <p><strong>Item 1</strong> - Color: Green; Size: S</p>
                        <em>More info is here</em>
                      </td>
                      <td class="goods-page-stock">
                        In Stock
                      </td>
                      <td class="goods-page-price">
                        <strong><span>$</span>47.00</strong>
                      </td>
                      <td class="del-goods-col">
                        <a class="del-goods" href="javascript:;">&nbsp;</a>
                        <a class="add-goods" href="javascript:;">&nbsp;</a>
                      </td>
                    </tr>
                  </table>
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