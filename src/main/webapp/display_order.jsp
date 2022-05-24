<%@page import="com.ty.dto.MedOrderDto"%>
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
	List<MedOrderDto> orders = (List<MedOrderDto>)request.getAttribute("ordersList");
	%>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Creator Name</th>
			<th>Date</th>
			<th>Time</th>
			<th>Message</th>
			<th>Encounter Id</th>
			<th>Create Item</th>
			<th>View Item</th>
		</tr>
		<% 
		for(MedOrderDto order:orders){ 
		%>
			<tr>
				<td><%=order.getOrder_id() %></td>
				<td><%=order.getCreatorName() %></td>
				<td><%=order.getDate() %></td>
				<td><%=order.getTime() %></td>
				<td><%=order.getMessage() %>
				<td><%=order.getEncounters().getEncounter_id() %>
				<td><a href="create_item.jsp?orderId=<%=order.getOrder_id() %>">Create</a>
				<td><a href="displayitem?orderId=<%=order.getOrder_id() %>">View</a>
			</tr>
		<% 
		}
		%>
	</table>
</body>
</html>