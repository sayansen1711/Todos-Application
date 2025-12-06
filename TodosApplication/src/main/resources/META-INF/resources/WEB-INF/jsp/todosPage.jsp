<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%@ include file="common/header.jspf" %>
  <link rel="stylesheet" href="/css/todos.css">
  <title>Todos Application | Welcome</title>
</head>

<body>
 <nav class="navbar navbar-inverse">
         <div class="container-fluid">
             <div class="navbar-header">
                 <a class="navbar-brand" href="#">Todos Application</a>
             </div>
             <ul class="nav navbar-nav">
                 <li><a href="welcome">Home</a></li>
                 <li class="active"><a href="todo-page">My Todos</a></li>
             </ul>
             <ul class="nav navbar-nav navbar-right">
                 <li><a href="#"><span class="glyphicon glyphicon-user"></span> My Profile</a></li>
                 <li><a href="<c:url value='/signup' />"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
             </ul>
         </div>
 </nav>
  <div class="welcome-page">
    <div class="wlcm-text">
      <span>Hi ${username}, welcome to Todos application!!!</span>
    </div>

  <table class="todo-table">
    <thead>
      <tr>
        <th>Username</th>
        <th>Description</th>
        <th>Date</th>
        <th>Status</th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${todosList}" var="todoItem">
      <tr>
        <td>${todoItem.username}</td>
        <td>${todoItem.description}</td>
        <td>${todoItem.date}</td>
        <td><input type="checkbox"></td>
        <td><a href="update-todo?id=${todoItem.id}" class="btn btn-success">Update</a></td>
        <td><a href="delete-todo?id=${todoItem.id}" class="btn btn-warning">Delete</a></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <div class="input-container">
      <button onclick="window.location.href='/add-todo' " class="add-btn">Add</button>
  </div>
  </div>
  <%@ include file="common/footer.jspf" %>
</body>

</html>