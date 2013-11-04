<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://code.google.com/p/jmesa" prefix="jmesa"%>

<html>
	<body>
		<c:set var="tableTitle">
			<spring:message code="professor.listTitle"/>
		</c:set>
	
		<c:set var="dni">
			<spring:message code="professor.dni"/>
		</c:set>
		
		<c:set var="name">
			<spring:message code="professor.name"/>
		</c:set>
		
		<jmesa:tableModel id="profesores" items="${model.profesores.items}" var="profesor">
	        <jmesa:htmlTable caption="${tableTitle}">               
	            <jmesa:htmlRow>
	                <jmesa:htmlColumn property="dni" title="${dni}"/>
	                <jmesa:htmlColumn property="nombreCompleto" title="${name}"/>
	            </jmesa:htmlRow>
	        </jmesa:htmlTable> 
	    </jmesa:tableModel>
	</body>
</html>
