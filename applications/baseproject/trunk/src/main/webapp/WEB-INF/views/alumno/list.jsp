<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<body>
		<h2><spring:message code="student.listTitle"/></h2>
		<table>

			<c:forEach var="alumno" items="${model.alumnos}">

				<tr>
					<td><spring:message code="student.dni"/> <c:out value="${alumno.dni}"/></td>
					<td><spring:message code="student.name"/> <c:out value="${alumno.nombreCompleto}"/></td>
					<td><spring:message code="student.email"/> <c:out value="${alumno.email}"/></td>
				</tr>
			
			</c:forEach>

		</table>
	</body>
</html>