<c:if test="${item.id != 0}" var="isEdit" />
<c:choose>
	<c:when test="${isEdit}">
		<c:set var="title" value="Edit Meeting Room" />
	</c:when>
	<c:otherwise>
		<c:set var="title" value="Create Meeting Room" />
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
				<i class="ace-icon fa fa-angle-double-right"></i> ${item.name}
			</small>
		</c:if>
	</h1>
</content>

<body>

	<c:url value="/MeetingRoom/Edit" var="formAction"/>
	<form:form commandName="meetingRoom" action="${formAction}" method="post">
		<form:errors path="*" element="div" cssClass="validation-summary-errors" />
		<div class="form-horizontal">
			<form:hidden path="id" />
			
			<div class="form-group">
	            <form:label path="name" cssClass="col-md-2 control-label">Name</form:label>
	            <div class="col-md-10">
	            	<form:input path="name" cssClass="form-control required" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="nameCN" cssClass="col-md-2 control-label">NameCN</form:label>
	            <div class="col-md-10">
	            	<form:input path="nameCN" cssClass="form-control required" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="officeId" cssClass="col-md-2 control-label">Office</form:label>
	            <div class="col-md-10">
	            	<form:select path="officeId" cssClass="required" cssErrorClass="error">
						<option value=""></option>
						<form:options items="${offices}" itemLabel="value" itemValue="id" />
					</form:select>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="floor" cssClass="col-md-2 control-label">Floor</form:label>
	            <div class="col-md-10">
	            	<form:input path="floor" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="capacity" cssClass="col-md-2 control-label">Capacity</form:label>
	            <div class="col-md-10">
	            	<form:input path="capacity" cssClass="form-control" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="hasProjector" cssClass="col-md-2 control-label">Has Projector</form:label>
	            <div class="col-md-10">
	            	<form:checkbox path="hasProjector" cssErrorClass="error"/>
	            </div>
	        </div>
	        <div class="form-group">
	            <form:label path="status" cssClass="col-md-2 control-label">Office</form:label>
	            <div class="col-md-10">
					<form:select path="status" items="${meetingRoomStatus}" />
	            </div>
	        </div>
	        <div class="form-group">
	            <div class="col-md-offset-2 col-md-10">
	                <button type="submit" class="btn btn-default btn-sm table-item-link"><span class="icon fa fa-save"></span> Save</button>
	                <a href="<c:url value="/MeetingRoom/" />" class="btn btn-default btn-sm">Return</a>
	            </div>
	        </div>
		</div>
	</form:form>
	
</body>