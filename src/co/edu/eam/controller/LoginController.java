package co.edu.eam.controller;

import java.util.LinkedList;
import java.util.List;

import co.edu.eam.dao.UsersDAO;
import co.edu.eam.dto.LoginDTO;
import co.edu.eam.dto.RegistrarDTO;
import co.edu.eam.model.Users;

public class LoginController {

	private UsersDAO dao;

	private Users user;

	public LoginController() {

		dao = new UsersDAO();

	}

	public Boolean findUser(Object obj) {

			LoginDTO dto = (LoginDTO) obj;

			user = new Users(dto.getUser(), dto.getPassword());			

			return dao.finsUser(user);

	}

	public boolean addUser(Object obj) {

		try {

			RegistrarDTO dto = (RegistrarDTO) obj;

			user = new Users(dto.getUser(), dto.getPassword());

			user.setIp(dto.getIp());

			dao.create(user);

			return true;

		} catch (Exception e) {

			return false;

		}

	}
}
