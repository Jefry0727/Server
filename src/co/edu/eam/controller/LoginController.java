package co.edu.eam.controller;

import co.edu.eam.dao.UsersDAO;
import co.edu.eam.dto.RegistrarDTO;
import co.edu.eam.model.Users;

public class LoginController  extends Conexion{
    
    private UsersDAO dao;
    private Users user;

    public LoginController() {
        dao = new UsersDAO(factory);
    }

	
	public boolean findUser(){
		
		
		return true;
		
	}
	
	public boolean addUser(Object obj){
		
		RegistrarDTO dto = (RegistrarDTO) obj;
		
		user = new Users(dto.getUser(),dto.getPassword());
		
		dao.create(user);
		
		return true;
		
	}
}
