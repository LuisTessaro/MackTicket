/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.dao;

import br.mack.entity.TicketEntity;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface TicketDAO {
    public boolean create(TicketEntity t);
    public TicketEntity getTicket(int id);
    public List<TicketEntity> getAllTickets(String id);
    public boolean update(TicketEntity t);
    public boolean delete(TicketEntity t);
}
