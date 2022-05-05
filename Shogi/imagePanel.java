import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

// Attempting to use a public class so create game peices on the board (None of this is my code, yet)

public class imagePanel extends JPanel {

    private BufferedImage image;

        public void ImagePanel(){
            try{
                image = ImageIO.read(new File("Sprites/Japanese/KingJp.png"));

            }catch (IOException e){
                System.out.println("Image Failed :(");
            }
        }

        @Override
        protected void paintComponent(Graphics graph){
            super.paintComponent(graph);
            graph.drawImage(image, 0, 0, this);
        }
}
