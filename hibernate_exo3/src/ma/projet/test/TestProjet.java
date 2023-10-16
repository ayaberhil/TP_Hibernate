
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Projet;
import ma.projet.services.EmployeService;
import ma.projet.services.ProjetService;


public class TestProjet {
    
    public static void main(String[] args) {
        
        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        
        ps.create(new Projet("Projet1",new Date(),new Date(), es.getById(1)));
        ps.create(new Projet("Projet2",new Date(),new Date(), es.getById(2)));
        ps.create(new Projet("Projet3",new Date(),new Date(), es.getById(3)));
        
        
        
 }
    
}