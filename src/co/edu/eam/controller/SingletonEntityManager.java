/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author 411pc13
 */
public class SingletonEntityManager {
    
    private static EntityManager em;

    private SingletonEntityManager() {
        em = Persistence.createEntityManagerFactory("ServerMSJPU").createEntityManager();
    }
    
    public static EntityManager getInstance(){
        if(em == null){
            new SingletonEntityManager();
        }
        return em;
    }    
    
}
