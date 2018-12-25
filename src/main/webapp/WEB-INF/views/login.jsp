  <%@include file="links_top.jsp"%>
  <title>Log In | Thaibutik</title>
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
  <%@include file="header.jsp"%>

    <div class="main">
      <div class="container">
        <ul class="breadcrumb">
            <li><a href="Index">Home</a></li>
            <li><a href="Index">Store</a></li>
            <li class="active">Log In</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
          <!-- BEGIN CONTENT -->
          <div class="col-md-12 col-sm-12">
            <h1>Log In</h1>
            <!-- BEGIN LOGIN PAGE -->
            <div class="panel-group checkout-page accordion scrollable" id="checkout-page">


              <div id="login" class="panel panel-default">
                  <div class="panel-body row">
                    <!-- BEGIN LOGIN -->
                    <div class="col-md-6 col-sm-6">
                      <h3>Returning Customer</h3>
                      <div class="radio-list">
                      <form id="login_form" action="processLogin" method="post" role="form">
                        <div class="form-group">
                          <label for="email_login">Email <span class="require">*</span></label>
                          <input type="email" name="email" id="email_login" tabindex="1" class="form-control" value="${email}"/>
                        </div>
                        <div class="form-group">
                          <label for="password_login">Password <span class="require">*</span></label>
                          <input type="password" name="password" id="password_login" tabindex="2" class="form-control"/>
                        </div>
                        <a href="PasswordRestore">Forgotten Password?</a>
                        <div class="form-group text-center">
                          <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                          <label for="remember"> Remember Me</label>
                        </div>
                        <c:if test="${!empty errorMessage}">
                          <p>${errorMessage}</p>
                        </c:if>
                        <div class="padding-top-20">
                          <button class="btn btn-primary" type="submit">Login</button>
                        </div>
                        <hr>
                      </form>
                      </div>
                    </div>
                    <!-- END LOGIN -->
                    <!-- BEGIN REGISTER -->
                    <div class="col-md-6 col-sm-6">
                      <h3>New Customer</h3>
                      <div class="radio-list">
                        <form:form id="register_form" action="processRegister" method="post" role="form" modelAttribute="user">
                          <div class="form-group">
                            <label for="email_register">Email <span class="require">*</span></label>
                            <form:input type="email" path="email" id="email_register" tabindex="4" class="form-control"/>
                            <form:errors path="email" />
                          </div>
                          <div class="form-group">
                            <label for="name_register">Name <span class="require">*</span></label>
                            <form:input type="text" path="name" id="name_register" tabindex="5" class="form-control"/>
                            <form:errors path="name" />
                          </div>
                          <div class="form-group">
                            <label for="password_register">Password <span class="require">*</span></label>
                            <form:input type="password" path="password" id="password_register" tabindex="6" class="form-control"/>
                            <form:errors path="password" />
                          </div>
                          <div class="form-group">
                            <label for="confirm_password">Confirm Password <span class="require">*</span></label>
                            <form:input type="password" path="confirmedPassword" id="confirm_password" tabindex="7" class="form-control"/>
                            <form:errors path="confirmedPassword" />
                          </div>
                          <div class="form-group">
                            <div class="row">
                              <div class="col-sm-6 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">Submit</button>
                              </div>
                            </div>
                          </div>
                        </form:form>
                      </div>
                    </div>
                    <!-- END REGISTER -->
                </div>
              </div>

              
            </div>
            <!-- END LOGIN PAGE -->
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