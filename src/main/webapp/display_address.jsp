<%@page import="com.ty.dto.AdressDto"%>
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
<%@include file="admin_navbar.jsp"%>
	<%
	List<AdressDto> addresses = (List<AdressDto>) request.getAttribute("adsressList");
	%>
	<table border="2">
		<tr>
			<td>Branch ID</td>
			<td>State</td>
			<td>District</td>
			<td>Pincode</td>
			<td>Address</td>			
		</tr>
		<%
		for (AdressDto address : addresses) {
		%>
		<tr>
			<td><%=address.getAddress_id()%></td>
			<td><%=address.getState()%></td>
			<td><%=address.getDistrict()%></td>
			<td><%=address.getPincode()%></td>
			<td><%=address.getAddress()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>