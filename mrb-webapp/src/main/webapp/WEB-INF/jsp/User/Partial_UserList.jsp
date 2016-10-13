<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set value="${pageContext.response.locale}" var="locale"/>

<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th><spring:message code="user.userName"/></th>
            <th><spring:message code="user.englishName"/></th>
            <th><spring:message code="user.chineseName"/></th>
            <th><spring:message code="user.email"/></th>
            <th><spring:message code="user.telephone"/></th>
            <th><spring:message code="user.mobile"/></th>
            <th><spring:message code="user.sector"/></th>
            <th><spring:message code="user.office"/></th>
            <th><spring:message code="user.status"/></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userName}</td>
                <td>${user.englishName}</td>
                <td>${user.chineseName}</td>
                <td>${user.email}</td>
                <td>${user.telephone}</td>
                <td>${user.mobile}</td>
                <td>
                	<c:choose>
                		<c:when test="${locale == 'zh_CN'}">
                			${user.sector.valueCN}
                		</c:when>
                		<c:otherwise>
                			${user.sector.value}
                		</c:otherwise>
                	</c:choose>
                </td>
                <td>
                	<c:choose>
                		<c:when test="${locale == 'zh_CN' }">
                			${user.office.valueCN}
                		</c:when>
                		<c:otherwise>
                			${user.office.value}
                		</c:otherwise>
                	</c:choose>
                </td>
                <td><input type="checkbox" <c:if test="${user.status}">checked</c:if> disabled="disabled" /></td>
                <td>
                    <a href="<c:url value="/User/Edit/${user.id}"></c:url>" class="table-item-link" title="Edit">
                        <span class="fa fa-lg fa-edit"></span>
                    </a>
                    <a href="<c:url value="/User/Delete/${user.id}"></c:url>"
                       onclick="return confirm('Are you sure to delete this meeting room?');" title="Delete">
                        <span class="fa fa-lg fa-remove"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<my:MvcPaging pagingOption="${pagingOption}" pagingUIOption="${pagingUIOption}" pageUrl="${pageUrl}" /> 
