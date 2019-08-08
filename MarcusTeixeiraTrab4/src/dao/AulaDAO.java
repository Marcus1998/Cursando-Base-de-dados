/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Aula;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Roberta
 */
public class AulaDAO {
    public void salvar(Aula aula) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(aula);
        em.getTransaction().commit();
        em.close();
    }
    
    public void atualizar(Aula aula) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(aula);
        em.getTransaction().commit();
        em.close();
    }
    
    public void remover(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Aula aula = em.find(Aula.class, id);
        if (aula != null) {
            em.remove(aula);
        } else {
            //throw new DAOException("Não existe o id: " + id);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Aula> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Aula> query = em.createQuery("SELECT a FROM Aula a", Aula.class);
        List<Aula> aulas = query.getResultList();
        em.close();
        return aulas;
    }
    
    public Aula buscarId(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Aula aula = em.find(Aula.class, id);
        em.close();
        return aula;
    }
}
