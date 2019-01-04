<%@include file="links_top.jsp" %>
<%@ page session="false"%>

<title>Error | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li class="active">Error</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <div>
            <!-- BEGIN CONTENT -->
            <h1>${errorMsg}</h1>
            <!-- END CONTENT -->
            </div>
        </div>
    </div>

    <%@include file="footer.jsp" %>

    <%@include file="links_bottom.jsp" %>

</body>
<!-- END BODY -->
</html>