<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information about a cat</title>
<style type="text/css">
span {
	display: inline-block;
	width: 200px;
	margin: 5px, 5px, 5px, 5px;
	text-align: left;
}
</style>
</head>
<body>
	<p>
		<a href="<c:url value="list"/>">Back to cat list</a>
	</p>
	<br />
	<div align="center">
		<h2>Information about the cat</h2>

		<span>Name:</span> <span>${cat.name}</span>
		<br /> 
		<span>Date of birth:</span> 
		<span><fmt:formatDate 
				pattern="YYYY-MM-DD" value="${cat.date_of_birth}" /></span>
		<br /> 
		<span>Weight:</span> 
		<span><fmt:formatNumber
				type="number" minFractionDigits="2" maxFractionDigits="2"
				value="${cat.weight}" /> kg</span>
		<br /> 
		<span>Name of a cat	keeper:</span> 
		<span>${cat.name_of_catKeeper}</span>
	</div>
</body>
</html>