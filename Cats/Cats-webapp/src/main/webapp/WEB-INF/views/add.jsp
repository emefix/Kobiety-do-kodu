<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a cat</title>
<style type="text/css">
label {
	display: inline-block;
	width: 250px;
	margin: 5px 5px 5px 5px;
	text-align: left;
}

input {
	width: 200px;
}

button {
	width: 100px;
	margin: 5px 5px 5px 5px;
	padding: 10px;
}
</style>
<style>
.error {
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
	<p>
		<a href="<c:url value="list" />">Back to cat list</a>
	</p>
	<br />

	<div align="center">
		<h1>Adding a new cat</h1>

		<form:form modelAttribute="catDTO" method="POST" >
			<div>
				<form:label path="name">Name:</form:label>
				<form:input path="name" type="text" />
				<br />
				<c:if test="${pageContext.request.method=='POST'}">
					<form:errors path="name" cssClass="error" />
				</c:if>
			</div>
			<div>
				<form:label path="date_of_birth">Date of birth (YYYY-MM-DD):</form:label>
				<form:input path="date_of_birth" type="text" />
				<br />
				<c:if test="${pageContext.request.method=='POST'}">
					<form:errors path="date_of_birth" cssClass="error" />
				</c:if>

			</div>
			<div>
				<form:label path="weight">Weight:</form:label>
				<form:input path="weight" />
				<br />
				<c:if test="${pageContext.request.method=='POST'}">
					<form:errors path="weight" cssClass="error" />
				</c:if>
			</div>
			<div>
				<form:label path="name_of_catKeeper">Name of cat keeper:</form:label>
				<form:input path="name_of_catKeeper" type="text" />
				<br />
				<c:if test="${pageContext.request.method=='POST'}">
					<form:errors path="name_of_catKeeper" cssClass="error" />
				</c:if>
			</div>
			<div>
				<form:button>Add</form:button>
			</div>
		</form:form>
	</div>
</body>
</html>