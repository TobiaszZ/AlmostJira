<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head language ="UTF-8">
<body>
<a href="http://localhost:8080/admin/options/">Go back to options</a><br>
<a href="http://localhost:8080/project/showAll">Back</a>
<h1 align="center">add Task</h1>
<div align="center">
<form:form method="post" modelAttribute="task">
Task title:<br>
<form:input path = "title" /><br>
<form:errors path = "title"/>
Task description:<br>
<form:textarea path ="description" rows="5" cols="20"/><br>
<form:errors path = "description"/>
Select users for task:<br>
<form:select itemValue="id" itemLabel="login" path="users" items="${task.users}" /><br>
<form:errors path = "users"/>
<form:hidden path="created"/>
<form:hidden path="id"/>
<input type="submit" value="Ok"><br>
</form:form>
</dic>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>

