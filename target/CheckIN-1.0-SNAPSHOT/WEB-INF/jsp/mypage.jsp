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
        <title>User`s page</title>

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
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#" onclick="document.getElementById('logout-form').submit();"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <form:form id="logout-form" action="logout" method="POST">
            </form:form>
            <div class="jumbotron" >
                <div id="usr" onclick="hideForm();">
                    <table>
                        <tr>
                            <td><img src="resources/img/user.png" width="340px"></td>
                            <td><h2>My page</h2></td>
                        </tr>
                    </table>
                </div>
                <div>
                    <button id="adb" class="btn btn-primary" onclick="showForm();">Add new note</button>
                </div>
                <div id="addNote" >
                    <form:form id="newNote" >
                        <table>
                            <th class="name">
                                <form:input path="name" type="text" placeholder="Name"/>
                            </th>
                            <tr class="text">
                                <td>
                                    <form:input path="text" type="text" placeholder="Enter your note" style="height: 100px"/>
                                </td>
                            </tr>
                            <tr class="photos">
                                <td>
                                    <input path="photos" type="file" placeholder="Name" multiple="true"/>
                                </td>
                            </tr>
                            <tr class="location">
                                <td>
                                    <select id="countrieslist" style="width: 190px" onchange="loadCities(this.value);">
                                        <option value="" disabled selected>Select country</option>
                                    </select>
                                </td>
                            </tr>
                            <tr class="location">
                                <td>
                                    <form:select id="townlist" path="location" style="width: 190px">
                                        <form:option value="">Select town</form:option>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input class="btn btn-primary" type="submit" value="submit">
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </div>
                <div id = "notesfield">
                    <div class="glyphicon">
                        <table>
                            <th class="name">London is the capital of Great Britain</th>
                            <tr class="text">
                                <td>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vulputate imperdiet felis, nec gravida nunc euismod sit amet. Vestibulum finibus, lectus et ultricies dapibus, eros eros dictum diam, in pellentesque sem mi porta massa. Vivamus tempus tempor massa. Etiam ultricies lacus ac egestas vulputate. Fusce euismod at orci eu egestas. Aliquam dignissim massa enim, nec pellentesque elit pulvinar eleifend. Morbi faucibus sem nec ante porta viverra. Mauris ultricies malesuada est, a viverra arcu posuere in. Phasellus eu enim dapibus, sollicitudin tellus vel, ultrices dui. Nam at tincidunt ante, et rutrum libero. Morbi id lectus quis ante scelerisque varius. Ut erat sapien, semper eget libero ut, bibendum interdum massa. Vestibulum dignissim erat nec viverra fermentum.

                                </td>
                            </tr>
                            <tr class="photos">
                                <td><img src="resources/img/user.png" height="50"/></td>
                                <td><img src="resources/img/messages.png" height="50"/></td>
                                <td><img src="resources/img/settings.png" height="50"/></td>
                            </tr>
                            <tr class="location">
                                <td>
                                    London, UK
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="glyphicon">
                        <table>
                            <th class="name">London is the capital of Great Britain</th>
                            <tr class="text">
                                <td>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vulputate imperdiet felis, nec gravida nunc euismod sit amet. Vestibulum finibus, lectus et ultricies dapibus, eros eros dictum diam, in pellentesque sem mi porta massa. Vivamus tempus tempor massa. Etiam ultricies lacus ac egestas vulputate. Fusce euismod at orci eu egestas. Aliquam dignissim massa enim, nec pellentesque elit pulvinar eleifend. Morbi faucibus sem nec ante porta viverra. Mauris ultricies malesuada est, a viverra arcu posuere in. Phasellus eu enim dapibus, sollicitudin tellus vel, ultrices dui. Nam at tincidunt ante, et rutrum libero. Morbi id lectus quis ante scelerisque varius. Ut erat sapien, semper eget libero ut, bibendum interdum massa. Vestibulum dignissim erat nec viverra fermentum.

                                </td>
                            </tr>
                            <tr class="photos">
                                <td><img src="resources/img/user.png" height="50"/></td>
                                <td><img src="resources/img/messages.png" height="50"/></td>
                                <td><img src="resources/img/settings.png" height="50"/></td>
                            </tr>
                            <tr class="location">
                                <td>
                                    London, UK
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
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
                                            hideForm();
                                            $("#countrieslist").load("resources/html/countries_html.html");
                                        });
                                        function loadCities(item) {
                                            $("#townlist").load("resources/html/" + item + ".html");
                                        }
                                        function showForm() {
                                            $("#addNote").show();
                                            $("#adb").hide();
                                            document.getElementById("usr").style.cursor = "pointer";
                                        }
                                        function hideForm() {
                                            $("#adb").show();
                                            $("#addNote").hide();
                                            document.getElementById("usr").style.cursor = "default";
                                        }
        </script>
    </body>
</body>
</html>
