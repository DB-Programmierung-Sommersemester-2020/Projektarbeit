package model.shop;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Buch implements Serializable
{
   private static final long serialVersionUID = 6690657110776756579L;
   private int id;
   private String titel;
   private String verlag;
   private double preis;
   
   private List<Autor> autoren = new ArrayList<Autor>();
   
   public Buch(int id, String titel, String verlag, double preis)
   {
      super();
      this.id = id;
      this.titel = titel;
      this.verlag = verlag;
      this.preis = preis;
   }
   
   public boolean addAutor(Autor autor)
   {
      return this.autoren.add(autor);
   }
   
   public List<Autor> getAutoren()
   {
      List<Autor>  result = new ArrayList<Autor>();
      result.addAll( this.autoren );
      return result;
   }
   
   public String getAutorenAsString()
   {
      StringBuilder strBuild = new StringBuilder();
      
      int i = 0;
      for( i =0; i < this.autoren.size()-1; i++ )
      {
         Autor autor = this.autoren.get(i);
         strBuild.append( autor.getVorname() + " " + autor.getNachname() + ", ");
      }
      Autor autor = this.autoren.get(i);
      strBuild.append( autor.getVorname() + " " + autor.getNachname() );
         
      return strBuild.toString();
   }
   
   public int getId()
   {
      return this.id;
   }
   
   public String getTitel()
   {
      return this.titel;
   }
   
   public String getVerlag()
   {
      return this.verlag;
   }
   
   public String getPreis()
   {
      NumberFormat frmt = DecimalFormat.getInstance();
      frmt.setMinimumFractionDigits(2);
      return frmt.format( this.preis );
   }

   @Override
   public boolean equals(Object obj)
   {
      if( obj instanceof Buch == false )
         return false;
      
      if( obj == this )
         return true;
      
      if( ((Buch) obj).id == this.id )
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
      StringBuilder autoren = new StringBuilder();
      int i=0;
      for( i=0; i < this.autoren.size()-1; i++)
      {
         autoren.append( this.autoren.get(i) + ", ");
      }
      autoren.append( this.autoren.get(i) );
      
      return autoren.toString() + " : " + this.titel + autoren.toString();
   }
   
}
