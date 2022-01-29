package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyProject extends JFrame implements ActionListener{
        
    EnterGame entergame = new EnterGame();
  Level1 levelone = new Level1();
    Level02 leveltwo = new Level02();
    Level3 levelthree = new Level3();
    
    
    public MyProject(){
        this.setSize(1200,700);
        this.add(entergame);
        entergame.requestFocusInWindow();
        entergame.StartGame.addActionListener(this);
        levelone.NextLevel.addActionListener(this);
        leveltwo.NextLevel.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == entergame.StartGame){
            this.setLocationRelativeTo(null);
            this.remove(entergame);
            this.setSize(1200,700);
            this.setTitle("Level 1");
            this.add(levelone);
            levelone.times = 60;
            levelone.alive =3 ;
            levelone.requestFocusInWindow();
           /* this.setLocationRelativeTo(null);
            this.remove(entergame);
            this.setSize(1200,700);
            this.setTitle("Slide Man Level Boss");
            this.add(leveltwo);
            leveltwo.times = 120;
            leveltwo.alive = 3;*/
            //leveltwo.requestFocusInWindow();
        }
              else if(e.getSource() == levelone.NextLevel){
            this.setLocationRelativeTo(null);
            this.remove(levelone);
            this.setSize(1200,700);
            this.setTitle(" Level 2");
            this.add(leveltwo);
            leveltwo.times = 90;
            leveltwo.alive = 3;
            leveltwo.score = levelone.score;
            leveltwo.requestFocusInWindow();
        }
        else if(e.getSource() == leveltwo.NextLevel){
            this.setLocationRelativeTo(null);
            this.remove(leveltwo);
            this.setSize(1200,700);
            this.setTitle("Slide Boss");
            this.add(levelthree);
            //levelthree.times = 120;
            levelthree.alive = 3;
            levelthree.score = leveltwo.score;
            levelthree.requestFocusInWindow();
        }
        this.validate();
        this.repaint();
    }
    
    public static void main(String[] args) {
        JFrame jf = new MyProject();
        jf.setSize(1200, 700);
        jf.setTitle("Mage Game");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
    }  
}
