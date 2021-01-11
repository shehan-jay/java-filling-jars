
package clones;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import javafxswingapplication3.App;


public class CLiquid1 extends Liquid{
    private GeneralPath filledLiuid;
    @Override
    public void make(Graphics g, App app) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 40;
        int y = 510;

        double xPoints[] = { x, 130-app.xx, 210+app.xx, 300 };
        double yPoints[] = { y, 100+app.yy, 100+app.yy, y };
        filledLiuid = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
        xPoints.length);

        filledLiuid.moveTo(xPoints[0], yPoints[0]);
        for (int index = 1; index < xPoints.length; index++) {
            filledLiuid.lineTo(xPoints[index], yPoints[index]);
        }
        filledLiuid.closePath();
        g2.setPaint(Color.green);
        g2.fill(filledLiuid);
        g2.setPaint(Color.green);
        g2.draw(filledLiuid);
    }
    
}
