<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New or Edit User</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit User</h1>
		<table>
			<form:form action="save1" method="post" modelAttribute="book">
			<form:hidden path="id"/>
			<tr>
				<td>Name:</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input path="author"/></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	
</body>
</html>