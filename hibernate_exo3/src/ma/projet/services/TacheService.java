package ma.projet.services;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.dao.IDao;
import ma.projet.classes.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TacheService implements IDao<Tache> {
     @Override
    public boolean create(Tache o) {
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
    public List<Tache> getAll() {
        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.createQuery("from Tache").list();
            tx.commit();
            return taches;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return taches;
        } finally {
            if(session != null)
                session.close();
        }
    }



    @Override
    public Tache getById(int id) {
        Tache tache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache = (Tache) session.get(Tache.class, id);
            tx.commit();
            return tache;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return tache;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
     public void getTaches(){

        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        String query = "FROM Tache t where t.prix > 1000";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches =  session.createQuery(query).list();           
            tx.commit();
             for(Tache o : taches){
                System.out.println(o);
            }
           
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            
        } finally {
            if(session != null)
                session.close();
        }
       
    }
     
      public List<Tache> findBetweenDate(Date d1, Date d2) {
        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedQuery("betweenDate").setParameter("d1", d1).setParameter("d2", d2).list();
            tx.commit();
            return taches;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return taches;
        } finally {
            if(session != null)
                session.close();
        }
    }

    
}



    

