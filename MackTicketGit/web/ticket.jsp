<%-- 
    Document   : ticket
    Created on : 12/10/2017, 10:57:59
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MackTicket - Gerar</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h1>Mack Ticket - Gere um ticket</h1>
        <form class="cf" action="FrontController" method="post">
            <div class="half left cf">
                <select name="secretaryCreate">
                    <option selected="selected" value="select" disabled>Seleciona uma secretaria</option>
                    <option value="1">Ciência da Computação</option>
                    <option value="2">Secretaria geral</option>
                    <option value="3">Engenharia</option>
                </select>
                <input type="text" placeholder="Foto" name="photoCreate">
                <input type="text" placeholder="Conteúdo do seu ticket" name="contentCreate">
                <input type="hidden" name="control" value="TicketCreation" />
            </div>
            <input type="submit" value="Gerar" id="input-submit">
        </form>
        
        <form class="cf" action="home.jsp">
            <input type="submit" value="Voltar" id="input-submit">
        </form>
        
    </body>
</html>
