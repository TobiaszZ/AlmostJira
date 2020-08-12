<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body>
<h1> List of all Projects</h1><br>
<a href="http://localhost:8080/admin/options/">Go back to options</a><br>

<table border="1">

    <tr bgcolor="#7fffd4">
        <td>Name</td>
        <td>Created</td>
        <td>Project Id</td>
        <td>Project Task List</td>
        <td>Add Task</td>
        <td>Project Info</td>
        <td>Edit Project</td>
    </tr>

    <c:forEach var="project" items="${projects}">
        <tr>
            <td>${project.name}</td>
            <td>${project.created}</td>
            <td>${project.projectId}</td>
            <td><a href="http://localhost:8080/task//show/${project.id}">Go to Task List</a></td>
            <td><a href="http://localhost:8080/task/add/${project.id}">Add Task</a></td>
            <td><a href="http://localhost:8080/project/details/${project.id}"> Get Project Info</a></td>
            <td><a href="http://localhost:8080/project/update/${project.id}">Edit Project</a></td>
            <td><a href="http://localhost:8080/project/delete/${project.id}">delete</a></td>
        </tr>
    </c:forEach>

</table>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>