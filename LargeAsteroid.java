import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LargeAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LargeAsteroid extends through
{
    public int x;
    /**
     * Act - do whatever the LargeAsteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        x=Greenfoot.getRandomNumber(3)-2;
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
