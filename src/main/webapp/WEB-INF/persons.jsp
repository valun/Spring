<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="personbooks.*"%>

<jsp:useBean id="personsList" type="PersonsList" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persons</title>
    </head>
    <body>
        <hr/> 
        <table>
        <% for (Person p : personsList.getAllPersons()) { %>
        
        <tr>
            <td><%= p.getName() %></td> 
            <td><button onclick='window.location.href="?id=<%= p.getId() %>"'>Edit</button></td> 
            <td><button onclick='window.location.href="?del=<%= p.getId() %>"'>Delete</button></td> 
        </tr>
        <% } %>
        </table>
        <hr/>    
    </body>
</html>
