/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS3DApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author stefanie
 */
public class Movement extends JComponent {
    private int x = 50;
    private int y = 50;
    private Graphics g;
    
    @Override
    public void paintComponent(Graphics g){
//        this.g = g;
        super.paintComponent(g);
        
        g.drawRect(x, y, 50, 50);
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.BLUE);
        
       OnTime();
    }
    
    public void moveRight() {
        x = x + 5;
        
        repaint();
        
    }

    public void moveLeft() {
        x = x - 5;
        
        repaint();
    }

    public void moveDown() {
        y = y + 5;
        
        repaint();
    }

    public void moveUp() {
        y = y - 5;        
        repaint();
    }
    
        public void OnTime() {
        ActionListener actListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                x = 50;
                y = 50;
            }
        };
        Timer timer = new Timer(7000, actListner);
        timer.start();
    }
    
}
