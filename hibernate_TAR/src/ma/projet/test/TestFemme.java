
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Femme;
import ma.projet.services.FemmeService;


public class TestFemme {
    public static void main(String[] args) {
        
    FemmeService fs = new FemmeService();
    
    fs.create(new Femme("berhil","aya","08765433","Hay Najd",new Date()));
    fs.create(new Femme("essaoulajy","manal","08765433","Hay Matar",new Date()));
    fs.create(new Femme("eskandar","oumaima","08765433","Hay Saada",new Date()));
    fs.create(new Femme("el garda","bassma","08765433","Hay Essalam",new Date()));
    fs.create(new Femme("bajeddi","nassima","08765433","Centre",new Date()));
    fs.create(new Femme("berhil","ibtissam","08765433","Hay Najd",new Date()));
    fs.create(new Femme("ghazi","laila","08765433","Prince",new Date()));
    fs.create(new Femme("chtioui","salma","08765433","Hay Sidimoussa",new Date()));
    fs.create(new Femme("laili","asmaa","08765433","Hay Najd",new Date()));
    fs.create(new Femme("lagnidi","amina","08765433","Hay Essalam",new Date()));
    
    //Femmes mariées 2 fois ou plus
    fs.obtenirFemmesMarieesDeuxFoisOuPlus();
    
    //tester compterEnfantsEntreDates( )
    fs.compterEnfantsEntreDates(fs.getById(1), new Date(), new Date());
    
  }
}