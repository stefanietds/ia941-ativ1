/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS3DApp;

import java.util.Random;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.World;

/**
 *
 * @author stefanie
 */
public class VirtualBrick {
    static void CreateBrick() {
        try {
            Random r = new Random(); 

            int x = r.nextInt(100); 
            int y = r.nextInt(300); 

            int type = r.nextInt(5); 
           
            World.createBrick(type, x, y, x + 10, y + 10);

        } catch (CommandExecException ex) {
            System.out.println("Erro ao criar a parede");
        }
    }
    
}

