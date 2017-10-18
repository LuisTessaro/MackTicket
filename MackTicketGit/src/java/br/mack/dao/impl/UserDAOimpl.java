/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.dao.impl;

import br.mack.dao.UserDAO;
import br.mack.entity.UserEntity;
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
public class UserDAOimpl implements UserDAO {

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
    public boolean create(UserEntity u) {
        String tia = u.getTia();
        String password = u.getPassword();

        String query = "INSERT INTO users (tia,password) VALUES("
                + tia + ",'" + password + "')";

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
                    Logger.getLogger(UserDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public UserEntity getUser(int tia) {
        String query = "SELECT * FROM users where tia = " + tia;
        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            UserEntity u = new UserEntity();
            u.setTia(rs.getString(2));
            u.setPassword(rs.getString("password"));
            u.setId(rs.getInt("id"));
            conn.close();
            return u;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public boolean userExistis(int tia) {
        String query = "SELECT * FROM users where tia = " + tia;
        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            UserEntity result = new UserEntity();
            rs.next();
            UserEntity u = new UserEntity();
            u.setTia(rs.getString("tia"));
            u.setPassword(rs.getString("password"));
            u.setId(rs.getInt("id"));
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    @Override
    public List<UserEntity> getAllUsers() {
        String query = "SELECT * FROM users";
        Connection conn = null;
        try {
            conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<UserEntity> result = new ArrayList();

            while (rs.next()) {
                UserEntity u = new UserEntity();
                u.setTia(rs.getString("tia"));
                u.setPassword(rs.getString("password"));
                u.setId(rs.getInt("id"));
                result.add(u);
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
                    Logger.getLogger(UserDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean update(UserEntity u) {
        String tia = u.getTia();
        String password = u.getPassword();

        String query = "update users set tia= "
                + tia + ", password = '" + password + "' where tia = " + u.getTia();

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
                    Logger.getLogger(UserDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean delete(UserEntity u) {
        String tia = u.getTia();
        String query = "DELETE FROM users where tia = " + u.getTia();
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
                    Logger.getLogger(UserDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
