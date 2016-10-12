<c:if test="${user.id != 0}" var="isEdit" />
<c:choose>
	<c:when test="${isEdit}">
		<spring:message code="user.edit" var="title" />
	</c:when>
	<c:otherwise>
		<spring:message code="user.create" var="title" />
	</c:otherwise>
</c:choose>

<title>
	${title}
</title>

<content tag="heading">
	<h1>
		${title}
		<c:if test="${isEdit}">
			<small> 
				<i class="ace-icon fa fa-angle-double-right"></i> ${user.userName}
			</small>
		</c:if>
	</h1>
</content>

<body>

	<c:url value="/User/Edit" var="formAction"/>
	<form:form commandName="user" action="${formAction}" method="post">
		<form:errors path="*" element="div" cssClass="validation-summary-errors" />
		<div class="form-horizontal">
			<form:hidden path="id" />
			
			<div class="form-group">
	            <form:label path="userName" cssClass="col-md-2 control-label"><spring:message code="user.userName"/></form:label>
	            <div class="col-md-10">
	            	<form:input path="userName" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="englishName" cssClass="col-md-2 control-label"><spring:message code="user.englishName"/></form:label>
	            <div class="col-md-10">
	            	<form:input path="englishName" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="chineseName" cssClass="col-md-2 control-label"><spring:message code="user.chineseName"/></form:label>
	            <div class="col-md-10">
	            	<form:input path="chineseName" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="email" cssClass="col-md-2 control-label"><spring:message code="user.email"/></form:label>
	            <div class="col-md-10">
	            	<form:input path="email" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="telephone" cssClass="col-md-2 control-label"><spring:message code="user.telephone"/></form:label>
	            <div class="col-md-10">
	            	<form:input path="telephone" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="mobile" cssClass="col-md-2 control-label"><spring:message code="user.mobile"/></form:label>
	            <div class="col-md-10">
	            	<form:input path="mobile" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="sectorId" cssClass="col-md-2 control-label"><spring:message code="user.sector"/></form:label>
	            <div class="col-md-10">
	            	<form:select path="sectorId">
						<option value=""></option>
						<form:options items="${sectors}" itemLabel="value" itemValue="id" />
					</form:select>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="officeId" cssClass="col-md-2 control-label"><spring:message code="user.office"/></form:label>
	            <div class="col-md-10">
	            	<form:select path="officeId">
						<option value=""></option>
						<form:options items="${offices}" itemLabel="value" itemValue="id" />
					</form:select>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="address" cssClass="col-md-2 control-label"><spring:message code="user.address"/></form:label>
	            <div class="col-md-10">
	            	<form:input path="address" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="status" cssClass="col-md-2 control-label"><spring:message code="user.status"/></form:label>
	            <div class="col-md-10">
	            	<form:checkbox path="status" cssErrorClass="error"/>
	            </div>
	        </div>
			<div class="form-group">
	            <div class="col-md-offset-2 col-md-10">
	                <button type="submit" class="btn btn-default btn-sm table-item-link"><span class="icon fa fa-save"></span> <spring:message code="button.save"/></button>
	                <a href="<c:url value="/User/" />" class="btn btn-default btn-sm"><spring:message code="button.return"/></a>
	            </div>
	        </div>
		</div>
	</form:form>
	
</body>