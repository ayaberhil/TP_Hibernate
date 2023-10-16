package ma.projet.services;


import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.dao.IDao;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HommeService implements IDao<Homme> {
     @Override
    public boolean create(Homme o) {
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
    public List<Homme> getAll() {
        List<Homme> hommes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            hommes = session.createQuery("from Homme").list();
            tx.commit();
            return hommes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return hommes;
        } finally {
            if(session != null)
                session.close();
        }
    }



    @Override
    public Homme getById(int id) {
        Homme homme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            homme = (Homme) session.get(Homme.class, id);
            tx.commit();
            return homme;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return homme;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
      public List<Femme> findFemmeBetweenDate(Homme h,Date d1, Date d2) {
        List<Femme> femmes = null;
        Session session = null;
        Transaction tx = null;
         String hql = "SELECT 1 FROM Mariage 1 " +
                 "JOIN 1.homme Homme " +
                 "JOIN 1.femme Femme " +
                 "WHERE Homme.id = :id " +
                 "AND 1.dateDebut >= :d1 " +
                 "AND 1.dateFin <= :d2";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery(hql)
            .setParameter("id", h.getId())
            .setParameter("d1", d1)
            .setParameter("d2", d2)
            .list();
            tx.commit();
            return femmes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return femmes;
        } finally {
            if(session != null)
                session.close();
        }
    }
      
       public void findFemmeByHomme(Homme h){
        System.out.println("Employe: " + h.getId());
        System.out.println("\n Liste des femmes épousés :");
        
        List<Mariage> mariages = null;
        Session session = null;
        Transaction tx = null;
        String query = "select l FROM Mariage l "
                + "join l.homme Homme "
                + "join l.femme Femme "
                + "where Homme.id = :id";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            mariages =  session.createQuery(query)
                    .setParameter("id", h.getId()).list();
            
            tx.commit();
            System.out.println("\tFemme\t\tDate Début\t\tNbr Enfants");
            for(Mariage l : mariages){
                System.out.println("\t" + l.getFemme().getNom() + " " + l.getFemme().getPrenom() + "\t\t" + l.getDateDebut()+ "\t\t\t" + l.getNbrEnfant());
            }
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
       
    }
     
  
    
    
}

