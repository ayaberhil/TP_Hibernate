
package ma.projet.test;


import ma.projet.services.ProjetService;


public class TestfindTacheByProjet {
    
     public static void main(String[] args) {
     
        ProjetService ps = new ProjetService();

       ps.findTacheByProjet(ps.getById(1));
        
        
    }
    
}
