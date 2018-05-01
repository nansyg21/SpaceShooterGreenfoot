import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class smallAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallAsteroid extends through
{
    public int x;
    /**
     * Act - do whatever the smallAsteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        x=Greenfoot.getRandomNumber(8)-7;
        setLocation(getX() + x, getY());
        if(getX()<2)
        {
            getWorld().removeObject(this);
            return;
        }
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet != null)
        {
            getWorld().removeObject(bullet);
            getWorld().removeObject(this);
            Greenfoot.playSound("blast.wav");
            return;
        }
    }   
}
