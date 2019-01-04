<%@include file="links_top.jsp" %>
<title>Log In | Thaibutik</title>
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li><a href="${contextPath}/login">Log In</a></li>
            <li class="active">Password Restore</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN CONTENT -->
            <div class="col-md-12 col-sm-12">
                <h1>Password Restore</h1>
                <!-- BEGIN LOGIN PAGE -->
                <div class="panel-group checkout-page accordion scrollable" id="checkout-page">

                    <!-- BEGIN RESTORE -->
                    <div id="restore" class="panel panel-default">
                        <div class="panel-body row">
                            <div class="col-md-6 col-sm-6">
                                <div class="radio-list">
                                    <form id="restore_form" action="${contextPath}/processPasswordRestore" method="post"
                                          role="form">
                                        <c:if test="${empty temporaryPassword}">
                                            <div class="form-group">
                                                <label for="email_first">Email <span class="require">*</span></label>
                                                <input type="email" name="email" id="email_first" tabindex="1"
                                                       class="form-control" value="${email}"/>
                                            </div>
                                            <c:if test="${!empty errorMessage}">
                                                <p>${errorMessage}</p>
                                            </c:if>
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <button class="btn btn-primary" type="submit">Send temporary
                                                        password
                                                    </button>
                                                </div>
                                            </div>
                                        </c:if>

                                        <c:if test="${!empty temporaryPassword}">
                                            <input type="hidden" name="email" id="email" tabindex="1"
                                                   class="form-control" value="${email}"/>
                                            <input type="hidden" name="temporaryPassword" id="temporaryPassword"
                                                   tabindex="1" class="form-control" value="${temporaryPassword}"/>
                                            <div class="form-group">
                                                <label for="inputTempPassword">Temporary Password <span class="require">*</span></label>
                                                <input type="password" name="inputTempPassword" id="inputTempPassword"
                                                       class="form-control"/>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <button class="btn btn-primary" type="submit">Submit</button>
                                                </div>
                                            </div>
                                        </c:if>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END RESTORE -->

            </div>
            <!-- END LOGIN PAGE -->
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