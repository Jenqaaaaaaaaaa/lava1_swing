import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 18.10.2016.
 */
public class SpriteComputer implements Runnable {
    private String spriteComputer = "Images/computer.png";
    private Image imageComputer;
    private int cx;
    private int cy;

    public SpriteComputer(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(spriteComputer));
        imageComputer = ii.getImage();
        cx=30;
        cy=80;
    }

    public int getCX(){return cx;}

    public int getCY(){return cy;}

    public Image getImageComputer(){return imageComputer;}

    @Override
    public void run() {
        SpriteComputer sc = new SpriteComputer();
        new Thread(sc).start();

    }
}
