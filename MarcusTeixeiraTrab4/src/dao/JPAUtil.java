/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 0767174
 */
public class JPAUtil {
    private static EntityManagerFactory emf;
    public static EntityManager getEntityManager() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("MarcusTeixeiraTrab4PU");
        }
        return emf.createEntityManager();
    }
    public void fechaEntityManager(){
        emf.close();
    }
}
