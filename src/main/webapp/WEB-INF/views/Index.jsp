<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>     <%--problem with space--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Index Page</title>
</head>
<body>
    <h1>Welcome to the Simple Application</h1>
    <div class="container">
        <form:form action="userInfo" method="POST" modelAttribute="userkey">
            <div class="sub_field">
                <label for="username">User Name</label>
                <form:input type="text" id="username" path="name"/>
                <form:errors path="name" />
            </div>
            <div class="sub_field">
                <label for="pass">Password</label>
                <input type="password" id="pass" name="password" />
            </div>
            <div class="sub_field">
                <label for="email">Email</label>
                <form:input type="text" id="email" path="email"/>
                <form:errors path="email" />
            </div>
            <div class="btn">
                <input type="submit" name="submit" value="Submit Info" />
            </div>
        </form:form>
    </div>
</body>
</html>
