import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Nash Tamang)
 * course: CS20S
 * Teacher: MrHardman
 * Lab #5, program#1
 * @version (October 24, 2017)
 * 
 */
public class CreatureWorld extends World
{
    private String playerOneCreature; 
    private String playerTwoCreature;
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
    private Creature[] playerOneCreatures;
    private Creature[] playerTwoCreatures;
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneTurn = true;
        start = true;
        playerOneCreature = "Charmander";
        playerTwoCreature = "Pikachu";      
        playerTwoCreatures = new Creature[]{new Pikachu(this), new Lapras(this), new Pidgeot(this) };
        playerOneCreatures = new Creature[]{new Charmander(this), new Golem(this), new Ivysaur(this) };
        prepareCreatures();
        Greenfoot.start();

    }
    
    /*
     * for loop allows the code to be executed repeatedly 
     * 
     *@param there are no parameters 
     *@return there is nothing returned 
     */
    private void prepareCreatures()
    {
       for( int i = 0; i < playerOneCreatures.length; i++ )
       {
           if( i == 0 )
           {
               addObject( playerOneCreatures[i], playerOneCreatures[i].getImage().getWidth()/2, getHeight() - playerOneCreatures[i].getImage().getHeight()/2 );                                                                                                                                                                                                               
           }
           else
           {
               playerOneCreatures[i].getImage().setTransparency(0);
               addObject(playerOneCreatures[i], 0, getHeight() - playerOneCreatures[i].getImage().getHeight()/2);
           }
       }
       
       for( int j = 0; j < playerTwoCreatures.length; j++ )
       {
           if( j == 0 )
           {
               addObject( playerTwoCreatures[j], getWidth() - playerTwoCreatures[j].getImage().getWidth()/2, playerTwoCreatures[j].getImage().getHeight()/2 );
           }
           else
           {
               playerTwoCreatures[j].getImage().setTransparency(0);
               addObject(playerTwoCreatures[j], getWidth(), playerTwoCreatures[j].getImage().getHeight()/2);           
           }
       }
    }
    
    /*
     * if the current creature is charmander it will switch to Golem
     * 
     * @param there are no paramaeters
     * @return current playerOne
     */
    public Creature getPlayerOne()
    {
        Creature currentPlayerOne;
        if( playerOneCreature.equalsIgnoreCase("Charmander" )  )
        {
            currentPlayerOne = playerOneCreatures[0];
        }
        else if( playerOneCreature.equalsIgnoreCase("Golem" ) )
        {
            currentPlayerOne = playerOneCreatures[1];
        }
        else
        {
            currentPlayerOne = playerOneCreatures[2];
        }
        return currentPlayerOne;
    }
    
    /*
     * it creature that has not been switched yet will be with the current creature
     * 
     *@param there are no parameters 
     *@return currentplayertwo 
     */
    public Creature getPlayerTwo()
    {
        Creature currentPlayerTwo;
        if( playerTwoCreature.equalsIgnoreCase("Pikachu" ) )
        {
            currentPlayerTwo = playerTwoCreatures[0];
        }
        else if( playerTwoCreature.equalsIgnoreCase("Lapras" ) )
        {
            currentPlayerTwo = playerTwoCreatures[1];
        }
        else
        {
            currentPlayerTwo = playerTwoCreatures[2];
        }
        return currentPlayerTwo;
    }
    
    /*
     * defines if player one is a creature and if player one menus are added
     * 
     *@param there are parameters string creature 
     *@return there is nothing returned 
     */
    public void changePlayerOne( String creature )
    {
        playerOneCreature = creature;
        removeObject(oneFightMenu);
        removeObject(oneSwitchMenu);
        playerOneMenusAdded = false;
    }
    
    /*
     * defines if player two is a creature and checks if player two menus are added
     * 
     * @param there are parameters string creature
     * @return there is nothing returned
     */
    public void changePlayerTwo( String creature )
    {
        playerTwoCreature = creature; 
        removeObject(twoFightMenu);
        removeObject(twoSwitchMenu);
        playerTwoMenusAdded = false;
    }
    
    /*
     * checking if its getting a different creature
     * 
     * @param there are parameters int index
     * @return player one creatures
     */
    public Creature getNewOneCreature( int index )
    {
        return playerOneCreatures[index];
    }
    
    /*
     * checking if its getting a new creature in the index
     * 
     * @param there are parameters int index
     * @return
     */
    public Creature getNewTwoCreature( int index )
    {
       return playerTwoCreatures[index];
    }
    
    /*
     * checks whether or not its player ones turn
     * 
     *@param there are no parameters 
     *@return player ones turn
     */
    public boolean getTurnNumber()
    {
        return  playerOneTurn;
    }
    
    /*
     * it will set the number of the turns
     * 
     *@param there are parameters boolean turn 
     *@return there is nothing returned
     */
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
        boolean playerOneLose = true;
        boolean playerTwoLose = true;
        

        
        if( start == true )
        {
          playerOneName = JOptionPane.showInputDialog( "PlayerOne, please enter your name ", null );
          playerTwoName = JOptionPane.showInputDialog( "PlayerTwo, please enter your name ", null );
         
          //All menu adding code should not be here
          
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
            //Should be adding menus here
            if( playerOneCreature.equalsIgnoreCase("Charmander") )
            {
                oneFightMenu = new Menu(" Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                oneSwitchMenu = new Menu(" Switch ", " Golem \n Ivysaur ",24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            else if( playerOneCreature.equalsIgnoreCase("Golem") )
            {
                oneFightMenu = new Menu(" Fight ", " Tackle \n Earthquake ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            else
            {
                oneFightMenu = new Menu(" Fight ", " Scratch \n Razorleaf ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Golem ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            addObject( oneFightMenu, 177, getHeight() - 100 );
            addObject( oneSwitchMenu, 241, getHeight() - 100 );
            playerOneMenusAdded = true;
        }
      
        if( playerTwoMenusAdded == false )
        {
            //Should be adding menus here
            if( playerTwoCreature.equalsIgnoreCase("Pikachu") )
            {
                twoFightMenu = new Menu(" Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() ); 
                twoSwitchMenu = new Menu(" Switch ", " Lapras \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            else if( playerTwoCreature.equalsIgnoreCase("Lapras") )
            {
                twoFightMenu = new Menu(" Fight ", " Tackle \n Hydropump ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() ); 
                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            else
            {
                twoFightMenu = new Menu(" Fight ", " Tackle \n Wing Attack ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() ); 
                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Lapras ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            }
            addObject( twoFightMenu, 135, 75 );
            addObject( twoSwitchMenu, 199, 75 );
            playerTwoMenusAdded = true;
        }
      
        for( int i = 0; playerOneLose == true && i < playerOneCreatures.length; i++ )
        {
            playerOneLose = false;
        }
        
         for( int j = 0; playerTwoLose == true && j < playerOneCreatures.length; j++ )
        {
            playerTwoLose = false;
        }
        
        
        if ( playerTwoLose == true )
        {
          removeObjects(allObjects);
          showText("Player One Wins",getWidth()/2, getHeight()/2 + 26);
          Greenfoot.stop();
         
        }
      
        if( playerOneLose == true )
        {
          removeObjects(allObjects);
          playerOneLose = true;
          showText("Player Two Wins",getWidth()/2,getHeight()/2 + 26);
          Greenfoot.stop();
        }
    }
}