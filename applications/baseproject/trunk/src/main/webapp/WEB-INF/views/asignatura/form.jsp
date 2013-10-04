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
		<h2><spring:message code="subject.formTitle"/></h2>
		<form:form method="POST" commandName="asignaturaForm" action="insert">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				
				<tr>
					<td><spring:message code="subject.cod"/></td>
					<td><form:input path="codigo" /></td>
					<td class="error"><form:errors path="codigo" /></td>
				</tr>			
				
				<tr>
					<td><spring:message code="subject.name"/></td>
					<td><form:input path="nombre" /></td>
					<td class="error"><form:errors path="nombre" /></td>
				</tr>
				
				<tr>
					<td><spring:message code="subject.year"/></td>
					<td><form:input path="curso" /></td>
					<td class="error"><form:errors path="curso" /></td>
				</tr>
				
				<tr>
					<td><spring:message code="subject.credits"/></td>
					<td><form:input path="creditos" /></td>
					<td class="error"><form:errors path="creditos" /></td>
				</tr>
				
				<tr>
					<spring:message code="subject.sendButton" var="sendButton"/>
					<td colspan="3"><input type="submit" value="${sendButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		<h2><spring:message code="subject.deleteTitle"/></h2>
		<form:form method="POST" commandName="asignaturaForm" action="delete">
			<table>			
				
				<tr>
					<td><spring:message code="subject.cod"/></td>
					<td><form:input path="codigo" /></td>
					<td class="error"><form:errors path="codigo" /></td>
				</tr>
				
				<tr>
					<spring:message code="subject.deleteButton" var="deleteButton"/>
					<td colspan="3"><input type="submit" value="${deleteButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		
		<h2><spring:message code="subject.dataTitleByCod"/></h2>
		<form:form method="POST" commandName="asignaturaForm" action="getByCod">
			<table>			
				
				<tr>
					<td><spring:message code="subject.cod"/></td>
					<td><form:input path="codigo" /></td>
					<td class="error"><form:errors path="codigo" /></td>
				</tr>
				
				<tr>
					<spring:message code="subject.viewButton" var="viewButton"/>
					<td colspan="3"><input type="submit" value="${viewButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		<h2><spring:message code="subject.dataTitleLikeCod"/></h2>
		<form:form method="POST" commandName="asignaturaForm" action="getLikeCod">
			<table>			
				
				<tr>
					<td><spring:message code="subject.cod"/></td>
					<td><form:input path="codigo" /></td>
					<td class="error"><form:errors path="codigo" /></td>
				</tr>
				
				<tr>
					<spring:message code="subject.viewButton" var="viewButton"/>
					<td colspan="3"><input type="submit" value="${viewButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		<h2><spring:message code="subject.dataTitleLikeName"/></h2>
		<form:form method="POST" commandName="asignaturaForm" action="getLikeName">
			<table>			
				
				<tr>
					<td><spring:message code="subject.name"/></td>
					<td><form:input path="nombre" /></td>
					<td class="error"><form:errors path="nombre" /></td>
				</tr>
				
				<tr>
					<spring:message code="subject.viewButton" var="viewButton"/>
					<td colspan="3"><input type="submit" value="${viewButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		<h2><spring:message code="subject.dataTitleAllFields"/></h2>
		<form:form method="POST" commandName="asignaturaForm" action="getLikeFields">
			<table>			
				
				<tr>
					<td><spring:message code="subject.cod"/></td>
					<td><form:input path="codigo" /></td>
					<td class="error"><form:errors path="codigo" /></td>
				</tr>			
				
				<tr>
					<td><spring:message code="subject.name"/></td>
					<td><form:input path="nombre" /></td>
					<td class="error"><form:errors path="nombre" /></td>
				</tr>
				
				<tr>
					<td><spring:message code="subject.year"/></td>
					<td><form:input path="curso" /></td>
					<td class="error"><form:errors path="curso" /></td>
				</tr>
				
				<tr>
					<td><spring:message code="subject.credits"/></td>
					<td><form:input path="creditos" /></td>
					<td class="error"><form:errors path="creditos" /></td>
				</tr>
				
				<tr>
					<spring:message code="subject.viewButton" var="viewButton"/>
					<td colspan="3"><input type="submit" value="${viewButton}" /></td>
				</tr>
				
			</table>
		</form:form>
		
		<h2><spring:message code="subject.listTitle"/></h2>
		<form:form method="POST" commandName="asignaturas" action="getAll">
			<table>
				<tr>
					<spring:message code="subject.viewAllButton" var="viewAllButton"/>
					<td colspan="3"><input type="submit" value="${viewAllButton}" /></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>