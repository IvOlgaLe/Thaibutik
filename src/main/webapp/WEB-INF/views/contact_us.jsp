<%@include file="links_top.jsp" %>

<title>Contact | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li class="active">Contact</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

            <%@include file="sidebar.jsp" %>

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-9">
                <h1>Contact</h1>
                <div class="content-page">
                    <h2>Contact Form</h2>
                    <p>Lorem ipsum dolor sit amet, Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper
                        suscipit lobortis nisl ut aliquip ex ea commodo consequat consectetuer adipiscing elit, sed diam
                        nonummy nibh euismod tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
                        consequat.</p>

                    <!-- BEGIN FORM-->
                    <form action="${contextPath}/index" class="default-form" role="form">  <%--TODO email sending--%>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name">
                        </div>
                        <div class="form-group">
                            <label for="email">Email <span class="require">*</span></label>
                            <input type="text" class="form-control" id="email">
                        </div>
                        <div class="form-group">
                            <label for="message">Message</label>
                            <textarea class="form-control" rows="8" id="message"></textarea>
                        </div>
                        <div class="padding-top-20">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>
                    <!-- END FORM-->
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

<%@include file="footer.jsp" %>

<%@include file="links_bottom.jsp" %>
</body>
<!-- END BODY -->
</html>