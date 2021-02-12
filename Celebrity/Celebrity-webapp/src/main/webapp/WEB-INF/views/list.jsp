<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List of celebrities</title>
	</head>
	<body>
		<a href="add">Add a celebrity</a><br/>
		<p>${celebrities}</p>
		<table border=1>
			<thead>
				<tr>
					<th>#</th>
					<th>Name of a celebrity</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>0</td>
					<td><a href="celebrity-0">Herbut</a></td>
				</tr>
				<tr>
					<td>1</td>
					<td><a href="celebrity-1">Justyna Steczkowska</a></td>
				</tr>
			</tbody>
		</table>
		<br/>
	</body>
</html>