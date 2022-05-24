<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Encounter</title>
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
<% String id=request.getParameter("personid"); %>
<%@ include file="staff_navbar.jsp" %>
<form method="post" action="createencounter">
        <table>
        	<tr>
        	<td><label for="personid">ID :</label></td>
                <td><input type="text" name="personid" value="<%=id %>" readonly="readonly"></td>
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
                <td><label for="reason">Reason :</label></td>
                <td><input type="test" name="reason" id="reason"></td>
            </tr>
            <tr>
                <td><input type="submit" value="SUBMIT"></td>
            </tr>
        </table>
    </form>
</body>
</html>