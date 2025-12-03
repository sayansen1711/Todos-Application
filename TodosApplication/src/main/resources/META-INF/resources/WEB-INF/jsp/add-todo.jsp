<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/add-todo.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todos Application | Add</title>
</head>

<body>
    <div class="container">
        <div>
            <h1><span>Add Todo Activity</span></h1>
        </div>
        <form:form method="POST" modelAttribute="todos">
            <div class="input-div">
                <label for="description">Description</label>
                <form:input type="text" class="inp" path="description" required="required"/>
            </div>
            <div class="input-div">
                <label for="target-date">Target Date</label>
                <form:input type="date" class="inp" path="date" required="required"/>
            </div>
            <form:hidden path="username" />
            <div class="input-div">
                <button id="submit-btn">Add</button>
            </div>
        </form:form>
    </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>

</html>