<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/todos.css">
  <link rel="stylesheet" th:href="@{/webjars/bootstrap/5.3.2/css/bootstrap.min.css}" />
  <title>Todos Application | Welcome</title>
</head>

<body>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">Todos Application</a>
      </div>
      <!-- <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">My Todos</a></li>
    </ul> -->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> My Profile</a></li>
        <li><a href="<c:url value='/login' />"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </nav>
  <div class="welcome-page">
    <div class="wlcm-text">
      <span>Hi ${username}, welcome to Todos application!!!</span>
    </div>
  <div class="input-container">
    <input type="text" placeholder="Add a new task" class="task-inp" name="add-task">
    <button onclick="window.open('/add-todo', '_blank');" class="add-btn">Add</button>
  </div>
  <table class="todo-table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Description</th>
        <th>Date</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todoItem">
      <tr>
        <td>${todoItem.id}</td>
        <td>${todoItem.username}</td>
        <td>${todoItem.description}</td>
        <td>${todoItem.date}</td>
        <td><input type="checkbox"></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script th:src="@{/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js}"></script>
</body>

</html>