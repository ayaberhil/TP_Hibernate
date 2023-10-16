
package ma.projet.test;

import ma.projet.classes.Employe;
import ma.projet.services.EmployeService;


public class TestEmploye {
    
   public static void main(String[] args) {
       
    EmployeService es = new EmployeService();
    es.create(new Employe("berhil","aya","0616453254"));
     es.create(new Employe("moufid","amine","0616453134"));
     es.create(new Employe("essaoulajy","manal","0614453254"));
    
    
     
    
  }
   
   
}