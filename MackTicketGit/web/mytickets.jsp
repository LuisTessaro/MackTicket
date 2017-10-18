<%-- 
    Document   : mytickets
    Created on : 12/10/2017, 12:27:43
    Author     : Luis
--%>

<%@page import="br.mack.dao.impl.TicketDAOimpl"%>
<%@page import="br.mack.dao.TicketDAO"%>
<%@page import="br.mack.entity.TicketEntity"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>MackTicket - Meus Tickets</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <h1>Mack Ticket - Seus Tickets</h1>
        <br>
        <%
            TicketDAO dao = new TicketDAOimpl();
            List<TicketEntity> tickets = dao.getAllTickets(session.getAttribute("idUser").toString());
            //out.println(tickets.get(i));
            int c = 1;
            for (int i = 0; i < tickets.size(); i++) {
                out.println("<h1>Ticket " + c++ + ":</h1>"+tickets.get(i).getId());
                out.println("<form class='cf' action='FrontController' method='post'>");
                out.println("<div class='half left cf'>");
                out.println("<select name='secretaryCreate'>");
                if (tickets.get(i).getSecretary_id().equals("1")) {
                    out.println("<option value='select' disabled>Seleciona uma secretaria</option>");
                    out.println("<option selected='selected' value='1'>Ciência da Computação</option>");
                    out.println("<option value='2'>Secretaria geral</option>");
                    out.println("<option value='3'>Engenharia</option>");
                } else if (tickets.get(i).getSecretary_id().equals("2")) {
                    out.println("<option value='select' disabled>Seleciona uma secretaria</option>");
                    out.println("<option value='1'>Ciência da Computação</option>");
                    out.println("<option selected='selected' value='2'>Secretaria geral</option>");
                    out.println("<option value='3'>Engenharia</option>");
                } else if (tickets.get(i).getSecretary_id().equals("3")) {
                    out.println("<option value='select' disabled>Seleciona uma secretaria</option>");
                    out.println("<option value='1'>Ciência da Computação</option>");
                    out.println("<option value='2'>Secretaria geral</option>");
                    out.println("<option selected='selected' value='3'>Engenharia</option>");
                }
                out.println("</select>");
                out.println("<input type='text' placeholder='Foto' name='photoCreate' value='" + tickets.get(i).getPhoto_url() + "'>");
                out.println("<input type='text' placeholder='Conteúdo do seu ticket' name='contentCreate' value='" + tickets.get(i).getContent() + "'>");
                out.println("<br><img src='" + tickets.get(i).getPhoto_url() + "' height='400' width='600'>");
                out.println("<input type='hidden' name='idCreate' value='"+tickets.get(i).getId()+"' />");
                out.println("<input type='hidden' name='control' value='MyTickets' />");
                out.println("</div>");
                out.println("<input type='submit' value='Alterar' id='input-submit'>");
                out.println("</form>");
            }%>
        <form class="cf" action="home.jsp">
            <input type="submit" value="Voltar" id="input-submit">
        </form>
    </body>
</html>
