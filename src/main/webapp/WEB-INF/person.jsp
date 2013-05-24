<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="personbooks.*"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>

<jsp:useBean id="freebooks" type="List<Book>" scope="request" />
<jsp:useBean id="person" type="Person" scope="request" />

<html>
<head>
<title>Person</title>
<style type="text/css">
span.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Edit Person</h1>

	<form:form method="post" commandName = "person">
            <form:hidden path="id"/>
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
				<td><span class="error"><form:errors path="name" /></span></td>
			</tr>

			<tr>
				<td>Age:</td>
                                <td><form:input path="age" /></td>
				<td><span class="error"><form:errors path="age" /></span></td>
			</tr>

			<tr>
				<td>Active:</td>
                                <td><form:checkbox path="active"/></td>
				<td><span class="error"><form:errors
							path="active" /></span></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
        <table>
            <tr>
                <th>Person books</th>
                <th>Free books</th>
            </tr>
            <tr>
                <td>
                    <table>
                        <% for (Book b : person.getBooks()) { %>
                        <tr>
                            <td><%= b.getTitle() %></td> 
                            <td><button onclick='window.location.href="?rembook=<%= b.getId() %>&person=<%= person.getId() %>"'> - </button></td> 
                        </tr>
                        <% } %>
                     </table>
                </td>
                <td>
                    <table>
                        <% for (Book b : freebooks) { %>
                        <tr>
                            <td><%= b.getTitle() %></td> 
                            <td><button onclick='window.location.href="?addbook=<%= b.getId() %>&person=<%= person.getId() %>"'> + </button></td> 
                        </tr>
                        <% } %>
                     </table>
                </td>
            </tr>
        </table>

</body>
</html>
