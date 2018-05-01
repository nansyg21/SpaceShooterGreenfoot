import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class AnswerBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnswerBox extends through
{
    String numberText;
    boolean isCorrect;
    int velocity = 1;
    
    public AnswerBox(String myNumberText, boolean isCorrect){
        
        GreenfootImage backImage = new GreenfootImage(this.getImage());
        this.numberText=myNumberText;
        this.isCorrect = isCorrect;
        GreenfootImage text = new GreenfootImage(numberText, 24, Color.BLACK, Color.ORANGE);
        backImage.drawImage(text,45 - numberText.length()/2, 42);
        setImage(backImage);
        
        this.getImage().scale(90,90);
    }
    
    /**
     * Act - do whatever the AnswerBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - velocity, getY());
        
        if((this.isCorrect)&&(this.getX()<2)){        
            getWorld().removeObjects(getWorld().getObjects(AnswerBox.class));
        } else {
            Actor bullet = getOneIntersectingObject(Bullet.class);
            if(bullet != null)
            {
                getWorld().removeObject(bullet);
                if(this.isCorrect){
                    ((Score)getWorld().getObjects(Score.class).get(0)).addToScore(10);
                    getWorld().removeObjects(getWorld().getObjects(AnswerBox.class));
                    Greenfoot.playSound("hit.wav");
                }            
                else
                    getWorld().removeObject(this);           
                
            }
        }
        
        return;
    }
    
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
}
