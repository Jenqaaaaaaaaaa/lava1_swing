import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.KeyAdapter;
 import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Toolkit;


public class Screen extends JPanel implements ActionListener{

    public Timer timer;
    public SpriteManager spriteManager;
    public SpriteComputer spriteComputer;
    //public Collision collision;
    boolean bl = false;



    public Screen(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        spriteManager = new SpriteManager();
        spriteComputer = new SpriteComputer();



        timer = new Timer(5, this);
        timer.start();
    }



    public void paint(Graphics g) {
        super.paint(g);


        Graphics2D g2dm = (Graphics2D)g;
        Graphics2D g2dc = (Graphics2D)g;

        g2dm.drawImage(spriteManager.getImage(), spriteManager.getX(), spriteManager.getY(), this);
        g2dc.drawImage(spriteComputer.getImageComputer(),spriteComputer.getCMX(),spriteComputer.getCMY(),this);


        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void paintComputer(Graphics g){
        super.paint(g);

        Graphics g2d= (Graphics2D)g;

        g2d.drawImage(spriteComputer.getImageComputer(),spriteComputer.getCMX(),spriteComputer.getCMY(),this);


    }



    public void run() {
        Screen t1 = new Screen();
        new Thread((Runnable) t1).start();
    }

    public boolean getBl(boolean bl){return this.bl = bl;}

    public void actionPerformed(ActionEvent e) {




        spriteManager.move();
        spriteManager.border();


            if (((spriteManager.getX() >= spriteComputer.getCx()) && ((spriteManager.getX() <= spriteComputer.getCx() + spriteComputer.getComputerWidth())) && ((spriteManager.getY() >= spriteComputer.getCy()) && (spriteManager.getY() <= spriteComputer.getCy() + spriteComputer.getComputerHeight())))) {
                spriteManager.Collision1();
            }


        //if(((spriteManager.getX()+spriteManager.getManagerWidth()>=spriteComputer.getCMX())&&((spriteManager.getX()<=spriteComputer.getCMX()+spriteComputer.getComputerWidth()))&&((spriteManager.getY()+spriteManager.getManagerHeight()>=spriteComputer.getCMY())&&(spriteManager.getY()<=spriteComputer.getCMY()+spriteComputer.getComputerHeight()))))




            repaint();
    }




    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            spriteManager.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            spriteManager.keyPressed(e);
        }
    }
}
