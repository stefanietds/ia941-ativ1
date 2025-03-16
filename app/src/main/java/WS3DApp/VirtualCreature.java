/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS3DApp;

import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.WorldPoint;

/**
 *
 * @author stefanie
 */
public class VirtualCreature {
    private static Creature creature;
    
    public static Creature CreateCreature(){
        WS3DProxy proxy = new WS3DProxy();
        try{
            creature = proxy.createCreature(100, 450, 10);
            creature.start();
            
            WorldPoint position = creature.getPosition();
            double pitch = creature.getPitch();
            double fuel = creature.getFuel();
            creature.genLeaflet();
            
        } catch (CommandExecException e){
            System.out.println("Erro");
        } 
        
        return creature;
    }
    
    public static Creature getInstance() {
       return creature;
    }
}
