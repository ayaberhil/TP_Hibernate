
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Femme extends Personne {

    public Femme() {
    }

    public Femme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }
    
    
    
}
