<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://code.google.com/p/jmesa" prefix="jmesa"%>

<html>
	<body>
		<c:set var="tableTitle">
			<spring:message code="subject.listTitle"/>
		</c:set>
	
		<c:set var="cod">
			<spring:message code="subject.cod"/>
		</c:set>
		
		<c:set var="name">
			<spring:message code="subject.name"/>
		</c:set>
		
		<c:set var="year">
			<spring:message code="subject.year"/>
		</c:set>
		
		<c:set var="credits">
			<spring:message code="subject.credits"/>
		</c:set>
		
		<jmesa:tableModel id="asignaturas" items="${model.asignaturas.items}" var="asignatura">
	        <jmesa:htmlTable caption="${tableTitle}">               
	            <jmesa:htmlRow>
	                <jmesa:htmlColumn property="codigo" title="${cod}"/>
	                <jmesa:htmlColumn property="nombre" title="${name}"/>
	                <jmesa:htmlColumn property="curso" title="${year}"/>
	                <jmesa:htmlColumn property="creditos" title="${credits}"/>
	            </jmesa:htmlRow>
	        </jmesa:htmlTable> 
	    </jmesa:tableModel>
	</body>
</html>
