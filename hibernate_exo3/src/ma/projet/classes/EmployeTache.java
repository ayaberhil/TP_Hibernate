
package ma.projet.classes;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class EmployeTache {
    
    @EmbeddedId
    private EmployeTachePK id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutReelle;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinReelle;
    
    @ManyToOne()
    @JoinColumn(name="employe",referencedColumnName="id",insertable = false,updatable = false)
    private Employe employe;
    
    @ManyToOne()
    @JoinColumn(name="tache",referencedColumnName="id",insertable = false,updatable = false)
    private Tache tache;
    
     public EmployeTache() {
     
    }

    public EmployeTache(EmployeTachePK id, Date dateDebutReelle, Date dateFinReelle) {
        this.id = id;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }
    
       public EmployeTache(Date dateDebutReelle, Date dateFinReelle,Employe employe, Tache tache) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
    }

    public EmployeTachePK getId() {
        return id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setId(EmployeTachePK id) {
        this.id = id;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
       
  
       
    
}
