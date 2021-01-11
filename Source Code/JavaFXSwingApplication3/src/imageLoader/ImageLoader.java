
package imageLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javafxswingapplication3.App;
import javax.imageio.ImageIO;


public class ImageLoader {
    
    private BufferedImage image = null;
    private static ImageLoader instance = new ImageLoader();
    
    public static BufferedImage getInstance(){
      return instance.laodImage();
   }
    
    private BufferedImage laodImage(){
    try {
            image = ImageIO.read(App.class.getResource("flask.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    
}
