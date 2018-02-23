<%-- 
    Document   : Logup
    Created on : Feb 23, 2018, 3:00:19 AM
    Author     : Ghada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet href="resource/css1.css" type="text/css">
        <script src=http://code.jquery.com/jquery-latest.min.js></script>
        <title>Logup Page</title>
    </head>
    <body>
        <div class="testbox" >
            <center><h1>Registeration</h1> </center>

            <hr><br><center>
                Username: <input type="text" colspan="2" name="userName" id="userName" required="true" />
            </center>
            <center>
                Your Mail: <input type="text" colspan="2" name="email" id="email" required="true" />
            </center>
            <center>
                Password: <input type="password" name="password" id="password" required="true"/>
            </center>
            <center>
                <a href="Login.jsp">   
                    <button id="loginButton" onclick="Register()"> Register </button>
                </a>
            </center>
        </div>
        <script>
            function Register() {
                var userName = $("#userName").val();
                var email = $("#email").val();
                var password = $("#password").val();
                var jsonUser = {"userName": userName, "email": email, "password": password};

                $.ajax({url: 'LogupServlet',
                    type: 'GET',
                    contentType: 'application/json',
                    data: jsonUser,
                    success: function (data) {
                        alert("Done");
                    }
                });
            }

        </script>
    </body>
</html>
