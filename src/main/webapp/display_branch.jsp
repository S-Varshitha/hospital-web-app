<%@page import="com.ty.dto.BranchDto"%>
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
	List<BranchDto> branches = (List<BranchDto>) request.getAttribute("branchesList");
	%>
	<table border="2">
		<tr>
			<td>Branch ID</td>
			<td>Branch Name</td>
			<td>Phone Number</td>
			<td>Branch Email</td>
			<td>Hospital Id</td>
			<td>Create Address</td>
			<td>View Address</td>
		</tr>
		<%
		for (BranchDto branch : branches) {
		%>
		<tr>
			<td><%=branch.getBranch_id()%></td>
			<td><%=branch.getBranch_name()%></td>
			<td><%=branch.getBranch_phone()%></td>
			<td><%=branch.getEmail()%></td>
			<td><%=branch.getHospitalDto().getHospital_id()%></td>
			<td><a href="create_address.jsp?branchid=<%=branch.getBranch_id()%>">Create</a></td>
			<td><a href="displayaddress?branchid=<%=branch.getBranch_id()%>">View</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>