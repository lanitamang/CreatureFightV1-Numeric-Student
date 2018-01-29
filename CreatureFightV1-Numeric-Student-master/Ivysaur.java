import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Charmander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ivysaur extends Creature
{
    //Indentation issues
    public Ivysaur ( World w )
    { 
        super(720,true, "Grass");
        getImage().scale(150, 100);
        w.addObject( getHealthBar(), 300, w.getHeight() - 50 );
         getHealthBar().getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = ( CreatureWorld ) getWorld();
        if ( getHealthBar().getCurrent() <=0 )
        {
            getWorld().showText("Ivysaur has fainted...",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
            Greenfoot.delay(30);

            if(playerWorld.getNewOneCreature(0).getHealthBar().getCurrent() > 0)
            {
                switchCreature(0);
                playerWorld.setTurnNumber(true);
                getWorld().showText("",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
                getWorld().removeObject(this);
            }
            else if(playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0)
            {
                switchCreature(1);
                playerWorld.setTurnNumber(true);
                getWorld().showText("",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
                getWorld().removeObject(this);
            }
        }
    }

    /*
     *checking if the health is taken away from the creatures healthBar 
     * 
     * @param there are parameters int idx
     * @return there is nothing returned
     */
    public void attack( int idx )
    {
        CreatureWorld world = ( CreatureWorld ) getWorld();
        Creature enemy = world.getPlayerTwo();
        String enemyType = enemy.getType();
        attackAnimation();
        if( idx == 0 )
        {
            enemy.getHealthBar().add(-30);
        }
        else
        {
            if( enemyType.equalsIgnoreCase("Electric") )
            {
                getWorld().showText("It's not very effective", getWorld().getWidth()/2, getWorld().getHeight()/2+26 );
                Greenfoot.delay(30);
                enemy.getHealthBar().add(-60/2);
            }
            else if( enemyType.equalsIgnoreCase("Flying") )
            {
                enemy.getHealthBar().add(-60/2);
                getWorld().showText("It's not very effective", getWorld().getWidth()/2, getWorld().getHeight()/2+26 );
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase("water") )
            {
                enemy.getHealthBar().add(-60*2);
                getWorld().showText("It's super effective", getWorld().getWidth()/2, getWorld().getHeight()/2+26 );
                Greenfoot.delay(30);
            }
            
            else
            {
                enemy.getHealthBar().add(-60);
            }
        }
        world.setTurnNumber(false);
    }
    
     /*
     * sets the location of where the attack is going to hit 
     * 
     * @param there are no parameters
     * @return there is nothing returned
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for( int i = 0; i <= 14; i ++ )
        {
            setLocation( getX() + 1, getY() - 2 );
            Greenfoot.delay(1);
        }
        setLocation( originalX, originalY );
    }
    
    /*
     * setting the location when you switch creatures
     * 
     * @param there are parameters int idx
     * @return there is nothing returned
     */
    public void switchCreature( int idx )
    {
        CreatureWorld world = ( CreatureWorld ) getWorld();
        Creature switchCreature;
        if( idx == 0 )
        {
            switchCreature = world.getNewOneCreature(0);
        }
        else
        {
            switchCreature = world.getNewOneCreature(1);
        }

        if( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
            JOptionPane.showMessageDialog(null,"This creature has fainted! please select a different creature");
        }
        else
        {
            while( getX() > 0 )
            {
                setLocation( getX() - 5, getY() );
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            
            if( idx == 0 )
            {
                world.changePlayerOne("Charmander");
            }
            else
            {
                world.changePlayerOne("Golem");
            }
            switchCreature.switchedIn();
            world.setTurnNumber(false);
        }
    }
    
     /*
     * switches the image of the creature
     * 
     * @param there are no parameters
     * @return there is nothing returned
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while( getX() < 75 )
        {
            setLocation( getX() + 5, getY() );
            Greenfoot.delay(2);
        }
    }
}
