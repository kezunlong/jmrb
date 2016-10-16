<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title><spring:message code="login.title" /> - <spring:message code="application.name" /></title>

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css" />" />
<link rel="stylesheet" href="<c:url value="/assets/css/font-awesome.css" />" />

<!-- text fonts -->
<link rel="stylesheet" href="<c:url value="/assets/css/ace-fonts.css" />" />

<!-- ace styles -->
<link rel="stylesheet" href="<c:url value="/assets/css/ace.css" />" class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
	<link rel="stylesheet" href="<c:url value="/assets/css/ace-part2.css" />" class="ace-main-stylesheet" />
<![endif]-->

<!--[if lte IE 9]>
	<link rel="stylesheet" href="<c:url value="/assets/css/ace-ie.css" />" />
<![endif]-->

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
<!--[if lte IE 8]>
	<script src="<c:url value="/assets/js/html5shiv.js" />"></script>
	<script src="<c:url value="/assets/js/respond.js" />"></script>
<![endif]-->
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="space-30"></div>
						<div class="center">
							<h1>
								<span class="red"><spring:message code="application.abbreName" /></span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; Ingersoll Rand</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<c:url value="/Login" var="formAction"/>
							<form:form commandName="userLogin" action="${formAction}" method="post">
								<form:errors path="*" element="div" cssClass="validation-summary-errors" />
								<div id="login-box"
									class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger"><spring:message code="login.title" /></h4>
											<div class="space-6"></div>
											
											<fieldset>
												<label class="block clearfix"> 
													<span class="block input-icon input-icon-right">
														<form:input path="userName" cssClass="form-control required" cssErrorClass="error"/> 
														<i class="ace-icon fa fa-user"></i>
													</span>
												</label>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<form:input path="password" cssClass="form-control required" cssErrorClass="error"/>
														<i class="ace-icon fa fa-lock"></i>
													</span>
												</label>
	
												<div class="space"></div>
	
												<div class="clearfix">
	
													<label class="inline">
														<form:checkbox path="rememberMe"/>
														<span class="lbl"><spring:message code="login.rememberMe"/></span>
													</label>
	
													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span class="bigger-110"><spring:message code="login.login"/></span>
													</button>
												</div>
	
												<div class="space-4"></div>
											</fieldset>
	
	
										</div>
										<!-- /.widget-main -->
	
										<div class="toolbar clearfix">
											<div>
												<a href='<c:url value="/Account/ForgotPassword"/>'
													class="forgot-password-link"> <i
													class="ace-icon fa fa-arrow-left"></i>
													<spring:message code="login.forgotPassword"/>
												</a>
											</div>
										</div>
									</div>
									<!-- /.widget-body -->
								</div>
								<!-- /.login-box -->
							</form:form>
						</div>
						<!-- /.position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container -->
	<!-- basic scripts -->
	<!--[if !IE]> -->
	<script src="<c:url value="/assets/js/jquery.js" />"></script>
	<!-- <![endif]-->
	<!--[if IE]>
    <script type="text/javascript">
     window.jQuery || document.write("<script src='<c:url value="/assets/js/jquery1x.js" />'>"+"<"+"/script>");
    </script>
    <![endif]-->
	<script type="text/javascript">
			if('ontouchstart' in document.documentElement)
				document.write("<script src='<c:url value="/assets/js/jquery.mobile.custom.js" />'>"+"<"+"/script>");
    </script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});

    </script>
</body>
</html>
