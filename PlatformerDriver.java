import java.awt.*;
import javax.swing.*;
public class PlatformerDriver{
    public static void main(String[] args){
        JFrame frame1 = new JFrame();
        PlatformerPanel panel = new PlatformerPanel();
        
        panel.setPreferredSize(new Dimension(1080,540));
        
        frame1.add(panel);
        frame1.pack();
        frame1.setVisible(true);
    }
}
//hints
//Wall jump on the left wall for the first level
//Wall jump by jumping into a wall and then jump
//