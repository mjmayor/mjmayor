<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<h2><spring:message code="subject.dataTitle"/></h2>
		<table>

			<tr>
				<td><spring:message code="subject.cod"/></td>
				<td><c:out value="${model.asignaturaForm.codigo}"/></td>
			</tr>

			<tr>
				<td><spring:message code="subject.name"/></td>
				<td><c:out value="${model.asignaturaForm.nombre}"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="subject.year"/></td>
				<td><c:out value="${model.asignaturaForm.curso}"/></td>
			</tr>
			
			<tr>
				<td><spring:message code="subject.credits"/></td>
				<td><c:out value="${model.asignaturaForm.creditos}"/></td>
			</tr>
			
		</table>
	</body>
</html>