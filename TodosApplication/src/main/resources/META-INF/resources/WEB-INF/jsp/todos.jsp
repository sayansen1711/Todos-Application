<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/todos.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
        <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </nav>
  <div class="welcome-page">
    <div class="wlcm-text">
      <span>Hi, ${username}, welcome to Todos application!!!</span>
    </div>
  <div class="input-container">
    <input type="text" placeholder="Add a new task" class="task-inp" name="add-task">
    <button class="add-btn">Add</button>
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
      <tr>
        <td>1</td>
        <td>Coursera</td>
        <td>Learn AWS</td>
        <td>2025-12-12</td>
        <td><input type="checkbox"></td>
      </tr>
      <tr>
        <td>2</td>
        <td>Udemy</td>
        <td>Learn Devops</td>
        <td>2026-06-12</td>
        <td><input type="checkbox"></td>
      </tr>
      <tr>
        <td>3</td>
        <td>Edex</td>
        <td>Learn Full Stack</td>
        <td>2026-12-12</td>
        <td><input type="checkbox"></td>
      </tr>
    </tbody>
  </table>
  </div>
</body>

</html>