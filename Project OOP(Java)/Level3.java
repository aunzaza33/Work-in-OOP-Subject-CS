package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Level3 extends JPanel implements ActionListener{
    
    private Timer timer = new Timer(1000, new Level3.Listener());
    
    private ImageIcon wallboss = new ImageIcon(this.getClass().getResource("bosswall.jpg"));
    private ImageIcon winner = new ImageIcon(this.getClass().getResource("winner.png"));
    private ImageIcon fire1 = new ImageIcon(this.getClass().getResource("Fire.gif"));
    private ImageIcon fire2 = new ImageIcon(this.getClass().getResource("Fire.gif"));
    private ImageIcon prins = new ImageIcon(this.getClass().getResource("Princess.png"));
    
    public int r;
    public int tt = 120;
    public int checkbackorfront = 0;
    public int checkattacker = 0;
    public int alive;
    public boolean timestart = false;
    public int checkenemy = 0;
    public int score =0;
    public boolean checknextlevel = false;
    int checkbacktofront = 0;
    public boolean startbomp = false;
    public boolean checkgameover = false;
    public ArrayList<Fireball2> fireball = new ArrayList<Fireball2>();
     Mage mage = new  Mage();
    Boss boss = new Boss();
    Rogue1 Rogue = new Rogue1();
  
    public ArrayList<bomp1> bompp1 = new ArrayList<bomp1>();
    
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{
                    if(boss.alive == true){
                        if(boss.back == false){
                            if(boss.y<=0) boss.y=500;
                            else boss.y= boss.y-5;
                        }
                        else{
                            if(boss.y<=0) boss.y=10;
                            else boss.y= boss.y+5;
                        }
                        boss.distanceP = (int)Math.sqrt((Math.pow(Math.abs(boss.x-mage.walk),2))+(Math.pow(Math.abs(boss.y-mage.walky),2)));
                        
                        if(mage.checkfloor == 0){
                           if(boss.distanceP <= 80){
                                checkenemy = 1;
                                
                            }
                            else{
                                checkenemy = 0;
                            } 
                        }   
                        
                        if(checkbacktofront == 0){
                            
                            if(boss.distanceP <= 60){
                                boss.x = mage.walk+200;
                                mage.HP -= boss.ak;
                            }
                        }
                        else if(checkbacktofront == 1){
                            
                            if(boss.distanceP <= 60){
                                //boss.x = mage.x3-200;
                                mage.HP -= boss.ak;
                            }
                        }


                        if(boss.y <= 0){
                            boss.back = true;
                        }
                        else if(boss.y >= 500){
                            boss.back = false;
                        }      
                    }
                    Thread.sleep(50);
                }
                catch(Exception e){
                 
                }
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    Thread timebomp1 = new Thread(new Runnable(){
         public void run() {
             while(true){
                     try{
                         if(startbomp == false){
                             Thread.sleep((long)(Math.random()*2000)+1000);
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
    
    
    Level3(){
        this.setFocusable(true);
        this.setLayout(null);
       this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a == KeyEvent.VK_D){
                    checkbackorfront = 0;
                    if(checkbackorfront == 0){
                        if(mage.walk >= 1050){
                            mage.walk = 1050;
                        }
                        else{
                            mage.walk+=10;
                            mage.count++;
                            
                            if(mage.count >= 2){
                                mage.count = 0;
                            }
                        }
                    }
                }
                else if(a == KeyEvent.VK_A){
                    checkbackorfront = 1;
                    if(checkbackorfront == 1){
                        if(mage.walk<= 0){
                            mage.walk = 0;
                        }
                        else{
                            mage.walk-=10;
                            mage.count++;
                            
                            if(mage.count >= 2){
                                mage.count = 0;
                            }
                        }
                    }
                }
                else if(a == KeyEvent.VK_B){
                    checknextlevel = true;
                }
                else if(a == KeyEvent.VK_SPACE){
                    if(checkattacker == 0){
                        checkattacker = 1;
                        fireball.add(new Fireball2(mage.walk,575));
                    }
                }
                
                
            }
            public void keyReleased(KeyEvent e){
                mage.count=0;
            }
            
       });         
       time.start();
       timer.start();
       timebomp1.start();
        
    }
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timer){
                tt--;
            }
            repaint();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallboss.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(fire1.getImage(), -49, 505, 160, 160, this);  
        g.drawImage(fire1.getImage(), 910, 240, 120, 120, this);
        g.drawImage(fire1.getImage(), 920, 240, 120, 120, this);
        g.drawImage(fire1.getImage(), 950, 240, 120, 120, this);
        g.drawImage(fire1.getImage(), 990, 240, 120, 120, this);
        g.drawImage(fire1.getImage(), 22, 220, 100, 100, this);
        
        
        for(int i=0;i<fireball.size();i++){
		      Fireball2 ba = fireball.get(i);
            g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,50,50, null);
		      ba.move();
            ba.count++;    
            boss.distancePfire=(int)Math.sqrt((Math.pow(Math.abs(boss.x-ba.x),2))+(Math.pow(Math.abs(boss.y-ba.y),2)));      
		      //checkfireball = false;
            if(boss.distancePfire<=100){   
               
		    	   boss.HP -=10;
            
              
               fireball.remove(i);
               }
               }

        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
        g.drawString("Score: "+score, 350, 50);
        g.drawString("Time: "+tt, 200, 50);
        g.drawImage(prins.getImage(), 1100, 550, 57, 84, this);
        
        Random rx = new Random();
       for(int j=0 ; j<bompp1.size();j++){
        
       }
        for(int i=0 ; i<bompp1.size();i++){
        bompp1.get(i).x = rx.nextInt(100);
                     bomp1 ball=bompp1.get(i);
            g.drawImage( ball.getImage() ,ball.x-r,ball.y-r,90,90,this);
            
            ball.x=(int)(10*Math.sin(Math.toDegrees(ball.x/10)));
            ball.y++;
            mage.distanceP = (int)Math.sqrt((Math.pow(Math.abs(mage.walk-ball.x),2))+(Math.pow(Math.abs(mage.walky-ball.y),2)));
            
            if(mage.distanceP <= 50){
                bompp1.remove(i);
                mage.HP -= 10;
            }
           // g.drawImage( bompp1.get(j).getImage() ,bompp1.get(j).getX()-r,bompp1.get(j).getY()-r,90,90,this);
       // }
        
        }
        g.setColor(Color.green);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
        
        if(boss.alive == true){
            g.drawString("HP: "+boss.HP, boss.x+15, boss.y+8);
            g.drawImage(boss.bigboss.getImage(), boss.x, boss.y, 140, 140, this);
        }
        //Attack
        if(boss.alive == true){
            if(checkattacker == 1 && checkenemy == 1) {
                boss.HP -= mage.ATK;
                checkattacker = 0;
            }
        }
        if(mage.alive == true){  
       g.drawString("HP: "+mage.HP, mage.walk+50, mage.walky+10);
            if(checkbackorfront == 0){
                if(checkattacker == 0){
                    if(mage.count == 0){
                       g.drawImage(mage.pickNH4NO3.getImage(), mage.walk, mage.walky, 70, 70, this);

                    }
                    else{
                        g.drawImage(mage.im.getImage(), mage.walk, mage.walky, 70, 70, this);
                    }
                }
                else if(checkattacker == 1){
                    g.drawImage(mage.attack.getImage(), mage.walk, mage.walky, 70, 70, this);
                    checkattacker = 0;
                }
            }
            else if(checkbackorfront == 1){
                if(checkattacker == 0){
                    if(mage.count != 1){
                         g.drawImage(mage.pickbackNH4NO3.getImage(), mage.walk, mage.walky, 70, 70, this);
                    }
                    else{
                        
                         g.drawImage(mage.imb.getImage(), mage.walk, mage.walky, 70, 70, this);
                    }
                }
                else if(checkattacker == 1){
                   g.drawImage(mage.backattack.getImage(), mage.walk, mage.walky, 70, 70, this);
                    checkattacker = 0;
                }

            }
        }
        
        
        if(mage.HP <= 0){
            checkgameover = true;
             this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallboss.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,50));		
            g.drawString("SCORE   "+score,430,230);	     
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,70));
            g.drawString("You Died!",400, 150);
            timer.stop();
            
        }
        else if(boss.HP <=0){
            g.drawImage(fire2.getImage(), boss.x, boss.y, 140, 140, this);
            boss.alive = false;
            checknextlevel = true;
        }
        if(checknextlevel == true){
            if(mage.walk >= 990){
                g.drawImage(winner.getImage(), 0, 0, 1200, 665, this);
            }
        }
        
      
            if(tt <= 0){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallboss.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,50));		
            g.drawString("SCORE   "+score,430,230);	     
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE,70));
            g.drawString("You Died!",400, 150);
            timer.stop();
            
        }     

             
  
        
    }
    @Override
        public void actionPerformed(ActionEvent e) {
            this.repaint();
        }    
    
}
