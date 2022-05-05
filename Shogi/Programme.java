import javax.swing.JFrame;
import java.awt.*;
//Main excecutable, Wanted to have a different name other then Main, so decided to do "Programme"
public class Programme {

    public static JFrame generateGrid(int winWidth, int winHeight, int gridWidth, int gridHeight , int xOffset, int yOffset){

        // Create the frame
        JFrame frame = createGrid.createFrame("Grid", winWidth, winHeight);
        
        // Decorate the frame
        Color[] setlist = {new Color(200,150,110), new Color(240,200,170)};
        Color background = new Color(170, 120, 90);

        // JPanel related shizz
        frame = createGrid.gridLines(frame, gridWidth, gridHeight, 9, 1, xOffset, yOffset);
        frame = createGrid.gridArray(gridWidth, gridHeight, 9, frame, setlist, xOffset, yOffset);
        frame = createGrid.background(frame, background);
        
        frame = createGrid.setIcons(frame);
        
        return frame;
    }
    public static void main(String[] args){
        JFrame frame =  generateGrid(800, 580, 540, 540, 130, 0);

        frame.setVisible(true);

    }
}
