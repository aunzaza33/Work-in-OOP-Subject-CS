package myproject;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Mage {
    public ImageIcon im = new ImageIcon(this.getClass().getResource("1.png"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("back1.png"));
    public ImageIcon pickNH4NO3 = new ImageIcon(this.getClass().getResource("c1pickNH4NO3.png"));
    public ImageIcon pickbackNH4NO3 = new ImageIcon(this.getClass().getResource("c1pickbackNH4NO3.png"));
    public ImageIcon attack = new ImageIcon(this.getClass().getResource("c1attack.png"));
    public ImageIcon backattack = new ImageIcon(this.getClass().getResource("c1backattack.png"));
    public int NH4NO3width = 65;
    public int NH4NO3height = 65;
    public int walk = 0;
    public int walky = 558;
    public int count = 0;
    public int swordx = 100;
    public int swordy = 100;
    public int HP=100;
    public int distanceP;
    public int ATK =20;
    public boolean alive = true;
    public int checkfloor = 0;
    Mage(){
      
    }
}
