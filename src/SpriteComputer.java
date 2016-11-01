import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 18.10.2016.
 */

public class SpriteComputer implements Runnable {
    private String spriteComputer = "Images/computer.png";
    private Image imageComputer;
    public int cmx;
    public int cmy;
    public int cx;
    public int cy;
    public int computerWidth=130;
    public int computerHeight=80;





    public SpriteComputer(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(spriteComputer));
        imageComputer = ii.getImage();
        cmx=330;
        cmy=420;


    }

    public int getCMX(){return cmx;}

    public int getCMY(){return cmy;}

    public int getComputerWidth(){return computerWidth;}

    public int getComputerHeight(){return computerHeight;}

    public int getCx(){return cx=cmx-60;}

    public int getCy(){return cy=cmy-70;}



    public Image getImageComputer(){return imageComputer;}

    @Override
    public void run() {
        SpriteComputer sc = new SpriteComputer();
        new Thread(sc).start();

    }



}
