<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a celebrity</title>

<spring:url value="/resources/css/add_style.css" var="addCss" />
<link href="${addCss}" rel="stylesheet" />

</head>
<body>
	<p>
		<a href="<c:url value="list"/>">Back to celebrity list</a>
	</p>
	<br />

	<div align="center">
		<h1>Adding a new celebrity</h1>
		<c:url var="actionUrl" value="/add" />

		<form:form modelAttribute="celebrityDTO" method="POST"
			action="${actionUrl}">
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name" />
			<br />
			<c:if test="${pageContext.request.method=='POST'}">
				<form:errors path="name" cssClass="error" />
			</c:if>
			<br />
			<fieldset>
				<legend align="left">Choose talents:</legend>
				<div>
					<form:label path="canSing">Can sing?</form:label>
					<form:checkbox path="canSing" />
				</div>
				<br />
				<div>
					<form:label path="canAct">Can act?</form:label>
					<form:checkbox path="canAct" />
				</div>
				<br />
				<div>
					<form:label path="canDance">Can dance?</form:label>
					<form:checkbox path="canDance" />
				</div>
				<br />
			</fieldset>
			<div>
				<form:button>Add</form:button>
			</div>
		</form:form>
	</div>
</body>
</html>