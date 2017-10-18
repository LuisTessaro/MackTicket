/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.controllers.impl;

import br.mack.controllers.AbstractController;
import br.mack.dao.UserDAO;
import br.mack.dao.impl.UserDAOimpl;
import br.mack.entity.UserEntity;

/**
 *
 * @author Luis
 */
public class LoginController extends AbstractController {

    @Override
    public void execute() {
        String tia = this.getRequest().getParameter("tia");
        UserEntity u = new UserEntity();
        u.setTia(tia);
        UserDAO dao = new UserDAOimpl();
        if (tia.equals("")) {
            this.setReturnPage("/errologin.jsp");
        } else if (!tia.matches("^[0-9]*$") && tia.length() < 10) {
            this.setReturnPage("/errologin.jsp");
        } else {
            if (dao.getUser(Integer.parseInt(u.getTia())) != null) {
                if (dao.getUser(Integer.parseInt(u.getTia())).getTia().equals(tia)) {
                    this.setReturnPage("/home.jsp");
                    UserEntity q = dao.getUser(Integer.parseInt(u.getTia()));
                    this.getRequest().getSession().setAttribute("log", "true");
                    this.getRequest().getSession().setAttribute("idUser", q.getId());
                    this.getRequest().getSession().setAttribute("tiaUser", q.getTia());
                    this.getRequest().getSession().setAttribute("passwordUser", q.getPassword());
                } else {
                    this.setReturnPage("/errologin.jsp");
                }
            } else {
                this.setReturnPage("/errologin.jsp");
            }
        }

    }

}
