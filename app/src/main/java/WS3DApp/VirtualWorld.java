/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS3DApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;

/**
 *
 * @author stefanie
 */
public class VirtualWorld {
    
    static void CreateWorld(){
        WS3DProxy proxy = new WS3DProxy();
        try {
            World w = World.getInstance();
            w.reset();
        }
        catch (CommandExecException e){
            System.out.println("Erro ao tentar criar um mundo");
        }
    }
    
//        static void OnTime(Creature creatureApp) {
//        ActionListener actListner = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent event) {
//
//                creatureApp.updateState();
//            }
//        };
//        Timer timer = new Timer(100, actListner);
//        timer.start();
//    }
}
