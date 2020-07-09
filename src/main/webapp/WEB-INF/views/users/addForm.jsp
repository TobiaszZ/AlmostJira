<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add user</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head language ="UTF-8">
<body>
<a href="http://localhost:8080/admin/options/">Go back to options</a><br>
<h1 align="center">add User</h1>

<%--@elvariable id="author" type="project.almostJira.model.User"--%>

<div align ="center">
<form:form method="post" modelAttribute="user">
Login: <br>
<form:input path = "login" /><br>
<form:errors path = "login"/>
Name: <br>
<form:input path ="firstName" /><br>
<form:errors path = "firstName"/>
Last name: <br>
<form:input path = "lastName" /> <br>
<form:errors path = "lastName"/>
Password: <br>
<form:password path = "password" /><br>
<form:errors path = "password"/>
<form:hidden path="id"/>
<input type="submit" value="Ok">

</form:form>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>