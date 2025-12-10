<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="common/header.jspf" %>
    <link rel="stylesheet" href="/css/welcome.css">
    <title>Todos Application | Welcome</title>
</head>

<body>
    <nav class="navbar navbar-inverse">
             <div class="container-fluid">
                 <div class="navbar-header">
                     <a class="navbar-brand" href="#">Todos Application</a>
                 </div>
                 <ul class="nav navbar-nav">
                     <li class="active"><a href="welcome">Home</a></li>
                     <li><a href="todo-page">My Todos</a></li>
                 </ul>
                 <ul class="nav navbar-nav navbar-right">
                     <li><a href="#"><span class="glyphicon glyphicon-user"></span> My Profile</a></li>
                     <li><a href="<c:url value='/logout' />"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                 </ul>
             </div>
     </nav>
    <div class="welcome-page">
        <div class="wlcm-text">
            <h1>Welcome to Todos Application</h1>
            <span><a href="todo-page"><u>Manage</u></a> your todos</span>
        </div>
        <%@ include file="common/footer.jspf" %>
</body>

</html>