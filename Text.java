import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.font.FontRenderContext;
import java.awt.Graphics2D;

/**
 * This class provides objects that just show a bit of text on the screen.
 */
public class Text extends Actor
{
    private int myFontSize;
    
    public Text(int length, int myFontSize)
    {
        //The * factor and the second argument has to be tha same as the font size
        setImage(new GreenfootImage(length * myFontSize, myFontSize));
    }

    public Text(String text, int myFontSize)
    {
        this (text.length(),myFontSize);
        myFontSize = myFontSize;
        setText(text);
    }
    //If we only give text then set 16 as default size
    public Text(String text)
    {
        this (text.length(),24);
        myFontSize = 24;
        setText(text);
    }

    public void setText(String text)
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(Color.RED);
        Font f = new Font(true, false, myFontSize);
        image.setFont(f);
        //The second argument has to be the same as the font size
        image.drawString(text, 2, myFontSize);
        

        // calculate width of text in pixels
//         FontRenderContext frc = ((Graphics2D)getImage().getAwtImage().getGraphics()).getFontRenderContext();
//         int textWidth = (int)image.getFont().getStringBounds(text, frc).getWidth();        
    }
    
    /**
     * Adapt location to make placement left-justified.
     */
    public void setLocation(int x, int y)
    {
        super.setLocation(x + getImage().getWidth() / 2, y);
    }
    
}
