<title>User List</title>
<content tag="heading">
	<h1>
		<spring:message code="user.management"/> <small> <i
			class="ace-icon fa fa-angle-double-right"></i> <spring:message code="user.managementDescription"/>
		</small>
	</h1>
</content>
<body>
	<c:set value="${pageContext.response.locale}" var="locale"/>
	<spring:message code="user.statusEnabled" var="statusEnabled"/>
	<spring:message code="user.statusDisabled" var="statusDisabled"/>
	
	<div class="panel panel-default">
		<div class="panel-heading">
			<c:url value="/User/Index" var="formAction"/>
			<form:form commandName="filter" action="${formAction}" method="post" cssClass="form-inline query-form">
				<div class="form-group form-group-sm">
					<label for="userName" class="control-label"><spring:message code="user.userName"/></label>
					<form:input path="userName" cssClass="form-control" />
				</div>
				<div class="form-group form-group-sm">
					<label for="sectorId" class="control-label"><spring:message code="user.sector"/></label>
					<form:select path="sectorId" cssClass="form-control">
						<option value=""></option>
						<c:choose>
							<c:when test="${locale=='zh_CN'}">
								<form:options items="${sectors}" itemLabel="valueCN" itemValue="id" />	
							</c:when>
							<c:otherwise>
								<form:options items="${sectors}" itemLabel="value" itemValue="id" />
							</c:otherwise>
						</c:choose>
					</form:select>
				</div>
				<div class="form-group form-group-sm">
					<label for="officeId" class="control-label"><spring:message code="user.office"/></label>
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
					<label for="status" class="control-label"><spring:message code="user.status"/></label>
					<form:select path="status" cssClass="form-control">
						<option value=""></option>
						<option value="true" label="${statusEnabled}"></option>
						<option value="false" label="${statusDisabled}"></option>
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
				<jsp:include page="/WEB-INF/jsp/User/Partial_UserList.jsp" />
			</div>
		</div>
		<div class="panel-footer text-center">
			<a href="<c:url value="/User/Create"/>" class="btn btn-default btn-sm"><spring:message code="user.create"/></a>
		</div>
	</div>
</body>

<content tag="pageInlineScripts"> 
	<script src="<c:url value="/resource/js/application.js"/>"></script>
	<script type="text/javascript">
		function Search(page) {
			SearchPageData(page, "#queryResult",'<c:url value="/User/Partial_UserList"/>');
		}
	</script>
</content>