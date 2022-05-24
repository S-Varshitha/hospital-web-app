<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-color: rgb(191, 226, 226);
}

table, th, td {
	border-collapse: collapse;
}

th, td {
	font-size: large;
	padding: 15px;
}
</style>
</head>
<body>
<%
	String id = request.getParameter("branchid");
	%>
	<%@ include file="admin_navbar.jsp"%>
	<form action="createaddress" method="post" >
		<table>
			<tr>
				<td><label for="branchId">Branch Id :</label></td>
				<td><input type="text" name="branchId" id="branchId" value="<%=id %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td><label for="state">State :</label></td>
				<td><input type="text" name="state" id="state"
					placeholder="Enter the state name" required></td>
			</tr>
			<tr>
				<td><label for="district">District :</label></td>
				<td><input type="text" name="district" id="district"
					placeholder="Enter the district name" required></td>
			</tr>
			<tr>
				<td><label for="address">Adress :</label></td>
				<td><input type="text" name="address" id="address" required></td>
			</tr>
			<tr>
				<td><label for="pincode">Pincode :</label></td>
				<td><input type="number" name="pincode" id="pincode" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create Address"></td>
			</tr>
		</table>
</body>
</html>