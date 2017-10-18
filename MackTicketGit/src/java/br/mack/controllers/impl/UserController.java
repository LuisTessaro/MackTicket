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
import java.util.List;

/**
 *
 * @author Luis
 */
public class UserController extends AbstractController {

    @Override
    public void execute() {
        String ctrlType = this.getRequest().getParameter("controlType");
        String tia = this.getRequest().getParameter("tia");
        String password = this.getRequest().getParameter("password");
        UserEntity u = new UserEntity();
        u.setTia(tia);
        u.setPassword(password);

        UserDAO dao = new UserDAOimpl();

        switch (ctrlType) {
            case "Register":
                if (dao.create(u)) {
                    System.out.println("deu certo");
                } else {
                    System.out.println("Deu ruim");
                }   break;
            case "ReadAll":
                List<UserEntity> users = dao.getAllUsers();
                users.forEach((uz) -> {
                    System.out.println("O id " + uz.getId() + " de tia " + uz.getTia() + " tem a senha " + uz.getPassword());
                }); break;
            case "Update":
                if (dao.update(u)) {
                    System.out.println("deu certo");
                } else {
                    System.out.println("Deu ruim");
                }   break;
            case "Delete":
                if (dao.delete(u)) {
                    System.out.println("deu certo");
                } else {
                    System.out.println("Deu ruim");
                }   break;
            case "Search":
                System.out.println(dao.getUser(Integer.parseInt(tia)).getTia());
                break;
            default:
                setReturnPage("erro.jsp");
                break;
        }

        this.setReturnPage("/index.jsp");
    }

}
