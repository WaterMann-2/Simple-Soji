import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class createGrid {

    public static JFrame createFrame(String name,int winWidth, int winHeight){

        // User screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // JFrame Config
        JFrame frame = new JFrame(name);
        frame.setResizable(false);


        // Frame Geometry
        frame.setSize(new Dimension(winWidth, winHeight));
        frame.setLocation((screenSize.width - winWidth)/2, (screenSize.height - winHeight - 44));

        // Close program on window close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        return frame;
    }

    public static JFrame background(JFrame frame, Color color){
        frame.add(panelCreator(color, frame.getWidth(), frame.getHeight(), 0, 0));
        return frame;
    }

    public static JPanel panelCreator(Color color, int width, int height, int posX, int posY){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(width, height);
        panel.setLocation(posX, posY);
        panel.setBackground(color);
        return panel;
    }
    
    public static JFrame gridArray(int gridWidth, int gridHeight, int divisions, JFrame frame, Color[] gridColors, int xOffset, int yOffset){

        // Frame Dimensions

        Debug.log("Width: " + gridWidth + " Height: " + gridHeight);

        // Dimensions of created panels
        int panWid = gridWidth / divisions;
        int panHei = gridHeight / divisions;

        // Creates panels and adds them to the frame
        for(int y = 0; y < divisions; y++){
            for(int x = 0; x < divisions; x++){
                frame.add(panelCreator(gridColors[(x+y) % 2], panWid, panHei, x * panWid + xOffset, y * panHei + yOffset));
            }
        }

        return frame;
    }

    public static JFrame gridLines(JFrame frame, int gridWidth, int gridHeight, int divisions, int thickness, int xOffset, int yOffset){

        int panelWidth = gridWidth / divisions;
        int panelheight = gridHeight / divisions;

        for(int y = 0; y < divisions+1; y++){
            frame.add(panelCreator(Color.black, gridWidth, thickness, xOffset, y*panelheight + thickness/2 + yOffset));
        }
        for(int x = 0; x < divisions+1; x++){
            frame.add(panelCreator(Color.black, thickness, gridHeight, x*panelWidth + thickness/2 + xOffset, yOffset));
        }

        Debug.log("Panel Width: " + panelWidth);

        return frame;
    }

    public static JFrame setIcons(JFrame frame){
        ImageIcon img32 = new ImageIcon("Sprites/Japanese/KingJp.png");
        frame.setIconImage(img32.getImage());
        return frame;

    }

    // Displays frame
    public static void instantiate(JFrame frame){
        frame.setVisible(true);
    }
}
