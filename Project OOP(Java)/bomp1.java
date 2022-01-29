
package myproject;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class bomp1 {
	Image img;
	public int x =(int) ((Math.random()*700)+20);;
	public int y= -1000;
	public int count = 0;
	bomp1(){
                String imageLocation = "Fire3.gif";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		runner.start();
	}
	Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
                    y += 5;
                    if(y >= 1100){
			img = null;
			runner = null;
			x = -500;
			y = -500;
                    }
                    try{
			runner.sleep(10);
                    }catch(InterruptedException e){}
                }
            }
	});
	
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,45,45));
	}
}

/*  Thread timebomp1 = new Thread(new Runnable(){
         public void run() {
             while(true){
                     try{
                         if(startbomp == false){
                             Thread.sleep((long)(Math.random()*10000)+1000);
                         }
                     }catch(InterruptedException e){
                         e.printStackTrace();
                     }
                     if(startbomp == false){
                         bompp1.add(new bomp1());
                     }
             }
         }
     });
  for(int i=0 ; i<bompp1.size();i++){
            g.drawImage( bompp1.get(i).getImage() ,bompp1.get(i).getX(),bompp1.get(i).getY(),90,60,this);
            mychar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mychar.x-bompp1.get(i).getX()),2))+(Math.pow(Math.abs(mychar.y-bompp1.get(i).getY()),2)));
            
            if(mychar.distanceP <= 50){
                bompp1.remove(i);
                mychar.alive -= 10;
            }
        }*/