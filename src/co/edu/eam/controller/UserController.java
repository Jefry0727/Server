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
public class UserController {
    
    private UsersDAO dao;
    private Users user;

    public UserController() {
        dao = new UsersDAO();
    }
    
}
    
