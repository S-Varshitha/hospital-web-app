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
<%@include file="admin_navbar.jsp" %>
	<form method="post" action="createHospital">
		<table>
			<tr>
				<td><label for="hospitalName">Hospital Name : </label></td>
				<td><input type="text" name="hospitalName" id="hospitalName"
					placeholder="Enter the Hospital Name" required></td>
			</tr>
			<tr>
				<td><label for="hospitalWebsite">Hospital Website : </label></td>
				<td><input type="text" name="hospitalWebsite"
					id="hospitalWebsite" placeholder="Enter the hospital website"></td>
			</tr>
			<tr>
				<td><label for="gst">GST Number : </label></td>
				<td><input type="text" name="gst" id="gst"
					placeholder="Enter gst"></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>
	</form>
</body>
</html>