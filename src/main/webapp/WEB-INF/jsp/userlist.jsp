<%-- 
    Document   : userlist
    Created on : 24-Mar-2017, 15:49:35
    Author     : toxa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" 
              crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
        crossorigin="anonymous"></script>
        <title>users</title>

    </head>
    <body >
        <div class="container">

            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="index"><img src="resources/img/logo.png" height="60px"></a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="mypage"><img src="resources/img/user.png" width="50px"></a></li>
                            <li><a href="userlist"><img src="resources/img/users.png" width="50px"></a></li>
                            <li><a href="locations"><img src="resources/img/250_location_logo.png" width="50px"></a></li>
                            <li><a href="conversations"><img src="resources/img/messages.png" width="50px"></a></li>
                            <li><a href="edit"><img src="resources/img/settings.png" width="50px"></a></li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <c:forEach items="${users}" varStatus="i">
                    <div class="glyphicon" style="border: 2px solid; border-radius: 5px">
                        <table>
                            <th class="name">${users[i.index].firstName}</th>
                            <tr class="text">
                                <td>${users[i.index].email}</td>
                            </tr>
                            <tr class="button">
                                <td><a href="conversation_?part=${users[i.index].email}" >Write to</a></td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
            </div>

        </div> <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="https://getbootstrap.com/assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="https://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="https://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</body>
</html>
