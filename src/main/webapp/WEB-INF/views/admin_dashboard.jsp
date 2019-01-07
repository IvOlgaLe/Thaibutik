<%@include file="links_top.jsp" %>
<title>Admin Dashboard | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="index">Home</a></li>
            <li class="active">Admin Dashboard</li>
        </ul>
        <!-- BEGIN CONTENT -->
        <div class="row margin-bottom-40">
            <div class="col-md-9 col-sm-7">
                <h1>Hi, ${sessUser.name}</h1>
                <div class="content-page">
                    <h3>Administration menu</h3>
                    <ul>
                        <li><a href="${contextPath}/productTable">Products Table</a></li>
                        <li><a href="${contextPath}/editProduct/0">Add Product</a></li>
                        <li><a href="${contextPath}/orderTable">Orders Table</a></li>
                    </ul>
                    <hr>
                </div>
            </div>
        </div>
        <!-- END CONTENT -->
    </div>
</div>

<%@include file="links_bottom.jsp" %>

</body>
<!-- END BODY -->
</html>