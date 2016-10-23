import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import Model.*;

/**
 * Created by admin on 18.10.2016.
 */
public class SpriteManager implements Runnable {
    private String spriteManager = "Images/man.jpg";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private boolean r=false;
    private Image image;

    public SpriteManager(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(spriteManager));
        image = ii.getImage();
        x=40;
        y=60;
    }

    public void move(){
        x+=dx;
        y+=dy;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Image getImage(){
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();



        if (key == KeyEvent.VK_LEFT) {
            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 5;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -5;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 5  ;
        }
    }

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                dx = 0;
            }

            if (key == KeyEvent.VK_RIGHT) {
                dx = 0;
            }

            if (key == KeyEvent.VK_UP) {
                dy = 0;
            }

            if (key == KeyEvent.VK_DOWN) {
                dy = 0;
            }
        }



    @Override
    public void run() {
    SpriteManager s1 = new SpriteManager();
        new Thread(s1).start();
    }


}
