/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.controller;

import co.edu.eam.dao.UsersDAO;
import co.edu.eam.model.Users;

/**
 *
 * @author jefry
 */
public class UserContrller extends Conexion{
    
    private UsersDAO dao;
    private Users user;

    public UserContrller() {
        dao = new UsersDAO(factory);
    }
    
}
    
