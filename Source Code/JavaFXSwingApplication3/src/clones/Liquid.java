
package clones;

import java.awt.Graphics;
import javafxswingapplication3.App;

public abstract class Liquid implements Cloneable{
    
   private String id;
   protected String type;
   
   abstract void make(Graphics g, App app);
   
   public String getType(){
      return type;
   }
   
   public String getId() {
      return id;
   }
   
   public void setId(String id) {
      this.id = id;
   }
   
   public Object clone() {
      Object clone = null;
      
      try {
         clone = super.clone();
         
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }
    
}
