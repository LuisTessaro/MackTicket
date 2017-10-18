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
public class TicketCreationController extends AbstractController {

    @Override
    public void execute() {

        String secretaryCreate = this.getRequest().getParameter("secretaryCreate");
        String photoCreate = this.getRequest().getParameter("photoCreate");
        String contentCreate = this.getRequest().getParameter("contentCreate");
        if (secretaryCreate != null && photoCreate != null && contentCreate != null) {
            TicketEntity t = new TicketEntity();
            TicketDAO dao = new TicketDAOimpl();

            t.setContent(contentCreate);
            t.setPhoto_url(photoCreate);
            t.setSecretary_id(secretaryCreate);
            t.setUser_id(this.getRequest().getSession().getAttribute("idUser").toString());
            
            if (dao.create(t)) {
                this.setReturnPage("/sucesso.jsp");
            } else {
                this.setReturnPage("/erro.jsp");
            }
        } else {
            this.setReturnPage("/erro.jsp");
        }

    }
}
