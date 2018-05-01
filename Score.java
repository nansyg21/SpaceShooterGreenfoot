import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends through
{
    int myScore = 0;
    Text textToShowScore;
    public Score(Text textToShowScore){
     this.getImage().scale(30,30);
     this.textToShowScore = textToShowScore;
    }
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    public void addToScore(int scoreToAdd)
    {
        myScore = myScore + scoreToAdd;
        ((ScoreText)getWorld().getObjects(ScoreText.class).get(0)).setText(myScore+"");
    }
    
    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.WHITE);
        img.drawString(myScore+"", 4, 20); 
    }
    
    public int getScore(){
        return myScore;
    }
}
