import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Nash Tamang)
 * course: CS20S
 * Teacher: MrHardman
 * Lab #2, program#1
 * @version (October 24, 2017)
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature; 
    private Creature playerTwoCreature;
    private boolean playerOneTurn;
    private String playerOneName;
    private String playerTwoName;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    private boolean start;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
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
        playerOneTurn = true;
        start = true;
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this);
        
        prepareCreatures();
        Greenfoot.start();

    }
    
   
    
   
    
    private void prepareCreatures()
    {
      addObject( playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
      addObject( playerTwoCreature, playerTwoCreature.getImage().getWidth() + 510, getHeight() - playerTwoCreature.getImage().getHeight() + -570 );
    }
   
    public Creature getPlayerOne()
    {
      return playerOneCreature;  
    }
    
     public Creature getPlayerTwo()
    {
      return playerTwoCreature;  
    }
    
     public boolean getTurnNumber()
    {
       return  playerOneTurn;
    }
    
     public void setTurnNumber( boolean turn )
    {
       playerOneTurn =  turn;
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
      
      if( start == true )
      {
         playerOneName = JOptionPane.showInputDialog( "PlayerOne, please enter your name ", null );
         playerTwoName = JOptionPane.showInputDialog( "PlayerTwo, please enter your name ", null );
         oneFightMenu = new Menu( "Fight", "Scratch \nFlamethrower", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
         oneSwitchMenu = new Menu( "Switch", "Golem \nIvysaur", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
         addObject( oneFightMenu, 173, getHeight() - 100 );
         addObject( oneSwitchMenu, 241, getHeight() - 100 );
         twoFightMenu = new Menu( "Fight", "Tackle \nThunderbolt", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
         twoSwitchMenu = new Menu( "Switch", "Lapras \nPidgeot", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
         addObject( twoFightMenu, 131, 75 );
         addObject( twoSwitchMenu, 199, 75 );
         playerOneTurn = true;
         start = false;
      }
      else if( playerOneTurn == true )
      {
          showText( playerOneName +", your turn", getWidth()/2, getHeight()/2 );
          showText( " ", getWidth()/2, getHeight()/2 + 26 ); 
      }
      else
      {
          showText( playerTwoName + "your turn", getWidth()/2, getHeight()/2 );
          showText( " ", getWidth()/2, getHeight()/2 + 26 );
      }
      
      if( playerOneMenusAdded == false )
      {
        oneFightMenu = new Menu( "Fight", "Scratch \nFlamethrower", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
        oneSwitchMenu = new Menu( "Switch", "Golem \nIvysaur", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
      }
      
      if( playerTwoMenusAdded == false )
      {
          twoFightMenu = new Menu( "Fight", "Tackle \nThunderbolt", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
          twoSwitchMenu = new Menu( "Switch", "Lapras \nPidgeot", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
      }
      
       
      
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