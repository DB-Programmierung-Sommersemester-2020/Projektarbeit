package model.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Realisiert das Modell des Warenkorbs
 */
public class Warenkorb implements Serializable
{
   private static final long serialVersionUID = -8134578379541987433L;

   private List<Buch> buecher = new ArrayList<Buch>();
   
   public Warenkorb()
   {
      super();
   }
   
   public void addBuch(Buch buch)
   {
      this.buecher.add(buch);
   }
   
   public void removeAll()
   {
      this.buecher = new ArrayList<Buch>();
   }
   
   public Collection<Buch> getInhalt()
   {
      return new ArrayList<Buch>(this.buecher);
   }
}
