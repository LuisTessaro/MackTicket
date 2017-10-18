/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mack.dao;

import br.mack.entity.UserEntity;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface UserDAO {
    public boolean create(UserEntity userE);
    public UserEntity getUser(int id);
    public List<UserEntity> getAllUsers();
    public boolean update(UserEntity userE);
    public boolean delete(UserEntity userE);
    public boolean userExistis(int parseInt);
}
