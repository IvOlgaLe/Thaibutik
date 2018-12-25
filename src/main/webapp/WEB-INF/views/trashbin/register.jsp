<%@include file="../links_top.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="login">Login</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form id="register-form" action="processRegister" method="post" role="form" modelAttribute="user">
									<div class="form-group">
										<form:input type="email" path="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value=""/>
										<form:errors path="email" />
									</div>
									<div class="form-group">
										<form:input type="text" path="name" id="name" tabindex="1" class="form-control" placeholder="Username" value=""/>
										<form:errors path="name" />
									</div>
									<div class="form-group">
										<form:input type="password" path="password" id="password" tabindex="2" class="form-control" placeholder="Password"/>
										<form:errors path="password" />
									</div>
									<div class="form-group">
										<form:input type="password" path="confirmedPassword" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password"/>
										<form:errors path="confirmedPassword" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form:form>
								<%--<h2><%=request.getAttribute("message") %></h2>--%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>