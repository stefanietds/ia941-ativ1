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

public class VirtualJewel {

    // Método para criar joias
    static void CreateJewel() {
       
            try {
                
                Random r = new Random();
                
                int x = r.nextInt(200);
                int y = r.nextInt(300);
                int type = r.nextInt(5);
                
                
                World.createJewel(type, x, y);
                
            } catch (CommandExecException ex) {
                System.out.println("Erro ao criar a joia");
            }
    }
    
            static void CreateJewelByName(String name) {
            
            try{
            Random r = new Random();
            int x = r.nextInt(150);
            int y = r.nextInt(180);
            int itemSelecionado;
            if ("Red".equals(name)) {
                itemSelecionado = 0;
            } else if ("Green".equals(name)) {
                itemSelecionado = 1;
            }  else if ("Blue".equals(name)) {
                itemSelecionado = 2;
            }  else if ("Yellow".equals(name)) {
                itemSelecionado = 3;
            } else if ("Magenta".equals(name)) {
                itemSelecionado = 4;
            }
            else {
                itemSelecionado = 5;
            }
            World.createJewel(itemSelecionado, x, y);
            } 
            catch (CommandExecException ex) {
                System.out.println("Erro ao criar a joia");
            }
        }
    
    
//    static void OnTime(Creature creature) {
//        ActionListener actListner = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent event) {
//
//                creature.updateState();
//            }
//        };
//        Timer timer = new Timer(100, actListner);
//        timer.start();
//    }
}
