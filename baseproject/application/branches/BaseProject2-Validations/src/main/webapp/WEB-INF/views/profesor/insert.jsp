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
		<form:form method="post" commandName="profesorForm" action="insert">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>			
				
				<tr>
					<td><spring:message code="professor.name"/></td>
					<td><form:input path="nombre" /></td>
					<form:errors path="nombre" cssClass="error" element="td"/>
				</tr>
				
				<tr>
					<td><spring:message code="professor.lastname"/></td>
					<td><form:input path="apellidos" /></td>
					<form:errors path="apellidos" cssClass="error" element="td"/>
				</tr>
				
				<tr>
					<spring:message code="professor.sendButton" var="sendButton"/>
					<td colspan="3"><input type="submit" value="${sendButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
	</body>
</html>