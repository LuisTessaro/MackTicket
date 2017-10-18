<%-- 
    Document   : home
    Created on : 12/10/2017, 10:56:37
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" href="css/style.css">
        <title>MackTicket - Home</title>
    </head>
    <body>
        <h1>Mack Ticket - Home</h1>

        <form class="cf" action="ticket.jsp">
            <input type="submit" value="Gere um ticket" id="input-submit">
        </form>

        <form class="cf" action="mytickets.jsp">
            <input type="submit" value="Veja seu(s) ticket(s)" id="input-submit">
            <input type="hidden" name="control" value="MyTickets" />
        </form>

        <form class="cf" action="index.jsp">
            <input type="submit" value="Sair" id="input-submit">
        </form>
    </body>
</html>
