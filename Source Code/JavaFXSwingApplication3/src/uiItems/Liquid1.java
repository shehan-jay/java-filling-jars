
package uiItems;


import clones.LiquidChache;
import java.awt.Graphics;
import javafxswingapplication3.App;
import clones.Liquid;
import clones.CLiquid1;


public class Liquid1 implements ILiquid{

    
    @Override
    public void make(Graphics g, App app) {
        LiquidChache.loadCache();
        Liquid lq = (Liquid) LiquidChache.getShape("1");
        CLiquid1 clq = (CLiquid1) lq.clone();
        clq.make(g, app);
        
    }
    
}
