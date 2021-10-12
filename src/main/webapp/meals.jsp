<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style>
        table {
            border: 1px solid #999;
        }

        td, th {
            border: 1px solid #999;
            padding: 0.5rem;
            justify-content: center
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<p><a href="meals">Add Meal</a></p>
<table>
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.mealsToList}" var="mealItem">
        <tr style="color:${mealItem.excess ? 'green' : 'red'}">
            <td><fmt:parseDate value="${mealItem.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"
                               type="both"/>
                <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${parsedDateTime}"/></td>
            <td>${mealItem.description}</td>
            <td>${mealItem.calories}</td>
            <td><a href="meals">Update</a></td>
            <td><a href="meals">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>