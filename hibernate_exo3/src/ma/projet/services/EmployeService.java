package ma.projet.services;

import java.text.SimpleDateFormat;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmployeService implements IDao<Employe> {
     @Override
    public boolean create(Employe o) {
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
    public List<Employe> getAll() {
        List<Employe> employes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes = session.createQuery("from Employe").list();
            tx.commit();
            return employes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return employes;
        } finally {
            if(session != null)
                session.close();
        }
    }



    @Override
    public Employe getById(int id) {
        Employe employe = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe = (Employe) session.get(Employe.class, id);
            tx.commit();
            return employe;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return employe;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
     public void findTacheByEmploye(Employe e){
        System.out.println("Employe: " + e.getId());
        System.out.println("\n Liste des taches réalisées :");
        
        List<EmployeTache> employeTaches = null;
        Session session = null;
        Transaction tx = null;
        String query = "select l FROM EmployeTache l "
                + "join l.tache Tache "
                + "join l.employe Employe "
                + "where Employe.id = :id";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTaches =  session.createQuery(query)
                    .setParameter("id", e.getId()).list();
            
            tx.commit();
            System.out.println("\tNum\t\tNom\t\tDate Début Réelle\t\tDate Fin Réelle");
            for(EmployeTache l : employeTaches){
                System.out.println("\t" + l.getEmploye().getTelephone() + "\t" + l.getTache().getNom() + "\t\t" + l.getDateDebutReelle()+ "\t\t\t" + l.getDateFinReelle());
            }
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
       
    }
     
     public void findProjetByEmploye(Employe e) {
        List<Projet> projets = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("FROM Projet p where p.employe.id = :id").setParameter("id", e.getId()).list();
            tx.commit();
           for(Projet o : projets){
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


    
}

