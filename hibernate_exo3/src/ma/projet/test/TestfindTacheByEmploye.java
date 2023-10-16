
package ma.projet.test;

import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.TacheService;


public class TestfindTacheByEmploye {
    
     public static void main(String[] args) {
         
        EmployeService es = new EmployeService();
        EmployeTacheService ets = new EmployeTacheService();
        
        es.findTacheByEmploye(es.getById(2));
        
        
    }
    
}
