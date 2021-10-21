<%@ page import="ru.javawebinar.topjava.model.User" %>
<%@ page import="ru.javawebinar.topjava.util.UsersUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>

<html lang="ru">
<head>
    <title>Users</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>Users</h2>
    <br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <td>Имя</td>
            <td>Почта</td>
            <td>Роли</td>
            <td>Активный</td>
            <td>Зарегистрирован</td>
            <td></td>
            <td></td>
        </tr>
        </thead>
        <jsp:useBean id="users" scope="request" type="java.util.List"/>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" type="ru.javawebinar.topjava.model.User"/>
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td><%=user.getRoles().toString()%></td>
                <td>${user.enabled}</td>
                <td>${fn:formatDate(user.registered)}</td>
                <td><a href="users?action=update&${user.id}">Update</a></td>
                <td><a href="users?action=delete&${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>