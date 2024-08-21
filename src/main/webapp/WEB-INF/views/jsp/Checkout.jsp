<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Your Shopping Cart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
 <a href="Cart.jsp">Card</a>
    <h1>Customer Information</h1>
    <form:form action="${pageContext.request.contextPath}/listCustomers" method="post" modelAttribute="customerForm">
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" required="true" placeholder="Name" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address" required="true" placeholder="Address" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit" class="btn btn-primary" />
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
