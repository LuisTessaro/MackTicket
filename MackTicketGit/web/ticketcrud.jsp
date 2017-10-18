<%-- 
    Document   : ticketcrud
    Created on : 08/10/2017, 15:33:30
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
            Content: <input type="text" name="content"><br>
            URL da imagem: <input type="text" name="photo"><br>
            user_id: <input type="text" name="user_id"><br>
            secretary_id: <input type="text" name="secretary_id"><br>
            <input type="hidden" name="control" value="Ticket" />
            <input type="hidden" name="controlType" value="Register" />
            <input type="submit" value="Submit">
        </form>   
        <form action="FrontController" method="post">
            <input type="hidden" name="control" value="Ticket" />
            <input type="hidden" name="controlType" value="ReadAll" />
            <input type="submit" value="Checar todos valores">
        </form>
        <form action="FrontController" method="post">
            dê update nas coisa aqui<br>
            Content: <input type="text" name="content"><br>
            URL da imagem: <input type="text" name="photo"><br>
            Id: <input type="text" name="id"><br>
            <input type="hidden" name="control" value="Ticket" />
            <input type="hidden" name="controlType" value="Update" />
            <input type="submit" value="Submit">
        </form>  
        <form action="FrontController" method="post">
            delete aqui<br>
            Id: <input type="text" name="id"><br>
            <input type="hidden" name="control" value="Ticket" />
            <input type="hidden" name="controlType" value="Delete" />
            <input type="submit" value="Submit">
        </form>
        <form action="FrontController" method="post">
            Procure aqui<br>
            Id: <input type="text" name="id"><br>
            <input type="hidden" name="control" value="Ticket" />
            <input type="hidden" name="controlType" value="Search" />
            <input type="submit" value="Submit">
        </form>

    </body>
</html>
