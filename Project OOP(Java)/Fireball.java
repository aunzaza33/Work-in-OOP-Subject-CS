package myproject;
import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fireball extends JPanel{
    public ImageIcon[] imfire = new ImageIcon[5];
    public int y;
    public int x;
    public int point=1;
    public int count=0;
    Fireball(int x,int y){
        for(int i=0;i<imfire.length;i++){
            String imageLocation = "b"+(i+1)+".png";
            imfire[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x=x;
            this.y=y;
    }
	
    public void move(){

      this.x-=10;
  
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
}
 /*for(int i=0 ; i<fireball2.size();i++){
                    			    fireball2.remove(i);
                    }
                     for(int i=0 ; i<fireball.size();i++){
                    			    fireball.remove(i);
                    }*/
                