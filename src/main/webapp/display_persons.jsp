<%@page import="com.ty.dto.PersonDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="staff_navbar.jsp" %>
	<% List<PersonDto> persons=(List<PersonDto>)request.getAttribute("personsList"); %>
	<table border="2">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Age</td>
			<td>Phone Number</td>
			<td>Gender</td>
			<td>Email</td>
			<td>Encounter</td>
			<td>Encounter</td>
		</tr>
		<% 
		for(PersonDto person:persons) {
		%>
		<tr>
			<td><%=person.getPerson_id()%></td>
			<td><%=person.getName()%></td>
			<td><%=person.getAge()%></td>
			<td><%=person.getPhone()%></td>
			<td><%=person.getAge()%></td>
			<td><%=person.getEmail()%></td>
			<td><a href="create_encounter.jsp?personid=<%=person.getPerson_id()%>">Create</a></td>
			<td><a href="displayencounter?personid=<%=person.getPerson_id()%>">View</a></td>
		</tr>	
		<% 
		 }
		%>
	</table>
</body>
</html>