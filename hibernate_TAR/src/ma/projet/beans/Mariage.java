
package ma.projet.beans;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Temporal;

@Entity
@NamedNativeQuery(
    name = "compterEnfantsEntreDates",
    query = "SELECT m.nbrEnfant FROM Mariage m " +
            "JOIN m.femme Femme " +
            "WHERE Femme.id = :id " +
            "AND m.dateDebut >= :d1 " +
            "AND m.dateFin <= :d2",
    resultClass = Long.class
)
public class Mariage {
    
    @EmbeddedId
    private MariagePK id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    private int nbrEnfant;
    
    @ManyToOne()
    @JoinColumn(name="homme",referencedColumnName="id",insertable = false,updatable = false)
    private Homme homme;
    
    @ManyToOne()
    @JoinColumn(name="femme",referencedColumnName="id",insertable = false,updatable = false)
    private Femme femme;
    
      public Mariage() {
      
    }

    public Mariage(MariagePK id, Date dateDebut, Date dateFin, int nbrEnfant) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
    }

    public Mariage(Date dateDebut, Date dateFin, int nbrEnfant, Homme homme, Femme femme) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        this.homme = homme;
        this.femme = femme;
    }

    public MariagePK getId() {
        return id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public Homme getHomme() {
        return homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setId(MariagePK id) {
        this.id = id;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }
    
    
    
    
    
    
}
