<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

	<body>
		<h2><spring:message code="professor.listTitle"/></h2>
		<table>

			<c:forEach var="profesor" items="${model.profesores}">

				<tr>
					<td><spring:message code="professor.dni"/> <c:out value="${profesor.dni}"/></td>
					<td><spring:message code="professor.name"/> <c:out value="${profesor.nombreCompleto}"/></td>
				</tr>
			
			</c:forEach>

		</table>
	</body>
</html>