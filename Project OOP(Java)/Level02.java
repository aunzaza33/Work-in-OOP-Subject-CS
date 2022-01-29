
package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;

public class Level02 extends JPanel implements ActionListener{

    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("wallpaper.jpg"));
    private ImageIcon mage = new ImageIcon(this.getClass().getResource("c1.png"));
    private ImageIcon magebackstep = new ImageIcon(this.getClass().getResource("c1backstep.png"));
    private ImageIcon underfloor = new ImageIcon(this.getClass().getResource("underfloor.png"));
    private ImageIcon NH4NO3 = new ImageIcon(this.getClass().getResource("NH4NO3.png"));
    private ImageIcon NH4NO3mage = new ImageIcon(this.getClass().getResource("c1pickNH4NO3.png"));
    private ImageIcon NH4NO3mageback= new ImageIcon(this.getClass().getResource("c1pickbackNH4NO3.png"));
    private ImageIcon NH4NO3mageat = new ImageIcon(this.getClass().getResource("c1attack.png"));
    private ImageIcon NH4NO3magebackat = new ImageIcon(this.getClass().getResource("c1backattack.png"));
    
    private ImageIcon floor1 = new ImageIcon(this.getClass().getResource("floor1.png"));
    private ImageIcon floor2 = new ImageIcon(this.getClass().getResource("floor1.png"));
    private ImageIcon floor3 = new ImageIcon(this.getClass().getResource("floor1.png"));
    
    private ImageIcon door = new ImageIcon(this.getClass().getResource("door.png"));
    
    private ImageIcon nextboss = new ImageIcon(this.getClass().getResource("nextlevel.png"));
    public JButton NextLevel = new JButton(nextboss);
    
    Mage charmage = new Mage();
    Rogue3 Rogue = new Rogue3();
    Rogue2 Rogue2 = new Rogue2();
    Rogue1 Rogue3 = new Rogue1();
    public ArrayList<Fireball> fireball = new ArrayList<Fireball>();
    public ArrayList<Fireball2> fireball2 = new ArrayList<Fireball2>();
    int checkbacktofront = 0;
    boolean checkpickupNH4NO3 = false;
    public int checknearRogue = 0;
    public int times;
    public int score;
    public int alive;
    public int point;
    public int checkattack;
    boolean checkfireball ;
    boolean checknextlevel = false;
    
    boolean timestart = true;
   
    private Timer timer = new Timer(40, new Listener());
 
    private Timer timercount = new Timer(1000, new Listener());
    
    GameOver gameover = new GameOver();
    
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{                          
      
                    if(charmage.walk == 1100 && charmage.checkfloor == 3 && Rogue.alive == false && Rogue2.alive == false && Rogue3.alive == false){
                        checknextlevel = true;
                    }
                    
                    //Rogue1
                    if(Rogue.alive == true){
                        if(Rogue.back == false){
                            if(Rogue.x<=0) Rogue.x=1000;
                            else Rogue.x= Rogue.x-5;
                        }
                        else{
                            if(Rogue.x<=0) Rogue.x=1000;
                            else Rogue.x= Rogue.x+5;
                        }
                        Rogue.distanceP = (int)Math.sqrt((Math.pow(Math.abs(Rogue.x-charmage.walk),2))+(Math.pow(Math.abs(Rogue.y-charmage.walky),2)));
                        
                        if(charmage.checkfloor == 1){
                           if(Rogue.distanceP <= 300){
                          
                                //checknearRogue = 1;
                            }
                            else{
                                checknearRogue = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(Rogue.distanceP <= 60){
                                Rogue.x = charmage.walk+100;
                                alive-=1;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(Rogue.distanceP <= 60){
                                Rogue.x = charmage.walk-100;
                                alive-=1;
                            }
                        }


                        if(Rogue.x <= 590){
                            Rogue.back = true;
                        }
                        else if(Rogue.x >= 1100){
                            Rogue.back = false;
                        }
                        
                    } 
                    
                    //Rogue2
                    if(Rogue2.alive == true){
                        if(Rogue2.back == false){
                            if(Rogue2.x >= 0) 
                                Rogue2.x= Rogue2.x+5;
                        }
                        else{
                            if(Rogue2.x <= 550)
                                Rogue2.x= Rogue2.x-5;
                        }
                        
                        Rogue2.distanceP = (int)Math.sqrt((Math.pow(Math.abs(Rogue2.x-charmage.walk),2))+(Math.pow(Math.abs(Rogue2.y-charmage.walky),2)));
                        
                        if(charmage.checkfloor == 2){
                            if(Rogue2.distanceP <= 300){
                              
                                checknearRogue = 2;
                            }
                            else{
                                checknearRogue = 0;
                            }
                        }
                        
                        if(checkbacktofront == 0){
                            
                            if(Rogue2.distanceP <= 60){
                                Rogue2.x = charmage.walk+100;
                                alive-=1;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(Rogue2.distanceP <= 60){
                                Rogue2.x = charmage.walk-100;
                                alive-=1;
                            }
                        }


                        if(Rogue2.x >= 550){
                            Rogue2.back = true;
                        }
                        else if(Rogue2.x <= 50){
                            Rogue2.back = false;
                        }

                    } 
                    
                    //Rogue3
                    if(Rogue3.alive == true){
                        if(Rogue3.back == false){
                            if(Rogue3.x<=0) Rogue3.x=1000;
                            else Rogue3.x= Rogue3.x-5;
                        }
                        else{
                            if(Rogue3.x<=0) Rogue3.x=1000;
                            else Rogue3.x= Rogue3.x+5;
                        }
                        Rogue3.distanceP = (int)Math.sqrt((Math.pow(Math.abs(Rogue3.x-charmage.walk),2))+(Math.pow(Math.abs(Rogue3.y-charmage.walky),2)));
                        
                        if(charmage.checkfloor == 3){
                           if(Rogue3.distanceP <= 300){
                                checknearRogue = 3;
                                 
                            }
                            else{
                                checknearRogue = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(Rogue3.distanceP <= 60){
                                Rogue3.x = charmage.walk+100;
                                alive-=1;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(Rogue3.distanceP <= 60){
                                Rogue3.x = charmage.walk-100;
                                alive-=1;
                            }
                        }


                        if(Rogue3.x <= 300){
                            Rogue3.back = true;
                        }
                        else if(Rogue3.x >= 900){
                            Rogue3.back = false;
                        }
                        
                    } 
                    
                    Thread.sleep(100);
                    
                }catch(Exception e){
                 
                }
                
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    
    
    Level02(){
        this.setFocusable(true);
        this.setLayout(null);
        
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
       
                if(a == KeyEvent.VK_D){
                    point=0;
                    checkbacktofront = 0;
                    if(checkbacktofront == 0){
                        if(charmage.walk >= 1100){
                            charmage.walk = 1100;
                        }
                        else{
                            
                            if(charmage.checkfloor == 2){
                                if(charmage.walk >= 630)
                                    charmage.walk = 630;
                            }
                            
                            charmage.walk+=10;
                            charmage.count++;
                            
                            if(charmage.count >= 2){
                                charmage.count = 0;
                            }
                        }
                    }
                }
                else if(a == KeyEvent.VK_A){
                    checkbacktofront = 1;
                    point =1;
                    if(checkbacktofront == 1){
                        if(charmage.walk <= 50){
                            charmage.walk = 50;
                        }
                        else{
                            
                            if(charmage.checkfloor == 1){
                                if(charmage.walk <= 590)
                                    charmage.walk = 590;
                            }
                            else if(charmage.checkfloor == 3){
                                if(charmage.walk <= 290)
                                    charmage.walk = 290;
                            }
                            
                            charmage.walk-=10;
                            charmage.count++;
                            
                            if(charmage.count >= 2){
                                charmage.count = 0;
                            }
                        }
                    }
                }
                else if(a == KeyEvent.VK_W){
                    if(charmage.checkfloor == 0){
                        if(charmage.walk >= 590){
                            charmage.checkfloor = 1;
                            charmage.walky -= 138;
                        }
                    }
                    else if(charmage.checkfloor == 1){
                        if(charmage.walk <= 620){
                            charmage.checkfloor = 2;
                            charmage.walky -= 170;
                        }
                    }
                    else if(charmage.checkfloor == 2){
                        if(charmage.walk >= 290){
                            charmage.checkfloor = 3;
                            charmage.walky -= 170;
                        }
                    }
                }
                else if(a == KeyEvent.VK_S){
                    if(charmage.checkfloor == 1){
                        if(charmage.walk >= 590){
                            charmage.checkfloor = 0;
                            charmage.walky = 558;
                        }
                    }
                    else if(charmage.checkfloor == 2){
                        if(charmage.walk >= 590){
                            charmage.checkfloor = 1;
                            charmage.walky = 420;
                        }
                    }
                    else if(charmage.checkfloor == 3){
                        if(charmage.walk <= 630){
                            charmage.checkfloor = 2;
                            charmage.walky = 250;
                        }
                    }
                }
                else if(a == KeyEvent.VK_SPACE){
                    if(checkattack == 0){
                        checkattack = 1;
                        checkfireball=false;
                        if(charmage.checkfloor == 0){
                           if(point==1){
                        fireball.add(new Fireball(charmage.walk-50,575));
                        }
                           else if(point==0){
                           fireball2.add(new Fireball2(charmage.walk+50,575));
                           }
                           }
                        else if(charmage.checkfloor == 1){
                           if(point==1){
                        fireball.add(new Fireball(charmage.walk-50,440));
                        }
                           else if(point==0){
                           fireball2.add(new Fireball2(charmage.walk+50,440));
                        }
                        }
                        else if(charmage.checkfloor == 2){
                           if(point==1){
                              fireball.add(new Fireball(charmage.walk-50,270));
                        }
                           if(point==0){
                              fireball2.add(new Fireball2(charmage.walk+50,270));
                        }
                        }
                        else if(charmage.checkfloor == 3){
                           if(point==1){
                             fireball.add(new Fireball(charmage.walk-50,100));
                        }
                        if(point==0){
                           fireball2.add(new Fireball2(charmage.walk+0,100));
                        }
                        }
                    }
                }
                 
                    
            }
            public void keyReleased(KeyEvent e){
                charmage.count = 0;
            }
        });
        
        timer.start();
        time.start();
        timercount.start();
    }
    
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                times--;
            }
            repaint();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));	
        g.drawString("Time: "+times, 520, 50);
        g.drawString("Score: "+score, 300, 50);
        g.drawString("Alive: "+alive, 750, 50);  
        
        g.drawImage(floor1.getImage(), 600, 490, 889, 59, this);
        g.drawImage(floor1.getImage(), 50, 320, 889, 59, this);
        g.drawImage(floor1.getImage(), 300, 150, 889, 59, this);
        
        g.drawImage(door.getImage(), 1100, 66, 57, 84, this);
        //ballfire
        for(int i=0;i<fireball.size();i++){
		      Fireball ba = fireball.get(i);
            g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,50,50, null);
		      ba.move();
            ba.count++;    
            Rogue.distancePfire=(int)Math.sqrt((Math.pow(Math.abs(Rogue.x-ba.x),2))+(Math.pow(Math.abs(Rogue.y-ba.y),2)));
            Rogue2.distancePfire=(int)Math.sqrt((Math.pow(Math.abs(Rogue2.x-ba.x),2))+(Math.pow(Math.abs(Rogue2.y-ba.y),2)));
            Rogue3.distancePfire=(int)Math.sqrt((Math.pow(Math.abs(Rogue3.x-ba.x),2))+(Math.pow(Math.abs(Rogue3.y-ba.y),2)));        
		      checkfireball = false;
            if(Rogue.distancePfire<=20){   
               
		    	  checknearRogue = 1;
              fireball.remove(i);
              score+=50;
              Rogue.alive = false;        
              checknearRogue = 0;
               
               //Rogue.alive =false;
		    }
           if(Rogue2.distancePfire<=20){    
		    	  checknearRogue = 2;
              score+=50;
              Rogue2.alive = false;        
              checknearRogue = 0;
              fireball.remove(i);		    }
           if(Rogue3.distancePfire<=20){      
               
		    	  checknearRogue = 3;
              score+=50;
              Rogue2.alive = false;        
              checknearRogue = 0;
              fireball.remove(i);
		    }
		}
         		for(int i=0;i<fireball2.size();i++){
                    Fireball2 ba = fireball2.get(i);
      		    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,50,50, null);
      		    ba.move();
      		    ba.count++;
      		    
      		Rogue.distancePfire2=(int)Math.sqrt((Math.pow(Math.abs(Rogue.x-ba.x),2))+(Math.pow(Math.abs(Rogue.y-ba.y),2)));
            Rogue2.distancePfire2=(int)Math.sqrt((Math.pow(Math.abs(Rogue2.x-fireball2.get(i).getX()),2))+(Math.pow(Math.abs(Rogue2.y-fireball2.get(i).getY()),2)));
            Rogue3.distancePfire2=(int)Math.sqrt((Math.pow(Math.abs(Rogue3.x-ba.x),2))+(Math.pow(Math.abs(Rogue3.y-ba.y),2)));      
		      checkfireball = false;
            if(Rogue.distancePfire2<20){  
		    	  checknearRogue = 1;
              score+=50;
              Rogue.alive = false;        
              checknearRogue = 0;
              fireball2.remove(i);
		    }
           if(Rogue2.distancePfire2<=20){      
               checkfireball = true;
		    	   checknearRogue = 2;
              
               fireball2.remove(i);
               
               //Rogue2.alive =false;
		    }
           if(Rogue3.distancePfire2<=20){ 
              checknearRogue = 1;
              score+=50;
              Rogue3.alive = false;        
              checknearRogue = 0;
              fireball2.remove(i);
		    }
      		    }
   		
        //Rogue1
        if(Rogue.alive == true)
        {
            if(Rogue.back == true){
                g.drawImage(Rogue.imb.getImage(), Rogue.x, Rogue.y, 50, 60, this); 
            }
            else{
               g.drawImage(Rogue.im.getImage(), Rogue.x, Rogue.y, 50, 60, this); 
            }
        }
        //Rogue2
        if(Rogue2.alive == true)
        {
            if(Rogue2.back == true){
                g.drawImage(Rogue2.imb.getImage(), Rogue2.x, Rogue2.y, 50, 60, this); 
            }
            else{
               g.drawImage(Rogue2.im.getImage(), Rogue2.x, Rogue2.y, 50, 60, this); 
            }
        }
        //Rogue3
        if(Rogue3.alive == true)
        {
            if(Rogue3.back == true){
                g.drawImage(Rogue3.imb.getImage(), Rogue3.x, Rogue3.y, 50, 60, this); 
            }
            else{
               g.drawImage(Rogue3.im.getImage(), Rogue3.x, Rogue3.y, 50, 60, this); 
            }
        }
        
        
        if(checkbacktofront == 0){
            if(charmage.count > 0){
                g.drawImage(charmage.im.getImage(), charmage.walk, charmage.walky, 70, 70, this);
            }
            else if(charmage.count == 0){
                if(checkpickupNH4NO3 == true){
                    if(checkattack == 1){
                     g.drawImage(charmage.attack.getImage(), charmage.walk, charmage.walky, 70, 70, this);
                    if(checknearRogue == 1){
                        score+=50;
                        Rogue.alive = false;
                        checknearRogue = 0;
                    }
                    else if(checknearRogue == 2){
                        score+=50;
                        Rogue2.alive = false;
                        checknearRogue = 0;
                    }
                    else if(checknearRogue == 3){
                        score+=50;
                        Rogue3.alive = false;
                        checknearRogue = 0;}
                    checkattack = 0;
                        
                      
                }
                
                else if(checkattack == 0){
                    g.drawImage(charmage.pickNH4NO3.getImage(), charmage.walk, charmage.walky, 70, 70, this);
                }
                    
                    
                }
                else
                    g.drawImage(mage.getImage(), charmage.walk, charmage.walky, 70, 70, this);
            }   
            
            if(checkpickupNH4NO3 == true){

            }
        }
        else if(checkbacktofront == 1){
            if(charmage.count > 0){
                g.drawImage(charmage.imb.getImage(), charmage.walk, charmage.walky, 70, 70, this);
            }
            else if(charmage.count == 0){
                if(checkpickupNH4NO3 == true){if(checkattack == 1){
                    
                    g.drawImage(charmage.backattack.getImage(), charmage.walk, charmage.walky, 70, 70, this);
                    checkattack = 0;
                       
                    /*if(checknearRogue == 1){
                        score+=50;
                        Rogue.alive = false;
                        checknearRogue = 0;
                    }
                    else if(checknearRogue == 2){
                        score+=50;
                        Rogue2.alive = false;
                        checknearRogue = 0;
                    }
                    else if(checknearRogue == 3){
                        score+=50;
                        Rogue3.alive = false;
                        checknearRogue = 0;
                    }*/
                }
                else if(checkattack == 0){
                    g.drawImage(charmage.pickbackNH4NO3.getImage(), charmage.walk, charmage.walky, 70, 70, this);
                }
                   
                }
                else
                    g.drawImage(magebackstep.getImage(), charmage.walk, charmage.walky, 70, 70, this);
            } 
            
          
        }

  
        
        if(checkpickupNH4NO3 == false){
            g.drawImage(NH4NO3.getImage(), 900, 560, 70, 70, this);

            if(charmage.walk == 900 && charmage.checkfloor == 0){
                checkpickupNH4NO3 = true;
            }
        
        
                         
}
        g.drawImage(underfloor.getImage(), 0, 0, 1200, 665, this);
        
        
        if(alive <= 0 || times <= 0){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,50));		
            g.drawString("SCORE   "+score,430,230);	     
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,70));
            g.drawString("You Died!",400, 150);
            timer.stop();
            timercount.stop();
        }     
        
        if(checknextlevel == true){
            this.setLayout(null);
            g.setColor(Color.ORANGE);
            g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,50));		
            g.drawString("SCORE   "+score,430,230);	     
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,70));
            g.drawString("You Win Level 2!",340, 150);
            timer.stop();
            timercount.stop();
            checknextlevel = false;
            NextLevel.setBounds(370, 400, 404, 46);
            NextLevel.setBorderPainted(false);
            NextLevel.setBorder(null);
            NextLevel.setOpaque(false);
            NextLevel.setContentAreaFilled(false);
            NextLevel.setForeground(Color.red);
            add(NextLevel);
        }
    }
    
    
}
