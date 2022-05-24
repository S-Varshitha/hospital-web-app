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
	String id = request.getParameter("hospitalid");
	%>
	<%@ include file="admin_navbar.jsp"%>
	<form method="post" action="createbranch">
		<table>
			<tr>
				<td><label for="hospitalid">Hospital ID : </label></td>
				<td><input type="text" name="hospitalid" value="<%=id%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td><label for="branchName">Branch Name : </label></td>
				<td><input type="text" name="branchName" id="branchName"
					placeholder="Enter the branch" required></td>
			</tr>
			<tr>
				<td><label for="branchPhoneNumber">Phone Number : </label></td>
				<td><input type="text" name="branchPhoneNumber"
					id="branchPhoneNumber" placeholder="Enter the branch number"></td>
			</tr>
			<tr>
				<td><label for="branchEmail">Email ID: </label></td>
				<td><input type="text" name="branchEmail" id="branchEmail"
					placeholder="Enter the branch Email Id"></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>
	</form>
</body>
</html>