<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<h2><spring:message code="student.dataTitle"/></h2>
		<table>

			<tr>
				<td><spring:message code="student.dni"/></td>
				<td><c:out value="${model.alumnoForm.dni}"/></td>
			</tr>

			<tr>
				<td><spring:message code="student.name"/></td>
				<td><c:out value="${model.alumnoForm.nombreCompleto}"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="student.email"/></td>
				<td><c:out value="${model.alumnoForm.email}"/></td>
			</tr>
			
		</table>
	</body>
</html>