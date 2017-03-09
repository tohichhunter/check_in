<%-- 
    Document   : edit
    Created on : 24-Feb-2017, 19:16:00
    Author     : toxa
--%>

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
        <title>Conversations</title>

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
                            <li><a href="locations"><img src="resources/img/250_location_logo.png" width="50px"></a></li>
                            <li><a href="conversations"><img src="resources/img/messages.png" width="50px"></a></li>
                            <li><a href="edit"><img src="resources/img/settings.png" width="50px"></a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#" onclick="document.getElementById('logout-form').submit();"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <form:form id="logout-form" action="logout" method="POST">
            </form:form>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <h2>Conversations list</h2>


                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vulputate imperdiet felis, nec gravida nunc euismod sit amet. Vestibulum finibus, lectus et ultricies dapibus, eros eros dictum diam, in pellentesque sem mi porta massa. Vivamus tempus tempor massa. Etiam ultricies lacus ac egestas vulputate. Fusce euismod at orci eu egestas. Aliquam dignissim massa enim, nec pellentesque elit pulvinar eleifend. Morbi faucibus sem nec ante porta viverra. Mauris ultricies malesuada est, a viverra arcu posuere in. Phasellus eu enim dapibus, sollicitudin tellus vel, ultrices dui. Nam at tincidunt ante, et rutrum libero. Morbi id lectus quis ante scelerisque varius. Ut erat sapien, semper eget libero ut, bibendum interdum massa. Vestibulum dignissim erat nec viverra fermentum.

                Nulla varius ultricies erat in maximus. Sed tortor tellus, dictum at turpis eget, rhoncus posuere diam. Nam risus enim, placerat eu dui ut, viverra rutrum augue. Sed vestibulum placerat augue sollicitudin maximus. Etiam varius, metus suscipit posuere sagittis, justo purus malesuada ex, id ullamcorper nisl velit id orci. Aenean orci metus, aliquam quis nulla et, finibus feugiat nulla. Donec porttitor magna dictum ex tristique, ac pharetra diam ullamcorper. Cras vel consequat quam. Vivamus ultrices massa vitae turpis suscipit sollicitudin.

                Sed posuere lacus sem, et bibendum turpis mollis vel. Morbi condimentum, nisi ut laoreet rutrum, enim purus consequat ante, vel sodales libero mauris ut nibh. Phasellus finibus ex et tempus bibendum. Sed tincidunt auctor semper. Suspendisse malesuada tortor ut augue tempor volutpat. Duis ac dictum ipsum. Nulla sed purus ut tellus tristique suscipit. Aliquam rutrum vulputate nunc in tristique. Praesent pretium dictum eros vitae ultricies. Duis vitae porttitor elit. Vestibulum lorem ante, fermentum non feugiat vehicula, ultricies nec orci. Integer pharetra nisi eget faucibus dictum. Ut feugiat leo nec orci convallis pharetra. Morbi elementum lobortis ullamcorper.

                Donec sagittis porttitor sem, id luctus ex accumsan in. Nulla tincidunt eu sapien eget convallis. Donec in facilisis nulla. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque metus mi, bibendum sed ultrices vel, volutpat sit amet enim. Maecenas metus lacus, rutrum eu nulla nec, maximus rutrum nulla. Vestibulum urna augue, dapibus hendrerit nisi sed, laoreet maximus erat. Pellentesque nec varius diam. Aliquam volutpat at purus eget congue. Morbi molestie maximus lacus at facilisis. Proin egestas ut sapien eget cursus. Phasellus tincidunt consequat est, ut imperdiet libero posuere ut.

                Proin eleifend enim a arcu consectetur aliquam. Proin ac pretium lorem, at efficitur orci. Mauris eget leo et nulla ullamcorper placerat. Vivamus non vulputate nisl. Fusce pharetra, velit et tincidunt pulvinar, magna massa semper massa, non gravida nisl est eget mi. Nullam rutrum elementum scelerisque. Nunc elit justo, commodo non tellus eu, mattis volutpat tortor. Nam porttitor dignissim porta. Aliquam venenatis nibh euismod imperdiet molestie. Phasellus consectetur euismod dui, porttitor lobortis quam ornare et. Praesent auctor purus urna, et iaculis purus commodo vitae. Duis ac quam id justo volutpat vestibulum. Integer malesuada urna quis rhoncus rhoncus. 
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
