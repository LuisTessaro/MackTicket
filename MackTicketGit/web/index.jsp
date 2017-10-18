<%-- 
    Document   : index
    Created on : 12/09/2017, 03:25:58
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MackTicket</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <form class="cf" action="FrontController" method="post">
            <div class="half left cf">
                <input type="tel" placeholder="Tia" name="tia">
                <input type="hidden" name="control" value="Login" />
            </div>
            <input type="submit" value="Login" id="input-submit">
        </form>
        <br><br>
        <form action="usercrud.jsp" method="post">
            <input type="submit" value="CRUD user">
        </form> 
        <br><br>
        <form action="ticketcrud.jsp" method="post">
            <input type="submit" value="CRUD ticket">
        </form> 


    </body>
</html>
