package model.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * Die Fassade stellt verschiedene Zugriffmethoden auf die Geschäftsobjekte bereit.
 * Weiter initialisiert die Fassade auch einen (transienten) Datenbestand, so dass
 * die Fassade sofort in die Web-Anwendung eingebaut werden kann.
 * 
 * Die Fassade ist als Singleton implememtiert!
 */
public class ModelFacade
{
   private static class InstanceHolder
   {
      private static ModelFacade instance = new ModelFacade();
   }
    
   public static ModelFacade getInstance()
   {
      return InstanceHolder.instance;
   }
   
   private List<Autor> autorenContainer = new ArrayList<Autor>();
   private List<Buch>  buchContainer = new ArrayList<Buch>();
   
   private ModelFacade()
   {
      super();
      this.initModel();
   }
   
   // Liefert alle Bücher eines Autors.
   // Als Wildcard wird * akzeptiert
   public Collection<Buch> findBuecherFromAutor(String name)
   {
      Set<Buch> result = new HashSet<Buch>();
      
      String[] names = name.split("\\*");
      
      for(Autor a : this.autorenContainer )
      {
         boolean found = true;
         for( String searchString : names )
         {
            if( a.getNachname().toLowerCase().contains(searchString.toLowerCase()) == true )
            {
               found &= true;
            }
            else
            {
               found &= false;
            }
            
         }    
         if( found )
            result.addAll(a.getBuecher());
      }
      
      return result;
   }
   
   // Liefert ein Buch mit der geforderten ID
   public Buch findBuchById(int buchId)
   {
      Buch result = null;
      
      for(Buch b : this.buchContainer )
      {
         if( b.getId() == buchId )
         {
            result = b;
            break;
         }
      }
      
      return result;
   }
   
   public Collection<Buch> getAlleBuecher()
   {
      return new ArrayList<Buch>( this.buchContainer );
   }
   
   public Collection<Autor> getAlleAutoren()
   {
      return new ArrayList<Autor>( this.autorenContainer );
   }
   
   private void initModel()
   {
      Autor starke = new Autor(1, "Gernot", "Starke");
      this.autorenContainer.add(starke);
      Buch eSA = new Buch(1,"Effektive Software-Architekturen","Hanser", 39.95 );
      this.buchContainer.add(eSA);
      eSA.addAutor(starke);
      starke.addBuch( eSA );
      
      Autor siedersleben = new Autor(2, "Johannes", "Siedersleben");
      this.autorenContainer.add(siedersleben);
      Buch mSA = new Buch(2,"Moderne Software-Architekturen","dpunkt.verlag", 39.00 );
      this.buchContainer.add(mSA);
      mSA.addAutor(siedersleben);
      siedersleben.addBuch(mSA);
      
      Autor martin = new Autor(3,"Robert", "Martin");
      this.autorenContainer.add(martin);
      Buch aSD = new Buch(3,"Agile Software Development","Prentice Hall", 67.97 );
      this.buchContainer.add(aSD);
      aSD.addAutor(martin);
      martin.addBuch(aSD);
      
      Autor lea = new Autor(4,"Doug", "Lea");
      this.autorenContainer.add(lea);
      Buch cPJ = new Buch(4, "Concurrent Programming in Java","Addison Wesely", 47.95 );
      this.buchContainer.add(cPJ);
      cPJ.addAutor(lea);
      lea.addBuch(cPJ);
      
      Autor mcCool = new Autor(5,"Michael", "McCool");
      this.autorenContainer.add(mcCool);
      Autor robinson = new Autor(6,"Arch", "Robinson");
      this.autorenContainer.add(robinson);
      Autor reinders = new Autor(7,"James", "Reinders");
      this.autorenContainer.add(reinders);
      Buch sPP = new Buch(5, "Structured Parallel Programming","Morgan Kaufmann", 42.95 );
      this.buchContainer.add(sPP);
      sPP.addAutor(mcCool);
      sPP.addAutor(robinson);
      sPP.addAutor(reinders);
      mcCool.addBuch(sPP);
      robinson.addBuch(sPP);
      reinders.addBuch(sPP);
      
      
      Autor jeffers = new Autor(8,"Jim", "Jeffers");
      this.autorenContainer.add(jeffers);
      Buch xeonPhi = new Buch(6, "Intel Xeon Phi Coprocerssor High-Performance Programming","Morgan Kaufmann", 42.95 );
      this.buchContainer.add(xeonPhi);
      xeonPhi.addAutor(jeffers);
      xeonPhi.addAutor(reinders);
      jeffers.addBuch(xeonPhi);
      reinders.addBuch(xeonPhi);
      
      Autor tanenbaum = new Autor(9,"Andrew", "Tanenbaum");
      this.autorenContainer.add(tanenbaum);
      Autor bos = new Autor(10,"Herbert", "Bos");
      this.autorenContainer.add(bos);
      Buch mOS = new Buch(7, "Modern Operating Systems","Prentice Hall", 76.22 );
      this.buchContainer.add(mOS);
      mOS.addAutor(tanenbaum);
      mOS.addAutor(bos);
      tanenbaum.addBuch(mOS);
      bos.addBuch(mOS);
      
      Autor wetherall = new Autor(11,"David", "Wetherall");
      this.autorenContainer.add(wetherall);
      Buch cN = new Buch(8, "Computer Networks","Prentice Hall", 96.20 );
      this.buchContainer.add(cN);
      cN.addAutor(tanenbaum);
      cN.addAutor(wetherall);
      tanenbaum.addBuch(cN);
      wetherall.addBuch(cN);
      
      Buch cC = new Buch(9,"Clean Code","Prentice Hall", 33.95 );
      this.buchContainer.add(cC);
      cC.addAutor(martin);
      martin.addBuch(cC);
      
      Buch cC2 = new Buch(10,"The Clean Coder","Prentice Hall", 39.37 );
      this.buchContainer.add(cC2);
      cC2.addAutor(martin);
      martin.addBuch(cC2);
      
      Buch spS = new Buch(11, "Softwaretechnik: Praxiswissen für Softwareingenieure","Hanser", 25.95 );
      this.buchContainer.add(spS);
      spS.addAutor(siedersleben);
      siedersleben.addBuch(spS);
      
      Autor tilkov = new Autor(12,"Stefan", "Tilkov");
      this.autorenContainer.add(tilkov);
      Buch soa = new Buch(12, "SOA-Expertenwissen: Methoden, Konzepte und Praxis serviceorientierter Architekturen","dpunkt.verlag", 59.00 );
      this.buchContainer.add(soa);
      soa.addAutor(starke);
      soa.addAutor(tilkov);
      starke.addBuch(soa);
      tilkov.addBuch(soa);
      
      Buch http = new Buch(13, "REST und HTTP: Einsatz der Architektur des Web für Integrationsszenarien","dpunkt.verlag", 23.95 );
      this.buchContainer.add(http);
      http.addAutor(tilkov);
      tilkov.addBuch(http);
   }
}
