<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set value="${pageContext.response.locale}" var="locale"/>

<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>Name</th>
            <th>NameCN</th>
            <th>OFFICE</th>
            <th>FLOOR</th>
            <th>CAPACITY</th>
            <th>HAS_PROJECTOR</th>
            <th>STATUS</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${meetingRooms}" var="meetingRoom">
            <tr>
                <td>${meetingRoom.name}</td>
                <td>${meetingRoom.nameCN}</td>
                <td>
                	<c:choose>
						<c:when test="${locale=='zh_CN'}">
							${meetingRoom.office.valueCN}
						</c:when>
						<c:otherwise>
							${meetingRoom.office.value}
						</c:otherwise>
					</c:choose>
				</td>
                <td>${meetingRoom.floor}</td>
                <td>${meetingRoom.capacity}</td>
                <td><input type="checkbox" <c:if test="${meetingRoom.hasProjector}">checked</c:if> disabled="disabled" /></td>
                <td>${meetingRoom.status}</td>
                <td>
                    <a href="<c:url value="/MeetingRoom/Edit/${meetingRoom.id}"></c:url>" class="table-item-link" title="Edit">
                        <span class="fa fa-lg fa-edit"></span>
                    </a>
                    <a href="<c:url value="/MeetingRoom/Delete/${meetingRoom.id}"></c:url>"
                       onclick="return confirm('Are you sure to delete this meeting room?');" title="Delete">
                        <span class="fa fa-lg fa-remove"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<my:MvcPaging pagingOption="${pagingOption}" pagingUIOption="${pagingUIOption}" pageUrl="${pageUrl}" /> 
<!-- @Html.AjaxPagination(Model.PagingOption) -->