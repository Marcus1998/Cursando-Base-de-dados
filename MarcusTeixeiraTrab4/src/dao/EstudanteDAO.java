/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Estudante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Roberta
 */
public class EstudanteDAO {
    public void salvar(Estudante estudante) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(estudante);
        em.getTransaction().commit();
        em.close();
    }
    
    public void atualizar(Estudante estudante) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(estudante);
        em.getTransaction().commit();
        em.close();
    }
    
    public void remover(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Estudante estudante = em.find(Estudante.class, id);
        if (estudante != null) {
            em.remove(estudante);
        } else {
            //throw new DAOException("Não existe o id: " + id);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Estudante> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Estudante> query = em.createQuery("SELECT e FROM Estudante e", Estudante.class);
        List<Estudante> estudantes = query.getResultList();
        em.close();
        return estudantes;
    }
    
    public Estudante buscarId(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Estudante estudante = em.find(Estudante.class, id);
        em.close();
        return estudante;
    }
}
