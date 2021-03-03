<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of cats</title>
</head>
<body>
	<div align="center">
		<h1>List of cats</h1>
		<p>
			<a href="<c:url value="add" />">Add a cat</a>
		</p>
		<br />
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cats}" var="cat" varStatus="status">
					<tr>
						<td>${status.index +1}</td>
						<td><a href="<c:url value="cat-${cat.id}"/>">${cat.name}</a></td><%-- ${status.index} --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>