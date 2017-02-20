/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.dao;

import co.edu.eam.dao.exceptions.NonexistentEntityException;
import co.edu.eam.model.Users;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jefry
 */
import co.edu.eam.controller.SingletonEntityManager;

import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author ALVARO JAVIER L S
 */
public class UsersDAO implements Serializable {
    
    protected EntityManager em;

    public UsersDAO() {
    	
        this.em = SingletonEntityManager.getInstance();
        
    }


    public void create(Users usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    public void edit(Users usuario) {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    public void destroy(Users usuario) {
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public Users findUsuario(String usu) {
    	
        return em.find(Users.class, usu);
    }
    
    public Boolean finsUser(Users usu){
    	
    	Query query =   em.createNamedQuery("Users.findByUsername");
    	List us = query.setParameter("username", usu.getUsername()).setParameter("password", usu.getPassword())
    			.getResultList();
    	
    	if(us.size() > 0){
    		
    		return true;
    		
    	}else{
    		
    		return false;
    	}
    	
    	
    }

}