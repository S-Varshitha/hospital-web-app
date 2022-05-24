<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Create Person</title>
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
<%@include file="staff_navbar.jsp" %>
	<form action="createperson" method="post">
        <table>
            <tr>
                <td><label for="name">Name : </label></td>
                <td><input type="text" name="name" id="name" placeholder="Enter your name" required></td>
            </tr>
            <tr>
                <td><label for="phone">Phone Number : </label></td>
                <td><input type="number" name="phone" id="phone" placeholder="Enter the contact number" required></td>
            </tr>
            <tr>
                <td><label for="age">Age : </label></td>
                <td><input type="number" name="age" id="age" placeholder="Enter the age" required></td>
            </tr>
            <tr>
                <td><label for="gender">Gender : </label></td>
                <td><input type="radio" name="gender" id="gender" value="Female">Female
                    <input type="radio" name="gender" id="gender" value="Male">Male</td>
            </tr>
            <tr>
                <td><label for="personEmail">Email Id</label></td>
                <td><input type="text" name="personEmail" id="personEmail" placeholder="Enter the mail Id" required></td>
            </tr>
            <tr>
                <td><label for="personPassword">Password</label></td>
                <td><input type="password" name="personPassword" id="personPassword" placeholder="Enter the password"  required></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create Person"></td>
            </tr>
        </table>
    </form>
</body>
</html>