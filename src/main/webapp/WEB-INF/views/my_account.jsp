<%@include file="links_top.jsp"%>
<title>My account | ThaiButik</title>

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
            <li class="active">My Account Page</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

          <%@include file="sidebar.jsp"%>

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-7">
            <h1>Hi, ${sessUser.name}</h1>
            <div class="content-page">
              <h3>My Account</h3>
              <ul>
                <li><a href="ProfileForm">Edit My Account Information</a></li>
                <li><a href="ProfilePassword">Change My Password</a></li>
                <li><a href="WishList">Modify My Wish List</a></li>
              </ul>
              <hr>

              <h3>My Orders</h3>
              <ul>
                <li><a href="OrderList">View My Order History</a></li>
              </ul>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>

    <%@include file="footer.jsp"%>

    <%@include file="links_bottom.jsp"%>

</body>
<!-- END BODY -->
</html>