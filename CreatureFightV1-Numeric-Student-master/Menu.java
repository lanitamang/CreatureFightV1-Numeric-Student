import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    private TextBox titleBar;
    private TextBox menuItems;
    private MenuCommands commands;
    private int fontSize = 24;
    private boolean visible = false;
    private Color mainFG;
    private Color mainBG;
    private Color secondFG;
    private Color secondBG;
    private int titleHeight;
    private int menuHeight;

    public Menu( String tb, String i, int fs, Color mfg, Color mbg, Color sfg, Color sbg, MenuCommands mc )
    {
        mainFG = mfg;
        mainBG = mbg;
        secondFG = sfg;
        secondBG = sbg;

        titleBar = new TextBox( tb, fs, true, mainFG, mainBG );
        menuItems = new TextBox( i, fs, true, secondFG, secondBG );

        commands = mc;
        fontSize = fs;
    }

    public Menu()
    {
        this( "not intialized", "none", 24, Color.BLACK, Color.LIGHT_GRAY, Color.BLACK, Color.WHITE, null );
    }

    protected void addedToWorld( World w )
    {
        w.addObject( titleBar, getX(), getY() );
        titleHeight = titleBar.getImage().getHeight();
        menuHeight = menuItems.getImage().getHeight();
    }

    /**
     * if the mouse is clicked or pressed the actor it was clicked on will be returned
     * 
     * @param there are no parameters
     * @return there is nothing returned
     */
    public void act() 
    {
        // Add your action code here.
        handleMouse();
    }

    private void handleMouse()
    {

        CreatureWorld world = ( CreatureWorld ) getWorld();
        int distance;
        if( world.getTurnNumber() == true )
        {
            if( titleBar.getText().equalsIgnoreCase( "Fight" ) )
            {
                distance = 35;
            }
            else
            {
                distance = 195;
            }
        }
        else
        {
            if( titleBar.getText().equalsIgnoreCase( "Fight" ) )
            {
                distance = 362;
            }
            else
            {
                distance = 195;
            }
        }
        
        System.out.println(getObjectsInRange(distance, Creature.class).get(0).getWhetherPlayerOne());
        
        if( getObjectsInRange(distance, Creature.class).get(0).getWhetherPlayerOne() == true && world.getTurnNumber() == true)
        {
            if( Greenfoot.mouseClicked( titleBar ) )
            {
                if( visible == false )
                {
                    getWorld().addObject( menuItems, getX(), getY() + ( titleHeight + menuHeight/2 ) );
                }
                else
                {
                    getWorld().removeObject( menuItems );
                }

                visible = !visible;
            }
            
            if( Greenfoot.mouseClicked( menuItems ) )
            {
                MouseInfo mi = Greenfoot.getMouseInfo();
                int menuIndex = ( ( mi.getY() - menuItems.getY() + menuHeight / 2 ) - 1 ) / fontSize;
                visible = !visible;
                getWorld().removeObject( menuItems );
                commands.execute( menuIndex, world.getPlayerOne() );
            }
        }
        else if(getObjectsInRange(distance, Creature.class).get(0).getWhetherPlayerOne() == false && world.getTurnNumber() == false)
        {
            if( Greenfoot.mouseClicked( titleBar ) )
            {
                if( visible == false )
                {
                    getWorld().addObject( menuItems, getX(), getY() + ( titleHeight + menuHeight/2 ) );
                }
                else
                {
                    getWorld().removeObject( menuItems );
                }
                
                visible = !visible;
            }
           
            if( Greenfoot.mouseClicked( menuItems ) )
            {
                MouseInfo mi = Greenfoot.getMouseInfo();
                int menuIndex = ( ( mi.getY() - menuItems.getY() + menuHeight / 2 ) - 1 ) / fontSize;
                visible = !visible;
                getWorld().removeObject( menuItems );
                commands.execute( menuIndex, world.getPlayerTwo() );
            }
        }
    }
}

