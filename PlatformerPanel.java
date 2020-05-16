import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class PlatformerPanel extends JPanel{
    private double x=0;
    private double y=440;
    private double ySpeed=0;
    private double xSpeed=0;
    private boolean right;
    private boolean left; 
    Levels level = new Levels();
    private boolean canJump=false;
    private boolean wallJump=false;

    public PlatformerPanel(){
        setFocusable(true);
        addKeyListener(new myKeyListener());
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,1080,540);
        g.setColor(Color.RED);
        g.fillOval((int)x,(int)y,100,100);
        if(x>960){
            x=0;
            level.addLevel();
        }
        
        if(level.vert(y,ySpeed, x)){
            y+=ySpeed;
            canJump=false;
        }
        else{
            ySpeed=0;
            canJump=true;
            wallJump = false;
        }
        if(level.horiz(x,xSpeed,y,g)){
            x+=xSpeed;
            wallJump=false;
        }
        else{
            canJump=true;
            wallJump=true;
        }
        if(y<getHeight()-101)
            ySpeed+=0.15;
        else
        {
            ySpeed=0;
            y = getHeight()-100;
            //while(y>getHeight()-100){
            //    y--;
            //}
            //y++;
        }
        try{
            Thread.sleep(10);
        }
        catch(Exception e){
        }
        g.setColor(Color.WHITE);
        
        this.repaint();
    }
    public class myKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            
            if(e.getKeyCode() == 37){
                xSpeed=-3;
                left = true;
            }
            if(e.getKeyCode() == 39){
                xSpeed=3;
                right = true;
            }
            if(e.getKeyCode() == 38){
                if(canJump||y>436){
                    ySpeed = -7;
                    if(wallJump){
                    xSpeed=-xSpeed;
                    wallJump=false;
                }
                }  
            }
        }

        public void keyReleased(KeyEvent e){
            
            if(e.getKeyCode() == 37){
                left = false;
                if(!right)
                    xSpeed=0;
            }
            if(e.getKeyCode() == 39){
                right = false;
                if(!left)
                    xSpeed=0;
            }
            
        }
    }
}

