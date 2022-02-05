/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Juan
 */
public class JPARecursosDAO {
    
    private EntityManager em;
    
    public JPARecursosDAO() {
    }
        
    public void salva(Recurso e) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
        em.close();
    }
    
    public Recurso recupera(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Recurso e = em.find(Recurso.class, id);
        et.commit();
        em.close();
        return e;
    }
    
    public void deleta(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Recurso e = em.find(Recurso.class, id);
        em.remove(e);
        et.commit();
        em.close();
    }
    
    public List<Recurso> buscaSobrenome(String snome) {
        String jpqlQuery = "SELECT e FROM Recurso e where e.sobrenome = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", snome);
        List<Recurso> e = query.getResultList();
        em.close();
        return e;
    }
    
    public List<Recurso> buscaTudo() {
        String jpqlQuery = "SELECT e FROM Recurso e";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        List<Recurso> e = query.getResultList();
        em.close();
        return e;
    }
}
