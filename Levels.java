import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Levels extends JPanel{
    private int level=1;
    private ArrayList<Platform> a = new ArrayList<Platform>();
    private ArrayList<Platform> b = new ArrayList<Platform>();
    private ArrayList<Platform> c = new ArrayList<Platform>();
    
    public Levels(){
        //first level
        a.add(new Platform(270,405,1000,1000));
        a.add(new Platform(540,270,1000,1000));
        a.add(new Platform(810,135,1000,1000));
        //second level
        b.add(new Platform(216,100,50,500));
        b.add(new Platform(432,0,50,440));
        b.add(new Platform(648,100,50,500));
        b.add(new Platform(864,0,50,440));
        //third level
        c.add(new Platform(200,200,100,100));
        c.add(new Platform(900,200,500,440));
        c.add(new Platform(700,200,200,50));
        c.add(new Platform(450,200,100,100));
    }
    public void addLevel(){
        level++;
    }
    public boolean horiz(double x, double xAdd, double y, Graphics g){
        boolean end = true;
        if(x<0&&xAdd<0)
        end = false;

        if(level==1){
            for(int i = 0; i<a.size();i++){
                g.setColor(Color.BLACK);
                g.fillRect(a.get(i).getX(),a.get(i).getY(),
                a.get(i).getLength(),a.get(i).getHeight());
                if((x+xAdd+100>a.get(i).getX()
                &&x+xAdd+100<a.get(i).getX()+a.get(i).getLength()
                ||x+xAdd>a.get(i).getX()
                &&x+xAdd<a.get(i).getX()+a.get(i).getLength())
                &&(y>a.get(i).getY()&&y<a.get(i).getY()+a.get(i).getHeight()
                ||y+100>a.get(i).getY()&&y+100<a.get(i).getY()+a.get(i).getHeight())
                )
                end = false;
            }
        }
        if(level==2){
            for(int i = 0; i<b.size();i++){
                g.setColor(Color.BLACK);
                g.fillRect(b.get(i).getX(),b.get(i).getY(),
                b.get(i).getLength(),b.get(i).getHeight());
                if((x+xAdd+100>b.get(i).getX()
                &&x+xAdd+100<b.get(i).getX()+b.get(i).getLength()
                ||x+xAdd>b.get(i).getX()
                &&x+xAdd<b.get(i).getX()+b.get(i).getLength())
                &&(y>b.get(i).getY()&&y<b.get(i).getY()+b.get(i).getHeight()
                ||y+100>b.get(i).getY()&&y+100<b.get(i).getY()+b.get(i).getHeight())
                )
                end = false;
            }
        }
        if(level==3){
            for(int i = 0; i<c.size();i++){
                g.setColor(Color.BLACK);
                g.fillRect(c.get(i).getX(),c.get(i).getY(),
                c.get(i).getLength(),c.get(i).getHeight());
                if((x+xAdd+100>c.get(i).getX()
                &&x+xAdd+100<c.get(i).getX()+c.get(i).getLength()
                ||x+xAdd>c.get(i).getX()
                &&x+xAdd<c.get(i).getX()+c.get(i).getLength())
                &&(y>c.get(i).getY()&&y<c.get(i).getY()+c.get(i).getHeight()
                ||y+100>c.get(i).getY()&&y+100<c.get(i).getY()+c.get(i).getHeight())
                )
                end = false;
            }
        }
        if(level>3){
            g.drawString("You Win!",300,300);
        }
        return end;
    }
    public boolean vert(double y, double yAdd, double x){
        boolean end = true;
        if(level==1){
            for(int i = 0; i<a.size();i++){
                
                if((y+yAdd+100>a.get(i).getY()
                &&y+yAdd+100<a.get(i).getY()+a.get(i).getHeight()
                ||y+yAdd>a.get(i).getY()
                &&y+yAdd<a.get(i).getY()+a.get(i).getHeight())
                &&((x>a.get(i).getX()||x+100>a.get(i).getX())
                &&(x<a.get(i).getX()+a.get(i).getLength()
                ||x+100<a.get(i).getX()+a.get(i).getLength())))
                end = false;
            }
        }
        if(level==2){
            for(int i = 0; i<b.size();i++){
                
                if((y+yAdd+100>b.get(i).getY()
                &&y+yAdd+100<b.get(i).getY()+b.get(i).getHeight()
                ||y+yAdd>b.get(i).getY()
                &&y+yAdd<b.get(i).getY()+b.get(i).getHeight())
                &&((x>b.get(i).getX()||x+100>b.get(i).getX())
                &&(x<b.get(i).getX()+b.get(i).getLength()
                ||x+100<b.get(i).getX()+b.get(i).getLength())))
                end = false;
            }
        }
        if(level==3){
            for(int i = 0; i<c.size();i++){
                
                if((y+yAdd+100>c.get(i).getY()
                &&y+yAdd+100<c.get(i).getY()+c.get(i).getHeight()
                ||y+yAdd>c.get(i).getY()
                &&y+yAdd<c.get(i).getY()+c.get(i).getHeight())
                &&((x>c.get(i).getX()||x+100>c.get(i).getX())
                &&(x<c.get(i).getX()+c.get(i).getLength()
                ||x+100<c.get(i).getX()+c.get(i).getLength())))
                end = false;
            }
        }
        return end;
    }
}