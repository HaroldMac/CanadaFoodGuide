<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset = "utf-8">
	<title>Canadian Food Guide Nutritional Recommendation</title>
	
	<script type="text/javascipt" src="jquery-3.3.1.js"></script>

</head>
<body>
<h2><spring:message code="recommendedDailyServings.text"/></h2>

<spring:message code="servingsBasedOnAgeAndGender.text"/>:<br> <br>

<spring:message code="vf.text"/>:  ${servingRecommendation.vegetablesAndFruits} <spring:message code="servings.text"/><br>
<c:forEach items="${vf.foods}" var="foods">
&emsp;<c:out value="${foods}"></c:out><br>
</c:forEach>
<br>

<spring:message code="gr.text"/>: ${servingRecommendation.grains} <spring:message code="servings.text"/><br>
<c:forEach items="${gr.foods}" var="foods">
&emsp;<c:out value="${foods}"></c:out><br>
</c:forEach>
<br>

<spring:message code="mi.text"/>: ${servingRecommendation.milkAndAlternatives} <spring:message code="servings.text"/><br>
<c:forEach items="${mi.foods}" var="foods">
&emsp;<c:out value="${foods}"></c:out><br>
</c:forEach>
<br>

<spring:message code="me.text"/>: ${servingRecommendation.meatAndAlternatives} <spring:message code="servings.text"/><br>
<c:forEach items="${me.foods}" var="foods">
&emsp;<c:out value="${foods}"></c:out><br>
</c:forEach>



</body>
</html>