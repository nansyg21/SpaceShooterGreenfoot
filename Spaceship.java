import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A simple SpaceShip that can move up and down.
 * 
 * @author Poul Henriksen
 */
public class Spaceship extends through
{
    public void act() 
    {
        if (Greenfoot.isKeyDown("up") ) {
            setLocation (getX(), getY() - 3);
        }
        if (Greenfoot.isKeyDown("down") ) {
            setLocation (getX(), getY() + 3);
        }
        shoot();
        gameOver();
    }    
    private int bulletTimer = 0;
    public void shoot()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            if (bulletTimer > 0) {
                bulletTimer = bulletTimer - 1;
            }
            else if (Greenfoot.isKeyDown("space")) {
                getWorld().addObject(new Bullet(), getX()+60, getY());
                Greenfoot.playSound("bullet.wav");
                bulletTimer = 25;
            }
        }
    }
    
    public void lostLife(int lives){         
            getWorld().removeObject(getWorld().getObjects (Life.class).get(lives));         
    }

    public void gameOver()
    {
        if((canSee(SmallAsteroid.class))||(canSee(MediumAsteroid.class))||(canSee(LargeAsteroid.class)))
        {
            int lives = getWorld().getObjects (Life.class).size();
            lives --;
            if(lives>=0){
                getWorld().removeObjects(this.getIntersectingObjects(SmallAsteroid.class));
                getWorld().removeObjects(this.getIntersectingObjects(MediumAsteroid.class));
                getWorld().removeObjects(this.getIntersectingObjects(LargeAsteroid.class));
                
                lostLife(lives);
            } else {
                getWorld().removeObject(this);
                return;
            }           
            
        }
        /*if(canSee(MediumAsteroid.class))
        {
            getWorld().removeObject(this);
            return;
        }
        if(canSee(LargeAsteroid.class))
        {
            getWorld().removeObject(this);
            return;
        }*/
    }
}