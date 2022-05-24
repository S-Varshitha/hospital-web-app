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
<form action="login" method="post">
        <table>
            <tr>
                <td><label for="email">Email Id : </label></td>
                <td><input type="Text" name="email" id="email" placeholder="Enter your Email ID" required></td>
            </tr>
            <tr>
                <td><label for="password">Password : </label></td>
                <td><input type="password" name="password" id="password" 
                        placeholder="Enter the password" required></td>
            </tr>
            <tr>
                <td><input type="submit" value="SUBMIT"></td>
                <td><input type="reset" value="RESET"></td>
            </tr>
        </table>
</body>
</html>