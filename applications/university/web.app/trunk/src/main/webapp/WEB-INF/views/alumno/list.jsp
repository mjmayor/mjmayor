<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://code.google.com/p/jmesa" prefix="jmesa"%>

<html>
	<body>
		<c:set var="tableTitle">
			<spring:message code="student.listTitle"/>
		</c:set>
	
		<c:set var="dni">
			<spring:message code="student.dni"/>
		</c:set>
		
		<c:set var="name">
			<spring:message code="student.name"/>
		</c:set>
		
		<c:set var="dateOfBirth">
			<spring:message code="student.dateOfBirth"/>
		</c:set>
		
		<c:set var="email">
			<spring:message code="student.email"/>
		</c:set>
		
		<jmesa:tableModel id="alumnos" items="${model.alumnos.items}" var="alumno">
	        <jmesa:htmlTable caption="${tableTitle}">               
	            <jmesa:htmlRow>
	                <jmesa:htmlColumn property="dni" title="${dni}"/>
	                <jmesa:htmlColumn property="nombreCompleto" title="${name}"/>
	                <jmesa:htmlColumn property="email" title="${email}"/>
	                <jmesa:htmlColumn property="fechaNacimiento" title="${dateOfBirth}"/>
	            </jmesa:htmlRow>
	        </jmesa:htmlTable> 
	    </jmesa:tableModel>
	</body>
</html>
