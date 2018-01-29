import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private GreenfootImage img;
    private boolean border = false;
    private String text;
    private int fontSize;
    private Color foreground;
    private Color background;
    
    public TextBox( String message, int fs, boolean hasBorder, Color fg, Color bg )
    {
      fontSize = fs;
      border = hasBorder;
      foreground = fg;
      background = bg;
      text = message;
      
      img = new GreenfootImage( message, fontSize, foreground, background );
      
      display();
    }
    
    /*
     * it will show the color of the image
     * 
     * @param there are no parameters
     * @return there is nothing returned
     */
    private void display()
    {
      if( border == true )
      {
         img.setColor( Color.BLACK );
         img.drawRect( 0, 0, img.getWidth() - 1, img.getHeight() - 1 );
      }
      
       setImage( img );
    }
    
    /*
     * returning the text for the string
     * 
     * @param there are no parameters
     * @return returning text
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * it will set the text, fontsize, foreground and background in an image
     *
     *@param there are parameters
     *@return there is nothing to be returned
     */
    public void setText( String message )
    {
        text = message;
        img = new GreenfootImage( text, fontSize, foreground, background );
        display();
    }
    
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
