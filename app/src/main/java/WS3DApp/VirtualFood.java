/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS3DApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.World;
import ws3dproxy.model.Creature;

/**
 *
 * @author stefanie
 */

public class VirtualFood {

    static void CreateFood() {
      
            try {
                Random r = new Random();
                
                int x = r.nextInt(150);
                int y = r.nextInt(180);
                int type = r.nextInt(2);
                
                World.createFood(type, x, y);
                
            } catch (CommandExecException ex) {
                System.out.println("Erro ao criar a joia");
            }
    }
    
        static void OnTime(Creature creature) {
        ActionListener actListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                creature.updateState();
            }
        };
        Timer timer = new Timer(100, actListner);
        timer.start();
    }
}
