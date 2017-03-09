<%-- 
    Document   : edit
    Created on : 24-Feb-2017, 19:16:00
    Author     : toxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Login</title>
        
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
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
    </ul>
          </div>
        </div>
      </nav>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
          <form id="reg" action="j_spring_security_check"  method="POST">
        <table id="reg1">
            <th><h2>Login page</h2></th>
           
            <tr>
                <td><input name="j_username" type="email" value="" placeholder="email (login)"/></td>
                </tr><tr><td><br/></td>
            </tr>
            
            <tr>
                <td><input name="j_password" type="password" value="" placeholder="password"/></td>
                </tr><tr><td><br/></td>
            </tr>
           
            <tr>
                <td><input class="btn btn-primary" type="submit" value="Submit"/></td>
                </tr><tr><td><br/></td>
            </tr>
            
            <tr>
                <td><input name="_spring_security_remember_me" type="checkbox" /> stay signed in</td>
            </tr>
        </table>
             <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
          </form>
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