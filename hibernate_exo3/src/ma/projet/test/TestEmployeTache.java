/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePK;
import ma.projet.classes.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.TacheService;

/**
 *
 * @author berhi
 */
public class TestEmployeTache {
    
    public static void main(String[] args) {
       
        EmployeService es = new EmployeService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();
        Employe e = es.getById(1);
        Employe e2= es.getById(2);
        Tache t1 = ts.getById(1);
        Tache t2 = ts.getById(2);
        
   //   EmployeTachePK pk1 = new EmployeTachePK(e.getId(),t1.getId());
    //  EmployeTachePK pk2 = new EmployeTachePK(e.getId(),t2.getId());
   //     EmployeTachePK pk3=new EmployeTachePK(e2.getId(),t2.getId());
         
        //  EmployeTache p1= new EmployeTache(pk1,new Date(),new Date());
   //   EmployeTache p2= new EmployeTache(pk2,new Date(),new Date());
    //  EmployeTache p3=new EmployeTache(pk3,new Date(),new Date());
    //   ets.create(p3);
       
            
       
    }
    
}
