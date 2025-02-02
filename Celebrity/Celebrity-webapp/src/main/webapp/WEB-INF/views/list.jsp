<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored ="false" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List of celebrities</title>
	</head>
	<body>
		<p><a href="<c:url value=""/>">Back to the home page</a></p><br />
	
		<div align="center">
			<h1>List of celebrities</h1>
			<p><a href="<c:url value="add" />">Add a celebrity</a></p><br />
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
					</tr>
				</thead> 
				<tbody>
					<c:forEach items="${celebrities}" var="celebrity" varStatus="status">
						<tr>
							<td>${celebrity.id}</td>
							<td><a href="<c:url value="celebrity-${celebrity.id}" />">${celebrity.name}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>