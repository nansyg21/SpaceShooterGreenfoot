import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends through
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + speed, getY()); 
        if(getX()>790)
        {
            getWorld().removeObject(this);
            return;
        }
    }    
    public int speed = 10;
}
