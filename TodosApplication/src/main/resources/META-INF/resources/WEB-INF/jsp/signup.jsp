<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/signup.css">
    <title>Todos Application | Signup</title>
</head>

<body>
    <div class="container">
        <div>
            <h1><span>Create Account</span></h1>
        </div>
        <form method="POST">
            <div class="input-div">
                <label for="Name">Full Name</label>
                <input type="text" placeholder="Enter your full name" class="inp" name="username">
            </div>
            <div class="input-div">
                <label for="Email">Email</label>
                <input type="email" placeholder="Enter your email" class="inp" name="email">
            </div>
            <div class="input-div">
                <label for="password">Password</label>
                <input type="password" placeholder="Create a password" class="inp" name="password">
            </div>
            <div class="input-div">
                <button id="submit-btn">Register</button>
            </div>
        </form>
        <div class="login-link">
            <p>Already have an account? <a href="<c:url value='/login' />">Login</a></p>
        </div>
    </div>

</body>

</html>