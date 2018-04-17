<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset = "utf-8">
	<title>Canadian Food Guide Nutritional Recommendation</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
</head>
<body>
<h2><spring:message code="requiredInfo.text"/></h2>

<spring:message code="language.text"/> : <a href="?language=en">English</a> | <a href="?language=fr">Français</a> 
<form:form commandName="person">
	<table>
		<tr>
			<td><spring:message code="age.text"/></td>
			<td><form:input path="age"  value="18"/></td>
		</tr>
		<tr>
			<td><spring:message code="gender.text"/></td>
			
			<td><form:radiobutton path="gender" value="male" checked="checked"/><spring:message code="male.text"/>
			<form:radiobutton path="gender" value="female"/><spring:message code="female.text"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="<spring:message code="submit.text"/>">
		</tr>
	</table>
</form:form>


</body>
</html>