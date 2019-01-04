<%@include file="links_top.jsp" %>
<title>Catalog | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li class="active">Catalog</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

            <%@include file="sidebar.jsp" %>

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-7">
                <div class="content-page">
                    <h3>Catalog</h3>
                    <ul>
                        <c:forEach var="group" items="${groupList}">
                            <li>${group.name}
                                <ul>
                                    <c:forEach var="category" items="${group.categoryList}">
                                        <li><a href="${contextPath}/category/${category.id}">${category.name}</a></li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <%@include file="bestsellers.jsp" %>
            <!-- END CONTENT -->
        </div>
    </div>

    <%@include file="footer.jsp" %>

    <%@include file="links_bottom.jsp" %>

</body>
<!-- END BODY -->
</html>