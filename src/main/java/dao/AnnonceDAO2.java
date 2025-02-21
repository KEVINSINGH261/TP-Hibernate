package dao;

import bean.Annonce;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AnnonceDAO2 {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("annonce");
    private EntityManager em = emf.createEntityManager();

    public boolean create(Annonce annonce) {
        em.getTransaction().begin();
        em.persist(annonce);
        em.getTransaction().commit();
        em.close();

        return true;
    }

    public Annonce read(int id) {
        em.getTransaction().begin();
        Annonce annonce = em.find(Annonce.class, id);
        em.getTransaction().commit();
        em.close();

        return annonce;
    }

    public boolean update(Annonce annonce) {
        em.getTransaction().begin();
        em.merge(annonce);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public boolean delete(Annonce annonce) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Annonce annonce2 = em.find(Annonce.class, annonce.getId());
        em.remove(annonce2);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public List<Annonce> readAll() {
        em.getTransaction().begin();
        List<Annonce> annonces = em.createQuery("from Annonce").getResultList();
        em.getTransaction().commit();
        em.close();
        return annonces;
    }
}
