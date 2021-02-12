<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add a celebrity</title>
	</head>
	<body>
		<a href="list">Back to the list of celebrities</a>
		<br />
		<form method="POST">
			<p>
			<label>Name</label>
			<input type=text name=name/></p>
			<fieldset>
				<legend>Choose talents</legend>
					<div>
						<input type="checkbox" id="isASinger" name="singer" value="canSing">
						<label for="isASinger">Can sing</label>
					</div>
					<div>
						<input type="checkbox" id="isAnActor" name="actor" value="canAct">
						<label for="isAnActor">Can act</label>
					</div>
					<div>
						<input type="checkbox" id="isADancer" name="dancer"value="canDance"> 
						<label for="isADancer">Can dance</label>
					</div>
				</fieldset>
				<div>
					<button type="submit">Add</button>
				</div>
		</form>
	</body>
</html>