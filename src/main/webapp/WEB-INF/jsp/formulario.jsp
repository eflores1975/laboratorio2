<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<style type="text/css">
		label {
			display: inline-block;
			width: 250px;
			margin: 5px;
			text-align: left;
		}

		input[type=text] {
			width: 300px;
		}

		select {
			width: 308px;
		}

		input[type=radio] {
			display: inline-block;
			margin-left: 90px;
		}

		input[type=checkbox] {
			display: inline-block;
			margin-left: 120px;
		}

		button {
			padding: 10px;
			margin: 10px;
		}

		input[type=submit] {
			padding: 10px;
			margin: 10px;
		}

		input[type=reset] {
			padding: 10px;
			margin: 10px;
		}

		textarea {
			width: 300px;
		}

		.error {
        	color: #ff0000;
        	font-weight: bold;
    	}
    </style
	</style>		
	<meta charset="UTF-8">
	<title>Formulario - Laboratiorio 2</title>

</head>
<body>
	<div align="center">
		<h2>Favor llene el siguiente formulario</h2>
		<form:form id="myform" action="/saveUserInfo" method="post" modelAttribute="userInfo">
			<%-- <form:errors path="*" modelAttribute="*" cssClass="error" /> --%>
			<table>
				<tr>
					<td><form:label path="name"><spring:message code="lbl.name" text="Nombre completo:" /></form:label></td>
					<td><form:input path="name"/></td>
					<td><form:errors path="name" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="email"><spring:message code="lbl.email" text="Correo electrónico:" /></form:label></td>
					<td><form:input path="email"/></td>
					<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="country"><spring:message code="lbl.country" text="País:" /></form:label></td>
					<!-- <td><form:select path="country" items="${countries}"/></td> -->
					<td>
						<form:select path="country" items = "${countries}"/>
					</td>
					<td><form:errors path="country" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="id"><spring:message code="lbl.id" text="Cédula o pasaporte:" /></form:label></td>
					<td><form:input path="id"/></td>
					<td><form:errors path="id" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="company"><spring:message code="lbl.company" text="Compañía:" /></form:label></td>
					<td><form:input path="company"/></td>
					<td><form:errors path="company" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="gender"><spring:message code="lbl.gender" text="Sexo:" /></form:label></td>
					<td>
						<form:radiobutton path="gender" value="Mujer"/>Mujer
						<form:radiobutton path="gender" value="Hombre"/>Hombre
					</td>
					<td><form:errors path="gender" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="food"><spring:message code="lbl.food" text="Comida favorita:" /></form:label></td>
					<td><form:input path="food"/></td>
					<td><form:errors path="food" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="pet"><spring:message code="lbl.pet" text="Nombre de la mascota:" /></form:label></td>
					<td><form:input path="pet"/></td>
					<td><form:errors path="pet" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="profession"><spring:message code="lbl.profession" text="Professión:" /></form:label></td>
					<td><form:input path="profession"/></td>
					<td><form:errors path="profession" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="comment"><spring:message code="lbl.comment" text="Comentarios (opcional):" /></form:label></td>
					<td><form:textarea path="comment"/></td>
				</tr>
			</table>
			<input type="submit" value="Enviar"/>
			<input type="reset" value="Limpiar formulario">
		</form:form>
	</div>
</body>
</html>
