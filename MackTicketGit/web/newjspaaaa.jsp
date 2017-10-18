<%-- 
    Document   : newjspaaaa
    Created on : 12/10/2017, 13:05:28
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
        <form class="cf" action="sucesso.html">
            <div class="half left cf">
                <select>
                    <option value="padrao" disabled>Seleciona uma secretaria</option>
                    <option value="cc">Ciência da Computação</option>
                    <option selected value="geral">Secretaria geral</option>
                    <option value="engenharia">Engenharia</option>
                </select>
                <input type="text" id="input-subject" placeholder="Assunto" value="Tempo de espera"><br>
                <div>
                    <img src="http://animals.sandiegozoo.org/sites/default/files/2016-09/Otter_ZN.jpg" height="400" width="600">
                </div> 
            </div>
            <div class="half right cf">
                <textarea name="message" type="text" id="input-message" placeholder="Conteúdo do seu ticket">Esperei duas horas para ser atendido.</textarea>
            </div>
            <input type="submit" value="Alterar" id="input-submit">
        </form>
    </body>
</html>
