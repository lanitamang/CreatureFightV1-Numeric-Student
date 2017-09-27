import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Nash Tamang)
 * course: CS20S
 * Teacher: MrHardman
 * Lab #1, program#1
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature; 
    private Creature playerTwoCreature;
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1);
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this);
        
        prepareCreatures();
        Greenfoot.start();
    }
    private void prepareCreatures()
    {
      addObject( playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
      addObject( new Button(Color.RED,50),500, 700);
      
      addObject( playerTwoCreature, playerTwoCreature.getImage().getWidth() + 510, getHeight() - playerTwoCreature.getImage().getHeight() + -570 );
      addObject( new Button(Color.RED, 50),280,70);
    }
   
    public Creature getPlayerOne()
    {
      return playerOneCreature;  
    }
    
     public Creature getPlayerTwo()
    {
      return playerTwoCreature;  
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
      List allObjects=getObjects(null);
      if ( playerTwoCreature. getHealthBar().getCurrent() <=0 )
      {
         removeObjects(allObjects);
         showText("Player Two Wins",getWidth()/2, getHeight()/2 + 26);
         Greenfoot.stop();
      }
      
      if( playerOneCreature. getHealthBar().getCurrent() <=0 )
      {
        removeObjects(allObjects);
        showText("Player One Wins",getWidth()/2,getHeight()/2 + 26);
        Greenfoot.stop();
      } 
    }
}
