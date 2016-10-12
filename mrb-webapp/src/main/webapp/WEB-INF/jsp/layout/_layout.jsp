<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title><sitemesh:write property='title'/> - <spring:message code="application.name"/></title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css" />" />
		<link rel="stylesheet" href="<c:url value="/assets/css/font-awesome.css" />" />

		<!-- page specific plugin styles -->
		<sitemesh:write property="page.pagePluginStyles"/>
		<link rel="stylesheet" href="<c:url value="/resource/css/site.css" />" />
		
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

		<!-- inline styles related to this page -->
		<sitemesh:write property="page.pageInlineStyles"/>

		<!-- ace settings handler -->
		<script src="<c:url value="/assets/js/ace-extra.js" />"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="<c:url value="/assets/js/html5shiv.js" />"></script>
		<script src="<c:url value="/assets/js/respond.js" />"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		<jsp:include page="_navbar.jsp" />

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar.horizontal -->
			<jsp:include page="_sidebar.jsp" />	

			<!-- /section:basics/sidebar.horizontal -->
			<div class="main-content">
				<div class="main-content-inner">
					<div class="page-content">
						<!-- #section:settings.box -->
						<jsp:include page="_settings.jsp" />						
						
						<!-- /section:settings.box -->
						<div class="page-header">
							<sitemesh:write property='page.heading'/>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							
								<sitemesh:write property='body'/>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<jsp:include page="_footer.jsp" />

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<c:url value="/assets/js/jquery.js" />'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 	window.jQuery || document.write("<script src='<c:url value="/assets/js/jquery1x.js" />'>"+"<"+"/script>");
		</script>
		<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='<c:url value="/assets/js/jquery.mobile.custom.js" />'>"+"<"+"/script>");
		</script>
		<script src="<c:url value="/assets/js/bootstrap.js" />"></script>

		<!-- page specific plugin scripts -->
		<sitemesh:write property="page.pagePluginScripts"/>
		
		<script type="text/javascript">
    		$(document).ready(function () {
        		var linkCtrl = $("#sidebar a[href='${actionURL}']");
        		$(linkCtrl).parent("li").addClass("active");
        		var openCtrl = $(linkCtrl).closest("ul[class='submenu']").parent("li").addClass("active open");;
    		})
    	</script>

		<!-- ace scripts -->
		<script src="<c:url value="/assets/js/ace/elements.scroller.js" />"></script>
		<script src="<c:url value="/assets/js/ace/elements.colorpicker.js" />"></script>
		<script src="<c:url value="/assets/js/ace/elements.fileinput.js" />"></script>
		<script src="<c:url value="/assets/js/ace/elements.typeahead.js" />"></script>
		<script src="<c:url value="/assets/js/ace/elements.wysiwyg.js" />"></script>
		<script src="<c:url value="/assets/js/ace/elements.spinner.js" />"></script>
		<script src="<c:url value="/assets/js/ace/elements.treeview.js" />"></script>
		<script src="<c:url value="/assets/js/ace/elements.wizard.js" />"></script>
		<script src="<c:url value="/assets/js/ace/elements.aside.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.ajax-content.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.touch-drag.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.sidebar.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.sidebar-scroll-1.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.submenu-hover.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.widget-box.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.settings.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.settings-rtl.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.settings-skin.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.widget-on-reload.js" />"></script>
		<script src="<c:url value="/assets/js/ace/ace.searchbox-autocomplete.js" />"></script>

		<!-- inline scripts related to this page -->
		<sitemesh:write property="page.pageInlineScripts"/>
		

	</body>
</html>
