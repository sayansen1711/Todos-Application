<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/login.css">
  <title>Todos Application | Login</title>
</head>

<body>

  <body>
    <div class="container">
      <div>
        <h1><span>Login</span></h1>
      </div>
      <form method="POST">
        <div class="input-div">
          <label for="Name">Username</label>
          <input type="text" placeholder="Enter your username" class="inp" name="username">
          <!-- <input type="checkbox" id="remember" value="Remember Me">Remember Me -->
        </div>
        <div class="input-div">
          <label for="password">Password</label>
          <input type="password" placeholder="Enter your password" class="inp" name="password">
          <p id="pswrd-reset-link"><a href="#">Forgot password?</a></p>
        </div>
        <div class="input-div">
          <button id="submit-btn">Sign In</button>
        </div>
      </form>
      <div class="login-link">
        <p>Don not have an account? <a href="<c:url value='/signup' />">Sign Up</a></p>
      </div>
    </div>
  </body>
</body>

</html>