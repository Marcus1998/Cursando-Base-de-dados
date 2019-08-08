/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Exercicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Roberta
 */
public class ExercicioDAO {
    public void salvar(Exercicio exercicio) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(exercicio);
        em.getTransaction().commit();
        em.close();
    }
    
    public void atualizar(Exercicio exercicio) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(exercicio);
        em.getTransaction().commit();
        em.close();
    }
    
    public void remover(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Exercicio exercicio = em.find(Exercicio.class, id);
        if (exercicio != null) {
            em.remove(exercicio);
        } else {
            //throw new DAOException("Não existe o id: " + id);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Exercicio> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Exercicio> query = em.createQuery("SELECT e FROM Exercicio e", Exercicio.class);
        List<Exercicio> exercicios = query.getResultList();
        em.close();
        return exercicios;
    }
    
    public Exercicio buscarId(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Exercicio exercicio = em.find(Exercicio.class, id);
        em.close();
        return exercicio;
    }
}
