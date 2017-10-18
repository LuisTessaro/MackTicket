/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.controllers.impl;

import br.mack.controllers.AbstractController;
import br.mack.dao.TicketDAO;
import br.mack.dao.impl.TicketDAOimpl;
import br.mack.entity.TicketEntity;

/**
 *
 * @author Luis
 */
public class MyTicketsController extends AbstractController {

    @Override
    public void execute() {
        String id = this.getRequest().getParameter("idCreate");
        String content = this.getRequest().getParameter("contentCreate");
        String photo_url = this.getRequest().getParameter("photoCreate");
        String user_idString = this.getRequest().getSession().getAttribute("idUser").toString();
        String secretary_idString = this.getRequest().getParameter("secretaryCreate");
        
        TicketEntity t = new TicketEntity();
        t.setUser_id(user_idString);
        t.setContent(content);
        t.setPhoto_url(photo_url);
        t.setSecretary_id(secretary_idString);
        t.setIdString(id);

        TicketDAO dao = new TicketDAOimpl();
        if(dao.update(t)){
            setReturnPage("/mytickets.jsp");
        }else{
            setReturnPage("/erro.jsp");
        }
    }
}
