import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MediumAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MediumAsteroid extends through
{
    public int x;
    /**
     * Act - do whatever the MediumAsteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        x=Greenfoot.getRandomNumber(6)-5;
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
