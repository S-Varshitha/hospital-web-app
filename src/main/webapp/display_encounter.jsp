<%@page import="com.ty.dto.EncounterDto"%>
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
	<%
	List<EncounterDto> encounters = (List<EncounterDto>)request.getAttribute("encounterList");
	%>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Creator Name</th>
			<th>Date</th>
			<th>Time</th>
			<th>Branch ID</th>
			<th>Person ID</th>
			<th>CreateOrder</th>
			<th>ViewOrder</th>
		</tr>
		<% 
		for(EncounterDto encounter:encounters){ 
		%>
			<tr>
				<td><%=encounter.getEncounter_id() %></td>
				<td><%=encounter.getCreatorName() %></td>
				<td><%=encounter.getDate() %></td>
				<td><%=encounter.getTime() %></td>
				<td><%=encounter.getBranchDto().getBranch_id() %>
				<td><%=encounter.getPersonDto().getPerson_id() %>
				<td><a href="create_order.jsp?encounterid=<%=encounter.getEncounter_id()%>">Create</a></td>
				<td><a href="displayorder">View</a></td>
			</tr>
		<% 
		}
		%>
	</table>
</body>
</html>