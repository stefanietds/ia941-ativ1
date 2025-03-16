/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS3DApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import ws3dproxy.CommandExecException;
import ws3dproxy.model.Creature;
import ws3dproxy.model.Leaflet;
import ws3dproxy.model.Thing;
import ws3dproxy.model.World;

/**
 *
 * @author stefanie
 */
public class MoveCreature extends JFrame implements KeyListener  {
    
    private static World world;
    private static Creature creature;
    public Movement movement;
    List<String> Things = new ArrayList<>();
   
    
    @Override
    public void keyReleased(KeyEvent e){
        try{
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> {
                    movement.moveRight();
                    System.out.println("Movendo para a direita");
                    creature.rotate(1);
                }
                case KeyEvent.VK_LEFT -> {
                    creature.rotate(-1);
                    movement.moveLeft();
                }
                case KeyEvent.VK_DOWN -> {
                    creature.move(-1.0, -1.0, 1.0);
                    movement.moveDown();
                }
                case KeyEvent.VK_UP -> {
                    movement.moveUp();
                    creature.move(1.0, 1.0, 1.0);
                }
                case KeyEvent.VK_C ->                     {
                        List<Thing> thingsList = creature.getThingsInVision();
//                        String name = creature.getName();
//                        String nameThings = creature.getThingsNames();
                        for (Thing t : thingsList) {
                            System.out.println(t.getName());
                            System.out.println(t.getCategory());
                            
                            double distance = creature.calculateDistanceTo(t);
                            
                            if(distance < 50){
                                creature.eatIt(t.getName());
                            }
                        }                          }
                case KeyEvent.VK_S ->                    
                      {
                        List<Thing> thingsList = creature.getThingsInVision();
                        for (Thing t : thingsList) {
                            double distance = creature.calculateDistanceTo(t);
                            if (distance <= 50) {
                                creature.putInSack(t.getName());
                                System.out.println("Inserindo: " + t.getName());
                            }
                        }                          
                      }
                case KeyEvent.VK_H ->                   
                {
                        List<Thing> thingsList = creature.getThingsInVision();
                        for (Thing t : thingsList) {
                            double distance = creature.calculateDistanceTo(t);
                            if (distance <= 10) {
                                creature.hideIt(t.getName());
                                
                                Things.add(t.getName());
                                System.out.println("Esta escondido: " + t.getName());
                            }
                        }                          
                }
                case KeyEvent.VK_U -> {
                    if (Things != null) {
                        for (String t : Things) {
                            creature.unhideIt(t);
                        }
                    }
                }
                case KeyEvent.VK_L -> {
                    List<Leaflet> leaflets = creature.getLeaflets();
                    for (Leaflet item : leaflets) {
                        System.out.println("Leaflets: " + item.getID());
                        creature.genLeaflet();
                        creature.deliverLeaflet(item.getID().toString());
                    }
                }
                case KeyEvent.VK_B -> {
                   creature.updateBag();
                }
            }
        } catch(CommandExecException ex){
            System.out.println("Erro");
        }       
    }

    @Override
    public void keyTyped(KeyEvent e) {
       //System.out.println("keyTyped - pressionado");
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
       //System.out.println("keyPressed");
    }
    
    
    public MoveCreature() {
        this.movement = new Movement();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
}
