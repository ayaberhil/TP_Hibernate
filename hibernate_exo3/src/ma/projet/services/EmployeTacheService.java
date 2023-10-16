
package ma.projet.services;

import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.classes.EmployeTache;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.classes.EmployeTache;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lachgar
 */
public class EmployeTacheService implements IDao<EmployeTache> {
     @Override
    public boolean create(EmployeTache o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

   
   

    @Override
    public List<EmployeTache> getAll() {
        List<EmployeTache> ligneCommandeProduits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ligneCommandeProduits = session.createQuery("from EmployeTache").list();
            tx.commit();
            return ligneCommandeProduits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return ligneCommandeProduits;
        } finally {
            if(session != null)
                session.close();
        }
    }



    @Override
    public EmployeTache getById(int id) {
        EmployeTache ligneCommandeProduit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ligneCommandeProduit = (EmployeTache) session.get(EmployeTache.class, id);
            tx.commit();
            return ligneCommandeProduit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return ligneCommandeProduit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    
}

