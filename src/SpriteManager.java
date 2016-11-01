import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SpriteManager implements Runnable {
    private String spriteManager = "Images/man.jpg";

    public int dx;
    public int dy;
    public int x;
    public int y;
    public int managerHeight=20;
    public int managerWidth=20;

    public SpriteComputer SpriteComputer;
    public Screen screen;
    public ComputersControl computersControl;


    private Image image;



    public SpriteManager(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(spriteManager));
        image = ii.getImage();
        x=240;
        y=60;
        
        
    }



    public void border(){
        if(x==0||y==0){
            dx=0;
            dy=0;

        }
        if (x==720||y==485) {
            dx = 0;
            dy = 0;
        }


    }

    public void move(){
            x += dx;
            y += dy;
        managerWidth=x+30;
        managerHeight=y+30;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getManagerWidth() {
        return managerWidth;
    }

    public int getManagerHeight() {
        return managerHeight;
    }

    public Image getImage(){
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();


            if (key == KeyEvent.VK_LEFT&&x>=5) {
                dx = -1;
            }

            if (key == KeyEvent.VK_RIGHT&&x<=715) {
                dx = 1;
            }

            if (key == KeyEvent.VK_UP&&y>=10) {
                dy = -1;
            }

            if (key == KeyEvent.VK_DOWN&&y<=480) {
                dy = 1;
            }
            /*
            if(x==1||x==719){
                dx=5;

            }

            if(y==5||y==484){
                dy=5;

            }
            */
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


    public void Collision1(){



        SpriteComputer spriteComputer = new SpriteComputer();
        computersControl = new ComputersControl();
       
        dx=0;
        dy=0;
        if ((x >= spriteComputer.getCx()) && ((x <= spriteComputer.getCx() + spriteComputer.getComputerWidth()))){x=x-10;}
        if((y >= spriteComputer.getCy()) && (y <= spriteComputer.getCy() + spriteComputer.getComputerHeight())){y=y-10;}


        String l ="123";
        String p="123";
        JFrame frame = new JFrame();
        JPanel autorization = new JPanel();
        JTextField login = new JTextField(7);
        JTextField pass = new JTextField(7);
        JButton enter = new JButton("Войти");
        JButton logNull = new JButton();
        JButton passNull = new JButton();
        login.setText("Логин");
        pass.setText("Пароль");
        login.setLocation(100,50);
        pass.setLocation(100,100);
        enter.setLocation(275,75);


        logNull.addActionListener(e -> {
            login.setText(null);
        });

        passNull.addActionListener(e -> {
            pass.setText(null);
        });

        enter.addActionListener(e -> {
            if(l.equals(login.getText())&&p.equals(pass.getText())){
            computersControl.ComputersControl();
            }
        });

        frame.add(autorization);
        autorization.add(login);
        autorization.add(logNull);
        autorization.add(pass);
        autorization.add(passNull);
        autorization.add(enter);
        frame.setSize(300,100);
        frame.setLocation(300,200);
        frame.setVisible(true);






    }




    @Override
    public void run() {
    SpriteManager s1 = new SpriteManager();
        new Thread(s1).start();
    }


}
