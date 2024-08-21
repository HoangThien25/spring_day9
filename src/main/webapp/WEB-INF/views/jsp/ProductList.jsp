<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Spring MVC Form</title>

</head>
<body>
    <div class="container">
        <h2>Product List</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                <th>Id</th>
                    <th>Product Name</th>
                    <th>Price</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                    <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                      <td>
                     <td>
                         <form method="POST" action="${pageContext.request.contextPath}/addToCart">
                             <input type="hidden" name="productId" value="${product.id}" />
                             <input type="submit" value="Add to Cart" class="btn btn-primary"/>
                         </form>
                     </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
