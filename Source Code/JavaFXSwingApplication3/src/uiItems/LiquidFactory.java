
package uiItems;

public class LiquidFactory {
    
    public ILiquid getLiquid(String type){
        if(type.equalsIgnoreCase("1")){
            return new Liquid1();
        }
    return null;
    }
    
}
