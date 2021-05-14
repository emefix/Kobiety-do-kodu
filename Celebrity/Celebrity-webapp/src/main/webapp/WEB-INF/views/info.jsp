<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information about the celebrity</title>

<spring:url value="/resources/css/info_style.css" var="infoCss" />
<link href="${infoCss}" rel="stylesheet" />

</head>
<body>
	<p>
		<a href="<c:url value="list"/>">Back to celebrity list</a>
	</p>
	<br />

	<div align="center">
		<h2>Information about the celebrity</h2>
		<span>Name:</span> <span>${celebrity.name}</span><br /> <span>Talent:</span>
		<span> <c:if test="${celebrity.canSing}">can sing,</c:if> <c:if
				test="${celebrity.canAct}">can act,</c:if> <c:if
				test="${celebrity.canDance}">can dance,</c:if>
		</span><br />
	</div>
</body>
</html>