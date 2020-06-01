package bookshop.viewmodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Autor implements Serializable
{
   private static final long serialVersionUID = -5651583618904943407L;
   private int id;
   private String vorname;
   private String nachname;
   
   private List<Buch> buecher = new ArrayList<Buch>();
   
   public Autor(int id, String vorname, String nachname)
   {
      super();
      this.id = id;
      this.vorname = vorname;
      this.nachname = nachname;
   }
   
   public boolean addBuch(Buch buch)
   {
      return this.buecher.add(buch);
   }
   
   public List<Buch> getBuecher()
   {
      List<Buch> result = new ArrayList<Buch>();
      result.addAll( this.buecher );
      return result;
   }
   
   public int getId()
   {
      return this.id;
   }
   
   public String getVorname()
   {
      return this.vorname;
   }
   
   public String getNachname()
   {
      return this.nachname;
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if( obj instanceof Autor == false )
         return false;
      
      if( obj == this )
         return true;
      
      if( ((Autor) obj).id == this.id )
         return true;
      else
         return false;
   }

   @Override
   public int hashCode()
   {
      return String.valueOf(this.id).hashCode();
   }

   @Override
   public String toString()
   {  
      return this.vorname + " " + this.nachname;
   }
}
