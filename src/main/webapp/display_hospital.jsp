<%@page import="com.ty.dto.HospitalDto"%>
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
	List<HospitalDto> hospitals = (List<HospitalDto>) request.getAttribute("hospitalsList");
	%>
	<table border="2">
		<tr>
			<td>Hospital ID</td>
			<td>Hospital Name</td>
			<td>Hospital Website</td>
			<td>GST</td>
			<td>Create Branch</td>
			<td>View Branch</td>
		</tr>
		<%
		for (HospitalDto hospital : hospitals) {
		%>
		<tr>
			<td><%=hospital.getHospital_id()%></td>
			<td><%=hospital.getHospital_name()%></td>
			<td><%=hospital.getWebsite()%></td>
			<td><%=hospital.getGst()%></td>
			<td><a href="create_branch.jsp?hospitalid=<%=hospital.getHospital_id()%>">Create</a></td>
			<td><a href="displaybranches?hospitalid=<%=hospital.getHospital_id()%>">View</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>