<%-- 
    Document   : edit
    Created on : 24-Feb-2017, 19:16:00
    Author     : toxa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        crossorigin="anonymous"></script>
        <title>Register</title>

    </head>
    <body >
        <div class="container">

            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="index"><img src="resources/img/logo.png" height="60px"></a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <form:form id="reg" name="fields" action="add_user" method="POST">
                    <table id="reg1">
                        <th><h2>Register page</h2></th>
                        <tr><td>${msg}<br/></td></tr>
                        <tr>
                            <td><form:input path="firstName" type="text" value="" placeholder="First name"/></td>
                        </tr><tr><td><br/></td></tr>
                        <tr>
                            <td><form:input path="lastName" type="text" value="" placeholder="Last name"/></td>
                        </tr><tr><td><br/></td></tr>
                        <tr>
                            <td><select id="countrieslist" style="width: 190px" onchange="loadCities(this.value);">
                                    <option value="" disabled selected>Select country</option>
                                </select></td>
                        </tr><tr><td><br/></td></tr>
                        <tr>
                            <td><form:select id="townlist" path="nativeTown" style="width: 190px">
                                    <form:option value="">Select town</form:option>
                                </form:select></td>
                        </tr><tr><td><br/></td></tr>            
                        <tr>
                            <td><form:input path="email" type="email" value="" placeholder="email (login)"/></td>
                        </tr>
                        <tr><td><br/></td></tr>
                        <tr>
                            <td><form:input path="password" type="password" value="" placeholder="password"/></td>
                        </tr>
                        <tr><td><br/></td></tr>
                        <tr>
                            <td><input name="confirm" type="password" value="" placeholder="confirm password"/></td>
                        </tr>
                        <tr><td><br/></td></tr>
                        <tr>
                            <td><input class="btn btn-primary"  type="submit" value="Submit"/></td>
                        </tr>
                    </table>
                </form:form>
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
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
                                $(document).ready(function () {
                                    $("#countrieslist").load("resources/html/countries_html.html");
                                });
                                function loadCities(item) {
                                    $("#townlist").load("resources/html/" + item + ".html");
                                }

                                function getTowns() {
                                    $.ajax({
                                        url: 'getTowns',
                                        success: function (data) {
                                            alert(arr);
                                        },
                                        error: function () {
                                            alert("Error");
                                        }
                                    });
                                }
        </script>   
    </body>
</body>
</html>