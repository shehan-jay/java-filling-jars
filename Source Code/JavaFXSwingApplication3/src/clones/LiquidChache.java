
package clones;

import java.util.Hashtable;


public class LiquidChache {
    
    private static Hashtable<String, CLiquid1> liquidMap  = new Hashtable<String, CLiquid1>();

   public static Liquid getShape(String shapeId) {
      Liquid liquidChache = liquidMap.get(shapeId);
      return (Liquid) liquidChache.clone();
   }
   
    public static void loadCache() {
      CLiquid1 lq1 = new CLiquid1();
      lq1.setId("1");
      liquidMap.put(lq1.getId(),lq1);      
   }
    
}
