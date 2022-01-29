package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnterGame extends JPanel{
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("wallpaper.jpg"));
    private ImageIcon imageunder = new ImageIcon(this.getClass().getResource("Intro/underintroplay.png"));
    private ImageIcon imagelogo = new ImageIcon(this.getClass().getResource("Intro/logointroplay.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("Intro/playbutton.png"));
    public JButton StartGame = new JButton(starts);
    
    EnterGame(){
        setLayout(null);
        StartGame.setBounds(430, 400, 300, 100);
        StartGame.setBorderPainted(false);
        StartGame.setBorder(null);
        StartGame.setOpaque(false);
        StartGame.setContentAreaFilled(false);
        add(StartGame);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(imageunder.getImage(), 0, -30, 1200, 710, this);
        g.drawImage(imagelogo.getImage(), 0, 0, 1200, 665, this);
    }
}
