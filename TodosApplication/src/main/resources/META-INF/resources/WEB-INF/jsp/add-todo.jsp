<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>
    <%@ include file="common/header.jspf" %>
    <link rel="stylesheet" href="/css/add-todo.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todos Application | Add</title>
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
                   <li><a href="<c:url value='/login' />"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
               </ul>
           </div>
   </nav>
    <div class="container">
        <div>
            <h1><span>Enter Details</span></h1>
        </div>
        <form:form method="POST" modelAttribute="newTodoItem">
            <div class="input-div">
            <fieldset class="mb-3">
                <label path="description">Description</label>
                <form:input type="text" class="inp" path="description" required="required"/>
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>
            </div>
            <div class="input-div">
            <fieldset class="mb-3">
                <label path="date">Target Date</label>
                <form:input type="date" class="inp" path="date" required="required"/>
                <form:errors paths="date" cssClass="text-warning"/>
            </fieldset>
            </div>
            <form:hidden path="username" />
            <div class="input-div">
                <button id="submit-btn">Add</button>
            </div>
        </form:form>
    </div>
    </div>
    <%@ include file="common/footer.jspf" %>
</body>

</html>