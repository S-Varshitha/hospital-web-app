<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Page</title>
<style>
          body{
            background-color:rgb(218, 178, 218);
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
<%String id=request.getParameter("orderId"); %>
<form action="createitem" method="post">
        <table>
        
       <tr><td>Order Id: </td> 
		<td><input type="text" name="orderId" value="<%=id %>" readonly="readonly"></td></tr>
		
		
		<tr><td>Item Name: </td> 
		<td><input type="text" name="name" placeholder="Enter Item Name"></td></tr>
		
		<tr><td>Message:</td> 
		 <td><input type="text" name="message" placeholder="Enter Message"></td> </tr>
		 
		 <tr><td>cost:</td> 
		 <td><input type="number" name="cost" placeholder="Enter Cost"></td> </tr>
		 
		 <tr><td>Quantity:</td> 
		 <td><input type="number" name="quantity" placeholder="Enter Quantity"></td> </tr>
		
		 <tr><td colspan="2" align="center"><input type="submit" value="create Item"></td></tr>
     </table>
	</form>
</body>
</html>