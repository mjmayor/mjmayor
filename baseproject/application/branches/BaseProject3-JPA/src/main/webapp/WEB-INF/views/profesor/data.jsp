<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<h2><spring:message code="professor.dataTitle"/></h2>
		<table>

			<tr>
				<td><spring:message code="professor.dni"/></td>
				<td><c:out value="${model.profesorForm.dni}"/></td>
			</tr>

			<tr>
				<td><spring:message code="professor.name"/></td>
				<td><c:out value="${model.profesorForm.nombreCompleto}"/></td>
			</tr>
			
		</table>
	</body>
</html>