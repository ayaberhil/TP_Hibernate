
package ma.projet.test;

import java.util.Date;
import ma.projet.services.TacheService;


public class TestfindBetweenDate {
    
    public static void main(String[] args) {
        TacheService ts = new TacheService();
        
        ts.findBetweenDate(new Date(), new Date());
    
  }
}