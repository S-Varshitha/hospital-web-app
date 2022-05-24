<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
          body{
            background-color: rgb(191, 226, 226);
        }
        table,
        th,
        td {
            border-collapse: collapse;
        }

        th,
        td {
            font-size: large; 
            padding: 15px;
        }
    </style>
</head>
<body>
<%String id=request.getParameter("encounterid"); %>
<%@ include file="staff_navbar.jsp" %>
	<form method="post" action="createorder">
		<table>
		 <tr>
        	<td><label for="encounterid">ID :</label></td>
                <td><input type="text" name="encounterid" value="<%=id %>" readonly="readonly"></td>
		 </tr>
			<tr>
				<td><label for="date">Date :</label></td>
				<td><input type="date" name="date" id="date"></td>
			</tr>
			<tr>
				<td><label for="time">Time :</label></td>
				<td><input type="time" name="time" id="time"></td>
			</tr>
			<tr>
				<td><label for="message">Message</label></td>
				<td><input type="Text" name="message" id="message"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create Order"></td>
			</tr>
		</table>
	</form>
</body>
</html>