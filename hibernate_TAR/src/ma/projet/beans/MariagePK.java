
package ma.projet.beans;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class MariagePK implements Serializable {
    
    private int femme;
    private int homme;
    
        public MariagePK() {
        
    }

    public MariagePK(int femme, int homme) {
        this.femme = femme;
        this.homme = homme;
    }

    public int getFemme() {
        return femme;
    }

    public int getHomme() {
        return homme;
    }

    public void setFemme(int femme) {
        this.femme = femme;
    }

    public void setHomme(int homme) {
        this.homme = homme;
    }
    
    
    
    
}
