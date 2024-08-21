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
    <h2>Your Cart</h2>
    <a href="xproduct">My Home</a>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
       <c:forEach var="item" items="${cart.items}">
           <tr>
               <td>${item.value.product.name}</td>
               <td>${item.value.product.price}</td>
               <td>
                   <form action="updateCart" method="post">
                       <input type="hidden" name="productId" value="${item.value.product.id}" />
                       <input type="number" name="quantity" value="${item.value.quantity}" min="1" />
                       <input type="submit" value="Update" />
                   </form>
               </td>
               <td>${item.value.product.price * item.value.quantity}</td>
               <td>
                   <form action="removeFromCart" method="post">
                       <input type="hidden" name="productId" value="${item.value.product.id}" />
                       <input type="submit" value="Remove" />
                   </form>
               </td>
           </tr>
       </c:forEach>
    </table>
    <h3>Total: ${cart.totalAmount}</h3>
    <form action="checkout" method="post">
        <input type="submit" value="Checkout"/>
    </form>
</body>
</html>
