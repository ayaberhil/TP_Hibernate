
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Tache;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;


public class TestTache {
    
        public static void main(String[] args) {
            
            ProjetService ps = new ProjetService();
            TacheService ts = new TacheService();
            
            ts.create(new Tache("Organisateur",new Date(),new Date(),20000.0,ps.getById(1)));
            ts.create(new Tache("Leader",new Date(),new Date(),20000.0,ps.getById(2)));
            ts.create(new Tache("Tresorier",new Date(),new Date(),20000.0,ps.getById(1)));
            ts.create(new Tache("Leader",new Date(),new Date(),20000.0,ps.getById(3)));
            
            
    
  }
}    
