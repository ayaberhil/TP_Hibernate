
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Mariage;
import ma.projet.services.FemmeService;
import ma.projet.services.HommeService;
import ma.projet.services.MariageService;


public class TestMariage {
    
     public static void main(String[] args) {
         
          HommeService hs = new HommeService();
          FemmeService fs = new FemmeService();
          MariageService ms = new MariageService();
         
          ms.create(new Mariage(new Date(), new Date(), 3, hs.getById(2), fs.getById(1)));
          ms.create(new Mariage(new Date(), new Date(), 5, hs.getById(3), fs.getById(2)));
          ms.create(new Mariage(new Date(), new Date(), 0, hs.getById(3), fs.getById(3)));
          ms.create(new Mariage(new Date(), new Date(), 2, hs.getById(4), fs.getById(4)));
          ms.create(new Mariage(new Date(), new Date(), 1, hs.getById(1), fs.getById(9)));
    
  }
}
