<%-- 
    Document   : Home
    Created on : Feb 23, 2018, 6:02:23 PM
    Author     : Ghada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet href="resource/css1.css" type="text/css">
        <script src=http://code.jquery.com/jquery-latest.min.js></script>
        <title>Chat Page</title>
        <script>
            function sendFn() {
                var name = $("#name").val();
                var msg = $("#msg").val();
                var jsonData = {"name": name, "message": msg};
                console.log(jsonData);
                $.ajax({url: 'ChatServlet',
                    type: 'GET',
                    contentType: 'application/json',
                    data: jsonData,
                    dataType: 'json',
                    success: function (data) {
                    }
                });
            }

            function render() {
                $.ajax({url: 'ChatServlet',
                    type: 'post',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        messages = data;
                        $("#myTable tr").remove();
                        for (i = 0; i < messages.length; i++) {
                            $("#myTable").append('<tr><td>' + messages[i].name + '</td><td>' + messages[i].msg + '</td></tr>');

                        }
                    }
                });
                $.ajax({url: 'FriendsServlet',
                    type: 'post',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        friend = data;
                        $("#friendList tr").remove();
                        for (i = 0; i < friend.length; i++) {
                            $("#friendList").append('<tr><td>' + friend[i].userName + '</td><td>' + friend[i].myStatus + '</td></tr>');

                        }
                    }
                });
            }
        </script>
    </head>
    <body onload="setInterval('render()', 1000)">
        <div class="testbox" >
            <center><h1>Chat App</h1> </center>

            <div id="page1"><center>
                    <input placeholder="Message" name="msg" id="msg"/>
                    <input type="button" value="Send" id="btn" onclick="sendFn()"/>
                </center></div>

            <center><div id="msgsTable">
                    <table border="1">
                        <tr>      
                            <td>Sender</td>
                            <td>Message</td>            
                        </tr>
                    </table>
                    <table border="1" id="myTable">

                    </table>
                </div></center>

            <center><div id="friendsTable">
                    <table border="1">
                        <tr>      
                            <td>Friend</td>
                            <td>Status</td>            
                        </tr>
                    </table>
                    <table border="1" id="friendList">

                    </table>
                </div></center>


            <center><form method="get" action="LogoutServlet">
                    <input type="submit" value="Logout"/>
                </form></center>
        </div>

    </body>
</html>

