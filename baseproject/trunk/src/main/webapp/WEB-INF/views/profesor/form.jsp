<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
		<style>
			.error {
			    color: #FF0000;
			    display: block;
			    padding-left: 30px;
			    display: inline-table;
			}
			
			.errorblock {
				color: #000;
				background-color: #ffEEEE;
				border: 3px solid #ff0000;
				padding: 8px;
				margin: 16px;
			}
		</style>
	</head>

	<body>
		<h2><spring:message code="professor.formTitle"/></h2>
		<form:form method="POST" commandName="profesorForm" action="insert">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				
				<tr>
					<td><spring:message code="professor.dni"/></td>
					<td><form:input path="dni" /></td>
					<td class="error"><form:errors path="dni" /></td>
				</tr>			
				
				<tr>
					<td><spring:message code="professor.name"/></td>
					<td><form:input path="nombre" /></td>
					<td class="error"><form:errors path="nombre" /></td>
				</tr>
				
				<tr>
					<td><spring:message code="professor.lastname"/></td>
					<td><form:input path="apellidos" /></td>
					<td class="error"><form:errors path="apellidos" /></td>
				</tr>
				
				<tr>
					<spring:message code="professor.sendButton" var="sendButton"/>
					<td colspan="3"><input type="submit" value="${sendButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		<h2><spring:message code="professor.deleteTitle"/></h2>
		<form:form method="POST" commandName="profesorForm" action="delete">
			<table>			
				
				<tr>
					<td><spring:message code="professor.dni"/></td>
					<td><form:input path="dni" /></td>
					<td class="error"><form:errors path="dni" /></td>
				</tr>
				
				<tr>
					<spring:message code="professor.deleteButton" var="deleteButton"/>
					<td colspan="3"><input type="submit" value="${deleteButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		
		<h2><spring:message code="professor.dataTitle"/></h2>
		<form:form method="POST" commandName="profesorForm" action="get">
			<table>			
				
				<tr>
					<td><spring:message code="professor.dni"/></td>
					<td><form:input path="dni" /></td>
					<td class="error"><form:errors path="dni" /></td>
				</tr>
				
				<tr>
					<spring:message code="professor.viewButton" var="viewButton"/>
					<td colspan="3"><input type="submit" value="${viewButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		<form:form method="POST" commandName="profesores" action="getAll">
			<table>
				<tr>
					<spring:message code="professor.viewAllButton" var="viewAllButton"/>
					<td colspan="3"><input type="submit" value="${viewAllButton}" /></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>