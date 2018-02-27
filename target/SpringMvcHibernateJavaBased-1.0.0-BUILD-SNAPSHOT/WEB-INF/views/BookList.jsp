<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
	        <h1>Book List</h1>
	        <h2><a href="new1">New Book</a></h2>
	        
        	<table border="1">
	        	<th>No</th>
	        	<th>Name</th>
	        	<th>Author</th>
	        	<th>Price</th>
	        	
				<c:forEach var="book" items="${bookList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${book.name}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
					<td>
						<a href="edit1?id=${book.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete1?id=${book.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
