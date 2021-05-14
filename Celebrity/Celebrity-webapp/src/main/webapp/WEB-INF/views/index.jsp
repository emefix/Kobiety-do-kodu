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
<title>The celebrity app</title>

<spring:url value="/resources/css/index_style.css" var="indexCss" />
<link href="${indexCss}" rel="stylesheet" />
<%-- <link href="<c:url value="/resources/css/index_style.css" />" rel="stylesheet"> --%>

</head>
<body>
	<div align="center">
		<h1>Welcome to the Celebrity app!</h1>
	</div>

	<div align="center">
		<h2>Choose the DAO</h2>
		<c:url var="actionUrl" value="/" />

		<form method="POST" action="${actionUrl}">
			<fieldset>
				<legend align="left">Choose the data access type:</legend>
				<c:forEach items="${daos}" var="dao" varStatus="status" >
					<div>
						<input type="radio" name="dao" value="${dao}" checked="checked" /> <label
							class="dao">${dao.name}</label>
					</div>
					<br />
				</c:forEach>
			</fieldset>
			<div>
				<button class="button" type="submit">Choose</button>
			</div>
		</form>
	</div>
</body>
</html>
