<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <form:form action="/signup" method="post" modelAttribute="signup">
            <div class="input-div">
                <label for="Name">Full Name</label>
                <form:input path="username" type="text" placeholder="Enter your full name" class="inp" name="username" required="required"/>
                <form:errors path="username" cssClass="field-error"/>
            </div>
            <div class="input-div">
                <label for="Email">Email</label>
                <form:input path="email" type="email" placeholder="Enter your email" class="inp" name="email" required="required"/>
                <form:errors path="email" cssClass="field-error"/>
            </div>
            <div class="input-div">
                <label for="password">Password</label>
                <form:input path="password" type="password" placeholder="Create a password" class="inp" name="password" required="required"/>
                <form:errors path="password" cssClass="field-error"/>
            </div>
            <div class="input-div">
                <button id="submit-btn" type="submit">Sign Up</button>
            </div>
        </form:form>
        <div class="login-link">
            <p>Already have an account? <a href="<c:url value='/login' />">Login</a></p>
        </div>
    </div>

</body>

</html>