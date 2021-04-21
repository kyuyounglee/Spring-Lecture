<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.search" /> </title>
</head>
<body>
	<form:form modelAttribute="cmd">
		<p>
			<label>from:<form:input path="from"/>  </label>
			<form:errors path="from"  />
			~
			<label>to:<form:input path="to"/>  </label>
			<form:errors path="to"  />
		</p>	
		<input type="submit" value='<spring:message code = "member.btn" />'>
	</form:form>
	<c:if test="${! empty members}">
		<c:forEach var="member" items="${members}" >
			${member.id }
			${member.email }
			${member.name }
			<%-- ${member.registerDateTime } --%>
			<tf:formatDateTime value="${member.registerDateTime }"
				pattern="yyyy-MM-dd"	/>							
			<br>
		</c:forEach>
	</c:if>
</body>
</html>