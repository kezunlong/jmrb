<title>Meeting Room List</title>
<content tag="heading">
	<h1>
		<spring:message code="meetingroom.management"/> <small> <i
			class="ace-icon fa fa-angle-double-right"></i> <spring:message code="meetingroom.managementDescription"/>
		</small>
	</h1>
</content>
<body>
	<c:set value="${pageContext.response.locale}" var="locale"/>
	
	<div class="panel panel-default">
		<div class="panel-heading">
			<c:url value="/MeetingRoom/Index" var="formAction"/>
			<form:form commandName="filter" action="${formAction}" method="post" cssClass="form-inline query-form">
				<div class="form-group form-group-sm">
					<label for="officeId" class="control-label">Office</label>
					<form:select path="officeId" cssClass="form-control">
						<option value=""></option>
						<c:choose>
							<c:when test="${locale=='zh_CN'}">
								<form:options items="${offices}" itemLabel="valueCN" itemValue="id" />	
							</c:when>
							<c:otherwise>
								<form:options items="${offices}" itemLabel="value" itemValue="id" />
							</c:otherwise>
						</c:choose>
					</form:select>
				</div>
				<div class="form-group form-group-sm">
					<label for="floor" class="control-label">Floor</label>
					<form:input path="floor" cssClass="form-control" />
				</div>
				<div class="form-group form-group-sm">
					<label for="name" class="control-label">Name</label>
					<form:input path="name" cssClass="form-control" />
				</div>
				<div class="form-group form-group-sm">
					<label for="status" class="control-label">Status</label>
					<form:select path="status" cssClass="form-control">
						<option value=""></option>
						<form:options items="${meetingRoomStatus}"/>
					</form:select>
				</div>
				<div class="form-group form-group-sm">
					<button type="submit" class="btn btn-primary btn-sm">
						<span class="icon fa fa-search"></span> Search
					</button>
				</div>				
			</form:form>
		</div>
		<div class="panel-body">
			<div id="queryResult" class="table-responsive">
				<!-- @Html.Action("DocumentList", Model.Filter) -->
				<c:set value="/MeetingRoom/MeetingRoomList" var="listPage"/>
				<jsp:include page="/WEB-INF/jsp/MeetingRoom/Partial_MeetingRoomList.jsp" />
			</div>
		</div>
		<div class="panel-footer text-center">
			<a href="<c:url value="/MeetingRoom/Create"/>" class="btn btn-default btn-sm">Create MeetingRoom</a>
		</div>
	</div>
</body>

<content tag="pageInlineScripts"> 
	<script src="<c:url value="/resource/js/application.js"/>"></script>
	<script type="text/javascript">
		function Search(page) {
			SearchPageData(page, "#queryResult",'<c:url value="/MeetingRoom/Partial_MeetingRoomList"/>');
		}
	</script>
</content>