/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS3DApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Bag;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Leaflet;
import ws3dproxy.model.Thing;

/**
 *
 * @author stefanie
 */
public class VirtualCreature {

    private static Creature creature;
    public static int bag = 0;
    public static int energy = 0;

    public static Creature CreateCreature() {
        WS3DProxy proxy = new WS3DProxy();
        try {
            Random r = new Random();

            int x = r.nextInt(180);
            int y = r.nextInt(180);
            int pitch = r.nextInt(50);

            creature = proxy.createCreature(x, y, pitch);
            creature.start();

        } catch (CommandExecException e) {
            System.out.println("Erro");
        }

        return creature;
    }

//    public static Creature NewCreature(){
//        WS3DProxy proxy = new WS3DProxy();
//        try{
//            
//              Random r = new Random();
//                
//                int x = r.nextInt(100);
//                int y = r.nextInt(180);
//                int pitch = r.nextInt(50);  
//                
//            creature = proxy.createCreature(x, y, pitch);
//            creature.start();
//            
//        } catch (CommandExecException e){
//            System.out.println("Erro");
//        } 
//        
//        return creature;
//    }
//    
    public static void MoveCreature(int x, int y) {
        try {
            creature.moveto(4, x, y);

        } catch (CommandExecException e) {
            System.out.println("Erro");
        }
    }

    public static List<Leaflet> GetLeaflet() {
        if (creature == null) {
            System.out.println("Erro: creature está nulo!");
            return new ArrayList<>();
        }
        return creature.getLeaflets();

    }

    public static void Up() {
        try {
            creature.move(1.0, 1.0, 1.0);
        } catch (CommandExecException ex) {
            System.out.println("Erro");
        }
    }

    public static void Down() {
        try {
            creature.move(-1.0, -1.0, 1.0);
        } catch (CommandExecException ex) {
            System.out.println("Erro");
        }
    }

    public static void Right() {
        try {

            creature.rotate(1);
        } catch (CommandExecException ex) {
            System.out.println("Erro");
        }
    }

    public static void Left() {
        try {
            creature.rotate(-1);
        } catch (CommandExecException ex) {
            System.out.println("Erro");
        }
    }

    public static Bag GetBag() {
        System.out.println(creature.getBag());
        return creature.getBag();
    }

    public static int CaptureAndPutInBag() {
        try {
            List<Thing> thingsList = creature.getThingsInVision();

            for (Thing t : thingsList) {
                System.out.println(t.getName());
                double distance = creature.calculateDistanceTo(t);

                if (distance <= 100) {
                    creature.putInSack(t.getName());

                    System.out.println("Saco: " + t.getName());
                    bag = bag + 1;
                }
            }

        } catch (CommandExecException e) {
            System.out.println("Erro");
        }
        return bag;
    }

    public static int Food() {
        try {
            List<Thing> thingsList = creature.getThingsInVision();

            for (Thing t : thingsList) {
                System.out.println(t.getName());
                double distance = creature.calculateDistanceTo(t);

                if (distance <= 10) {
                    creature.eatIt(t.getName()); //ela come o item
                    System.out.println("Comeu: " + t.getName());
                    energy = energy + 1;
                    System.out.println("Energia: " + energy);
                }
            }
        } catch (CommandExecException ex) {
            System.out.println("Erro");
        }
        return energy;
    }
    
    public static Creature getInstance() {
        return creature;
    }
    
}
