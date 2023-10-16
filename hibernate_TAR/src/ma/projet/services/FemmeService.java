package ma.projet.services;


import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.beans.Femme;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Expression.sql;



public class FemmeService implements IDao<Femme> {
     @Override
    public boolean create(Femme o) {
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
    public List<Femme> getAll() {
        List<Femme> femmes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery("from Femme").list();
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



    @Override
    public Femme getById(int id) {
        Femme femme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femme = (Femme) session.get(Femme.class, id);
            tx.commit();
            return femme;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return femme;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
public Long compterEnfantsEntreDates(Femme f, Date d1, Date d2) {
        Session session = null;
        Transaction tx = null;
         String hql = "SELECT COUNT(nbrEnfant) " +
                     "FROM Mariage m " +
                     "JOIN m.femme Femme " +
                     "WHERE Femme.id = :id " +
                     "AND dateDebut >= :d1 " +
                     "AND dateFin <= :d2";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(hql);
            query.setParameter("id", f.getId());
            query.setParameter("dateDebut", d1);
            query.setParameter("dateFin", d2);

            Long enfants = ((Number) query.uniqueResult()).longValue();

            tx.commit();
            return enfants;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            
        } finally {
            if(session != null)
                session.close();
        }
        return null;
    
}

public List<Femme> obtenirFemmesMarieesDeuxFoisOuPlus() {
        Session session = null;
        Transaction tx = null;
        String sql = "SELECT f.* " +
                     "FROM Femme f " +
                     "JOIN m1.femme Femme " +
                     "JOIN m2.femme Femme " +
                     "WHERE f.id IN (" +
                     "  SELECT m1.Femme.id " +
                     "  FROM Mariage m1, Mariage m2 " +
                     "  WHERE m1.Femme.id = m2.Femme.id " +
                     "  AND m1.id <> m2.id" +
                     ")";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Femme.class);

            List<Femme> result = query.list();

            return result;
        }catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            
        } finally {
            if(session != null)
                session.close();
        }
        return null;
    
    
}

}