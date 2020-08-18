<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

</head>
<body>
<h1 align="center">Admin Page</h1>
<div align="center">

<table>

<tr>
<td>Show all users</td>
<td><a href="http://localhost:8080/user/showAll">Click</a></td>
</tr>
<tr>
<td>Add user</td>
<td><a href="http://localhost:8080/user/add">Click</a></td>
</tr>

<tr>
<td>Show all projects</td>
<td><a href="http://localhost:8080/project/showAll">Click</a></td>
</tr>
<tr>
<td>Add project</td>
<td><a href="http://localhost:8080/project/add">Click</a></td>
</tr>

<tr>
<td>Show all Task status</td>
<td><a href="http://localhost:8080/taskStatus/showAll">Click</a></td>
</tr>
<tr>
<td>Add Task status</td>
<td><a href="http://localhost:8080/taskStatus/add">Click</a></td>
</tr>

<tr>
<td>Show all Task priorites</td>
<td><a href="http://localhost:8080/taskPriority/showAll">Click</a></td>
</tr>
<tr>
<td>Add Task priority</td>
<td><a href="http://localhost:8080/taskPriority/add">Click</a></td>
</tr>


</table>

</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>