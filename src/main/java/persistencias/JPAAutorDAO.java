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
public class JPAAutorDAO {
    
    private EntityManager em;
    
    public JPAAutorDAO() {
    }
        
    public void salva(Autor e) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(e);
        et.commit();
        em.close();
    }
    
    public Autor recupera(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Autor e = em.find(Autor.class, id);
        et.commit();
        em.close();
        return e;
    }
    
    public void deleta(Long id) {
        
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Autor e = em.find(Autor.class, id);
        em.remove(e);
        et.commit();
        em.close();
    }
    
    public List<Autor> buscaSobrenome(String snome) {
        String jpqlQuery = "SELECT e FROM Autor e where e.sobrenome = :sn";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("sn", snome);
        List<Autor> e = query.getResultList();
        em.close();
        return e;
    }
    
    public List<Autor> buscaTudo() {
        String jpqlQuery = "SELECT e FROM Autor e";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery);
        List<Autor> e = query.getResultList();
        em.close();
        return e;
    }
}
