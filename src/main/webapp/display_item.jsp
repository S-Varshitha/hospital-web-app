<%@page import="com.ty.dto.ItemDto"%>
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
<%@ include file="staff_navbar.jsp" %>
<% List<ItemDto> items=(List<ItemDto>)request.getAttribute("itemList");%>
<br><br><br>

 <table border="2">
  <tr><td colspan="6" align="center"><h3>Item Table</h3></td></tr>
   <tr>
   <th>Id</th>
   <th>Message</th>
   <th>Name</th>
   <th>Quantity</th>
   <th>Cost</th>
   <th>Order_Id</th>
   </tr>
   
       <%
		for(ItemDto item:items) {
		%>
			
			<tr>
				<td><%=item.getItem_id()%></td>
				<td><%=item.getMessage()%></td>
				<td><%=item.getItem_name()%></td>
				<td><%=item.getQuantity()%></td>
				<td><%=item.getCost()%></td>
				<td><%=item.getMedOrders().getOrder_id()%></td>
			</tr>
			
	<%
		}
	%>
   
</body>
</html>