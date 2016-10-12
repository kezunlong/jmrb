
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

	<div class="navbar-container" id="navbar-container">
		<!-- #section:basics/sidebar.mobile.toggle -->
		<button type="button" class="navbar-toggle menu-toggler pull-left"
			id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<!-- /section:basics/sidebar.mobile.toggle -->
		<div class="navbar-header pull-left">
			<!-- #section:basics/navbar.layout.brand -->
			<a href="#" class="navbar-brand"> <small> <spring:message code="application.name" />
			</small>
			</a>

			<!-- /section:basics/navbar.layout.brand -->
			<!-- #section:basics/navbar.toggle -->
			<!-- /section:basics/navbar.toggle -->
		</div>

		<!-- #section:basics/navbar.dropdown -->
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<c:set value="${pageContext.response.locale}" var="locale"/>
				<li class="purple">
					<a href="?locale=en">
						English
						<c:if test="${locale=='en'}">
							<span class="ace-icon fa fa-check"></span>
						</c:if>
					</a>
				</li>
				<li class="green">
					<a href="?locale=zh_CN">
						中文
						<c:if test="${locale=='zh_CN'}">
							<span class="ace-icon fa fa-check"></span>
						</c:if>
				</a></li>
				<!-- #section:basics/navbar.user_menu -->
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<span class="user-info"><small>Welcome,</small>
							UserName </span>
						<i class="ace-icon fa fa-caret-down"></i> 
					</a>

					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
						<li>
							<a href="<c:url value="/User/Profile"/>"> 
								<i class="ace-icon fa fa-user"></i> <spring:message code="user.profile" />
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>

	</div>
	<!-- /.navbar-container -->
</div>