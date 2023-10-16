
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Homme;
import ma.projet.services.HommeService;


public class TestHomme {
    public static void main(String[] args) {
        
        HommeService hs = new HommeService();
        
        hs.create(new Homme("berhil","mehdi","08765433","Hay Najd",new Date()));
        hs.create(new Homme("essaoulajy","amine","08765433","Hay Matar",new Date()));
        hs.create(new Homme("eskandar","oussama","08765433","Hay Saada",new Date()));
        hs.create(new Homme("el garda","nassim","08765433","Hay Essalam",new Date()));
        hs.create(new Homme("bajeddi","mohamed","08765433","Centre",new Date()));
       
        
        //tester findFemmeBetweenDate( )
        hs.findFemmeBetweenDate(hs.getById(3), new Date(), new Date());
        
        //Liste des femmes épousées par un homme
        hs.findFemmeByHomme(hs.getById(4));
        
    
    
 }

}
