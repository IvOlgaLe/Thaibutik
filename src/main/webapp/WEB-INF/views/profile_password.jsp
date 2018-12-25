  <%@include file="links_top.jsp"%>
  <title>Profile | ThaiButik</title>

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
  <%@include file="header.jsp"%>
    
    <div class="main">
      <div class="container">
        <ul class="breadcrumb">
            <li><a href="Index">Home</a></li>
            <li><a href="MyAccount">My Account</a></li>
            <li class="active">Change Password</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

          <%@include file="sidebar.jsp"%>

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-7">
            <h1>Profile Info</h1>
            <div class="content-form-page">
              <form:form role="form" action="processModifyPassword" class="form-horizontal form-without-legend" modelAttribute="user">
                <form:input type="hidden" path="id" class="form-control" value="${sessUser.id}"/>
                <form:input type="hidden" path="name" id="name" class="form-control" value="${sessUser.name}"/>
                <form:input type="hidden" path="email" id="email" class="form-control" value="${sessUser.email}" />
                <form:input type="hidden" path="roleId" class="form-control" value="${sessUser.roleId}"/>
                <form:input type="hidden" path="address" id="address" class="form-control" value="${sessUser.address}" />
                <form:input type="hidden" path="phone" id="phone" class="form-control" value="${sessUser.phone}" />
                <form:input type="hidden" path="birthday" id="birthday" class="form-control" value="${sessUser.birthday}" />
                <input type="hidden" name="temporaryPassword" class="form-control" value="${temporaryPassword}" />

                <div class="form-group">
                  <label class="col-lg-2 control-label" for="inputPassword">Old / Temporary Password <span class="require">*</span></label>
                  <div class="col-lg-8">
                    <input type="password" name="inputPassword" id="inputPassword" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                 <label class="col-lg-2 control-label" for="password">New Password <span class="require">*</span></label>
                  <div class="col-lg-8">
                    <form:input type="password" path="password" id="password" class="form-control"/>
                    <form:errors path="password" />
                  </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label" for="confirmedPassword">Confirm New Password <span class="require">*</span></label>
                    <div class="col-lg-8">
                      <form:input type="password" path="confirmedPassword" id="confirmedPassword" class="form-control" />
                      <form:errors path="confirmedPassword" />
                    </div>
                </div>
                <c:if test="${!empty errorMessage}">
                  <p>${errorMessage}</p>
                </c:if>
                <div class="row">
                  <div class="col-lg-8 col-md-offset-2 padding-left-0 padding-top-20">
                    <button class="btn btn-primary" type="submit">Save</button>
                  </div>
                </div>
              </form:form>
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