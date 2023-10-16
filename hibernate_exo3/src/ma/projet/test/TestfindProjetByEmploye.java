
package ma.projet.test;

import ma.projet.services.EmployeService;



public class TestfindProjetByEmploye {
    
     public static void main(String[] args) {
     
        EmployeService es = new EmployeService();

       es.findProjetByEmploye(es.getById(3));
        
        
    }
    
}
