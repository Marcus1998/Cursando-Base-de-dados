/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Roberta
 */
public class CursoDAO {
    public void salvar(Curso curso) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        em.close();
    }
    
    public void atualizar(Curso curso) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        em.close();
    }
    
    public void remover(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Curso curso = em.find(Curso.class, id);
        if (curso != null) {
            em.remove(curso);
        } else {
            //throw new DAOException("Não existe o id: " + id);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Curso> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c", Curso.class);
        List<Curso> cursos = query.getResultList();
        em.close();
        return cursos;
    }
    
    public Curso buscarId(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Curso curso = em.find(Curso.class, id);
        em.close();
        return curso;
    }
}
