<%-- 
    Document   : usercrud
    Created on : 08/10/2017, 15:33:00
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrontController" method="post">
            Tia: <input type="text" name="tia"><br>
            Senha <input type="password" name="password"><br>
            <input type="hidden" name="control" value="User" />
            <input type="hidden" name="controlType" value="Register" />
            <input type="submit" value="Submit">
        </form>   
        <form action="FrontController" method="post">
            <input type="hidden" name="control" value="User" />
            <input type="hidden" name="controlType" value="ReadAll" />
            <input type="submit" value="Checar todos valores">
        </form>
        <form action="FrontController" method="post">
            dê update nas coisa aqui<br>
            Tia: <input type="text" name="tia"><br>
            Senha <input type="password" name="password"><br>
            <input type="hidden" name="control" value="User" />
            <input type="hidden" name="controlType" value="Update" />
            <input type="submit" value="Submit">
        </form>  
        <form action="FrontController" method="post">
            delete aqui<br>
            Tia: <input type="text" name="tia"><br>
            <input type="hidden" name="control" value="User" />
            <input type="hidden" name="controlType" value="Delete" />
            <input type="submit" value="Submit">
        </form>
        <form action="FrontController" method="post">
            Procure aqui<br>
            Tia: <input type="text" name="tia"><br>
            <input type="hidden" name="control" value="User" />
            <input type="hidden" name="controlType" value="Search" />
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
