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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" 
              crossorigin="anonymous">
        <title>Locations</title>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
        crossorigin="anonymous"></script>
        <script src="https://api-maps.yandex.ru/2.0/?load=package.standard&lang=en-US" type="text/javascript"></script>
    </head>

    <body>
        <div class="container">
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
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>
            <form:form id="logout-form" action="logout" method="POST">
            </form:form>
            <div class="jumbotron">
                <div id="wrap" style=" height:500px">
                    <div id="map" style="width:100%; height:100%"></div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="https://getbootstrap.com/assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="https://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="https://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
        <script>
                                var myMap;

                                ymaps.ready(init);

                                function init() {
                                    myMap = new ymaps.Map('map', {
                                        center: [53.55, 10.0],
                                        zoom: 4
                                    });
                                    var coords = [
                                        [50.00, 36.23], [50.45, 30.52], [51.50, -0.12],
                                        [44.49, 34.16], [49.44, 32.05], [51.70, 36.15],
                                        [46.48, 30.72], [46.77, 36.80], [49.04, 37.57],
                                        [49.58, 34.55], [51.28, -0.75]
                                    ],
                                            myCollection = new ymaps.GeoObjectCollection({}, {
                                                preset: 'twirl#blueIcon',
                                                draggable: false
                                            });
                                    for (var i = 0; i < coords.length; i++) {
                                        myCollection.add(new ymaps.Placemark(coords[i]));
                                    }

                                    myMap.geoObjects.add(myCollection);


                                }
        </script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
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

</html>