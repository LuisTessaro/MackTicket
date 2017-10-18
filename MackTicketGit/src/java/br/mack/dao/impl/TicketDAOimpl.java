/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.dao.impl;

import br.mack.dao.TicketDAO;
import br.mack.entity.TicketEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class TicketDAOimpl implements TicketDAO {

    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String user = "luis";
    private final String password = "";

    private Connection getConnection() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public boolean create(TicketEntity t) {
        String content = t.getContent();
        String photo_url = t.getPhoto_url();
        String user_id = t.getUser_id();
        String secretary_id = t.getSecretary_id();

        String query = "INSERT INTO ticket (user_id,secretary_id,content,photo_url) VALUES("
                + user_id + ","
                + secretary_id + ",'"
                + content + "','"
                + photo_url + "'"
                + ")";

        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            boolean result = stmt.executeUpdate(query) > 0;
            conn.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public TicketEntity getTicket(int id) {
        String query = "SELECT * FROM ticket where id = " + id;
        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            TicketEntity t = new TicketEntity();
            t.setUser_id(rs.getString("user_id"));
            t.setSecretary_id(rs.getString("secretary_id"));
            t.setContent(rs.getString("content"));
            t.setPhoto_url(rs.getString("photo_url"));
            conn.close();
            return t;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<TicketEntity> getAllTickets(String id) {
        String query = "SELECT * FROM ticket where user_id = "+ id;
        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<TicketEntity> result = new ArrayList();

            while (rs.next()) {
                TicketEntity t = new TicketEntity();
                t.setId(rs.getInt("id"));
                t.setUser_id(rs.getString("user_id"));
                t.setSecretary_id(rs.getString("secretary_id"));
                t.setContent(rs.getString("content"));
                t.setPhoto_url(rs.getString("photo_url"));
                result.add(t);
            }
            conn.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean update(TicketEntity t) {
        String content = t.getContent();
        String photo_url = t.getPhoto_url();
        String id = t.getIdString();
        String query = "update ticket set content = '" + content + "',photo_url = '" + photo_url + "' where id = " + id;

        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            boolean result = stmt.executeUpdate(query) > 0;
            conn.close();
            return result;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {

            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean delete(TicketEntity t) {
        String id = t.getIdString();
        String query = "DELETE FROM ticket where id = " + id;
        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            boolean result = stmt.executeUpdate(query) > 0;
            conn.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
