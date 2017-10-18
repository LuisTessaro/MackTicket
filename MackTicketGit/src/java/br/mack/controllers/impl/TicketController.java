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
import java.util.List;

/**
 *
 * @author Luis
 */
public class TicketController extends AbstractController {

    @Override
    public void execute() {
        String ctrlType = this.getRequest().getParameter("controlType");
        String content = this.getRequest().getParameter("content");
        String photo_url = this.getRequest().getParameter("photo");
        String user_idString = this.getRequest().getParameter("user_id");
        String secretary_idString = this.getRequest().getParameter("secretary_id");
        String idString = this.getRequest().getParameter("id");

        TicketEntity t = new TicketEntity();
        t.setUser_id(user_idString);
        t.setContent(content);
        t.setPhoto_url(photo_url);
        t.setSecretary_id(secretary_idString);
        t.setIdString(idString);

        TicketDAO dao = new TicketDAOimpl();

        switch (ctrlType) {
            case "Register":
                if (dao.create(t)) {
                    System.out.println("deu certo");
                } else {
                    System.out.println("Deu ruim");
                }
                break;
            case "ReadAll":
                List<TicketEntity> tickets = dao.getAllTickets(t.getUser_id());
                tickets.forEach((uz) -> {
                    System.out.println("O id " + uz.getId() + " do aluno " + uz.getUser_id() + " para secretaria " + uz.getSecretary_id() + " disse: " + uz.getContent() + " com a foto: " + uz.getPhoto_url());
                });
                break;
            case "Update":
                if (dao.update(t)) {
                    System.out.println("deu certo");
                } else {
                    System.out.println("Deu ruim");
                }
                break;
            case "Delete":
                if (dao.delete(t)) {
                    System.out.println("deu certo");
                } else {
                    System.out.println("Deu ruim");
                }
                break;
            case "Search":
                System.out.println(dao.getTicket(Integer.parseInt(idString)).toString());
                break;
            default:
                setReturnPage("erro.jsp");
                break;
        }

        this.setReturnPage("/index.jsp");
    }

}
