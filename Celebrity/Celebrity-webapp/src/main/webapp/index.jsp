<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>The celebrity app</title>
	</head>
	<body>
		<div align="center">
			<h1>Welcome to the Celebrity App!</h1>
			<a href="<c:url value="list" />">Go to celebrity list</a><br />
<!-- 			<a href="list">Go to celebrity list</a> -->
		</div>
	</body>
</html>
