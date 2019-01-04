<%@include file="links_top.jsp" %>
<title>Profile | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
<%@include file="header.jsp" %>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${contextPath}/index">Home</a></li>
            <li><a href="${contextPath}/myAccount">My Account</a></li>
            <li class="active">Profile Info</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

            <%@include file="sidebar.jsp" %>

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-7">
                <h1>Profile Info</h1>
                <div class="content-form-page">
                    <form:form role="form" action="${contextPath}/processModify"
                               class="form-horizontal form-without-legend" modelAttribute="user">
                        <form:input type="hidden" path="id" class="form-control" value="${sessUser.id}"/>
                        <form:input type="hidden" path="roleId" class="form-control" value="${sessUser.roleId}"/>
                        <form:input type="hidden" path="password" id="password" class="form-control"
                                    value="${sessUser.password}"/>
                        <form:input type="hidden" path="confirmedPassword" id="confirmedPassword" class="form-control"
                                    value="${sessUser.password}"/>
                        <div class="form-group">
                            <label class="col-lg-2 control-label" for="name">User Name <span
                                    class="require">*</span></label>
                            <div class="col-lg-8">
                                <form:input type="text" path="name" id="name" class="form-control"
                                            value="${sessUser.name}"/>
                                <form:errors path="name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label" for="email">Email <span
                                    class="require">*</span></label>
                            <div class="col-lg-8">
                                <form:input type="text" path="email" id="email" class="form-control"
                                            value="${sessUser.email}"/>
                                <form:errors path="email"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label" for="address">Address</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="address" id="address" class="form-control"
                                            value="${sessUser.address}"/>
                                <form:errors path="address"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label" for="phone">Phone number</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="phone" id="phone" class="form-control"
                                            value="${sessUser.phone}"/>
                                <form:errors path="phone"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label" for="birthday">Birthday</label>
                            <div class="col-lg-8">
                                <form:input type="date" path="birthday" id="birthday" class="form-control"
                                            value="${sessUser.birthday}"/>
                                <form:errors path="birthday"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 col-md-offset-2 padding-left-0 padding-top-20">
                                <button class="btn btn-primary" type="submit">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
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