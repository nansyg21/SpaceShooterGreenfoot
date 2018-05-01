import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class through here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class through extends Actor
{
    /**
     * Act - do whatever the through wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }   

    public boolean atWorldEdge()
    {
        if(getX() < -50)
            return true;
        else
            return false;
    }

    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    public void destroy(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
}
