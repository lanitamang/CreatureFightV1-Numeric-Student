import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    private HealthBar creatureBar;
    private int healthNumber;
    private boolean playerOneCreature;
    private String type;
    
    /**
     * Default constructor for objects of the Creature class
     * 
     * @param There are no parameters
     * @return an object of the Creature class
     */
    public Creature()
    {
        //Indentation issues
        healthNumber = 500;
        healthNumber = 0;
        creatureBar = new HealthBar ( healthNumber, healthNumber, 10 );
        playerOneCreature = true;
    }

    /**
     * Constructor that allows customization of objects of the Creature class
     * 
     * @param health is the amount of health the Creature object will have
     * @param whichPlayer discusses whether the creature belongs to player 1 or player 2
     * @return an object of the Creature class
     */
    public Creature( int health, boolean isPlayerOne, String creatureType )
    {
        //Indentation issues
        healthNumber = health;
        //this should be playerOneCreature = isPlayerOne;
        playerOneCreature = isPlayerOne; 
        creatureBar = new HealthBar ( healthNumber, healthNumber, 10 );
        type = creatureType;
    }
    
    /*
     * getting the healthBar of the creature
     * 
     * @param there are no parameters
     * @return returning creatureBar
     */
    protected HealthBar getHealthBar()
    {
        return creatureBar;  
    }
   
    public boolean getWhetherPlayerOne()
    {
        //Indentation issues
        return playerOneCreature; 
    }
    
    /*
     * returns the class object identifying the type of field represented by the object
     * 
     *@param there are no paramaters 
     *@return the type of font 
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void attack( int idx )
    {
        //empty method that will get overriden in subclasses
    }
    
    public void switchCreature( int idx )
    {
        //empty method that will get overriden in subclasses
    }
    
    public void switchedIn()
    {
        //empty method that will get overriden in subclasses
    }

    /**
     * act will complete actions that the Creature object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        //empty method that will get overriden in subclasses
    }   

}
