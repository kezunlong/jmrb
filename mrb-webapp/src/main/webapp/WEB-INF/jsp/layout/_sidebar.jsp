			<div id="sidebar" class="sidebar h-sidebar navbar-collapse collapse">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>
						<span class="btn btn-info"></span>
						<span class="btn btn-warning"></span>
						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="hover">
						<a href="<c:url value="/" />">
							<i class="menu-icon fa fa-home"></i>
							<span class="menu-text"> <spring:message code="menu.homePage"/> </span>
						</a>

						<b class="arrow"></b>
					</li>

					<li class="hover">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text"> <spring:message code="menu.reservation"/> </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="hover">
								<a href="<c:url value="/Reservation/Index" />">
									<i class="menu-icon fa fa-caret-right"></i>
									<spring:message code="menu.roomReservation"/>
								</a>

								<b class="arrow"></b>
							</li>

							<li class="hover">
								<a href="<c:url value="/MeetingRoom/Layout" />">
									<i class="menu-icon fa fa-caret-right"></i>
									<spring:message code="menu.roomLayout"/>
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="hover">
								<a href="<c:url value="/Reservation/MyReservation" />">
									<i class="menu-icon fa fa-caret-right"></i>
									<spring:message code="menu.myReservation"/>
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>

					<li class="hover">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-cog"></i>
							<span class="menu-text"><spring:message code="menu.systemSetting"/></span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="hover">
								<a href="<c:url value="/MeetingRoom/Index" />">
									<i class="menu-icon fa fa-caret-right"></i>
									<spring:message code="menu.roomManagement"/>
								</a>

								<b class="arrow"></b>
							</li>

							<li class="hover">
								<a href="<c:url value="/User/Index" />">
									<i class="menu-icon fa fa-caret-right"></i>
									<spring:message code="menu.userManagement"/>
								</a>

								<b class="arrow"></b>
							</li>

							<li class="hover">
								<a href="<c:url value="/SystemLog/Index" />">
									<i class="menu-icon fa fa-caret-right"></i>
									<spring:message code="menu.systemLogs"/>
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>

				</ul><!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					//try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>