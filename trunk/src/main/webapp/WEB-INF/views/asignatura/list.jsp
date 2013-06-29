<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<body>
		<h2><spring:message code="subject.listTitle"/></h2>
		<table>

			<c:forEach var="asignatura" items="${model.asignaturas}">

				<tr>
					<td><spring:message code="subject.cod"/> <c:out value="${asignatura.codigo}"/></td>
					<td><spring:message code="subject.name"/> <c:out value="${asignatura.nombre}"/></td>
					<td><spring:message code="subject.year"/> <c:out value="${asignatura.curso}"/></td>
					<td><spring:message code="subject.credits"/> <c:out value="${asignatura.creditos}"/></td>
				</tr>
			
			</c:forEach>

		</table>
	</body>
</html>