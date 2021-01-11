
package javafxswingapplication3;

import imageLoader.ImageLoader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import uiItems.ILiquid;
import uiItems.LiquidFactory;


public class App extends JPanel{

    private GeneralPath filledLiuid;
    private BufferedImage image;
    private int imageWidth;
    private int imageHeight;
    public double xx = 0.0;
    public double yy = 0.0;
    

    private static JSpinner spinner;

    public App() {
        image = ImageLoader.getInstance();
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
        System.out.println(imageHeight);
        spinner = createSpinner();
    }

    private JSpinner createSpinner() {
        final JSpinner spinner = new JSpinner();
        SpinnerNumberModel model = new SpinnerNumberModel(100, 0, 100, 1);
        spinner.setModel(model);
        spinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner.getModel().getValue();
                calculateGlassValues(value);
                repaint();
            }

        });
        return spinner;
    }

    private void calculateGlassValues(int value) {
        xx = 90.0*((100-value)/100.0);
        yy = 410.0*((100-value)/100.0);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, imageWidth, imageHeight, this);
        ILiquid ilq = new LiquidFactory().getLiquid("1");
        ilq.make(g, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 700);
    }
    

    public static void load() {
        JFrame frame = new JFrame();
        
        frame.add(new App());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        JPanel pannel = new JPanel(new GridLayout(3,3,3,3));
        JLabel Text1 = new JLabel("Up for FILL");
        JLabel Text2 = new JLabel("Down for DRAIN");
        pannel.add(Text1);
        pannel.add(spinner);
        pannel.add(Text2);
        frame.add(pannel, BorderLayout.WEST);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                load();
            }
        });
    }
    
}
