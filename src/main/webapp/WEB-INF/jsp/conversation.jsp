<%-- 
    Document   : edit
    Created on : 24-Feb-2017, 19:16:00
    Author     : toxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Conversation</title>
        <style>
            .text,.name{
                width: 100%; border-radius: 3px; color: #3b364c; background-color: #fcf376;
            }   

            .scrollable{
                background-color: whitesmoke; border-radius: 10px;
            }
            .time{
                color: #2580a8;
            }
        </style>
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
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <form:form id="logout-form" action="logout" method="POST">
            </form:form>

            <div class="jumbotron">
                <h2>Conversation page</h2>
                <div id="scroll" class="scrollable" style="overflow-y: scroll; height:400px;">
                    <c:set var="msglist" value="${command.getMessages()}"/>
                    <c:forEach items="${msglist}" varStatus="i">
                        <div class="glyphicon" style="border: 1px solid; border-radius: 10px">
                            <table>
                                <th>${msglist[i.index].sender}</th>
                                <tr class="text">
                                    <td>${msglist[i.index].text}</td>
                                </tr>
                                <tr class="time">
                                    <td>${msglist[i.index].addtime}</td>
                                </tr>
                            </table><br/>
                        </div>
                    </c:forEach>

                </div>
                <div>
                    <br/>

                    <table style="width:100%">
                        <tr>
                            <td>
                                <form:form commandName="command" id ="newMsg">
                                    <textarea class="text" id ="msgTxt" type="textarea" placeholder="Message text here" 
                                              style="height: 50px; resize: none;">
                                    </textarea> 
                                    <form:input id="convName" path="conversationName" type="hidden" />
                                </form:form>
                            </td>
                            <td>
                                <button class="btn btn-primary" onclick="addMsg();">Send</button>
                            </td>
                        </tr>
                    </table>             
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
        <script>
                                    function addMsg() {
                                        var txt = $('#msgTxt').val();
                                        var cvrs = $('#convName').val();
                                        var cmd = {txt: txt, conversation: cvrs};
                                        $.ajax({
                                            url: 'addMessage?${_csrf.parameterName}=${_csrf.token}',
                                            type: "POST",
                                            data: cmd,
                                            success: function (data) {
                                                alert("Message added" + data);
                                            },
                                            error: function () {
                                                alert("Error");
                                            }
                                        });
                                        $('#msgTxt').val(cnvrs);
                                    }
        </script>
    </body>
</html>
