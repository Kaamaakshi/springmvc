<%@page import="java.util.List"%>
<%@page import="spring.mvc.practice.DTO.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<StudentDto> l = (List<StudentDto>) request.getAttribute("data");
		%>
		<table border=" ">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>delete</th>
				<th>update</th>
			</tr>
			<% for (StudentDto a : l) { %>
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getName()%></td>
				<td><a href='did?id=<%=a.getId()%>'>remove</a></td>
				<td><a href="update.jsp?id=<%=a.getId()%>&&name=<%=a.getName()%>">modify</a></td>
			</tr>



<%}%>
</table>

</body>
</html>