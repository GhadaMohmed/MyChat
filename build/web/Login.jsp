<%-- 
    Document   : Login
    Created on : Feb 23, 2018, 3:21:31 AM
    Author     : Ghada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet href="resource/css1.css" type="text/css">
        <title>Login Page</title>
    </head>
    <body>
        <div class="testbox" >
            <center><h1>Login Form</h1> </center>
            <form method="post" action="LoginServlet">
                <hr><br><center>
                    Username: <input type="text" colspan="2" name="userName" id="userName" required="true" />
                </center>

                <center>
                    Password: <input type="password" name="password" id="password" required="true"/>
                </center>
                <center>
                <input type="submit" id="loginButton"/>
                </center>
            </form>
        </div>

    </body>
</html>
