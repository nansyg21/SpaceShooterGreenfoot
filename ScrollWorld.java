import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot) 

/**
 * A class that has a scrolling background image
 * 
 */

public class ScrollWorld extends World 
{ 
    private int lives = 3;
    private int myscore = 0;

    private static final GreenfootImage bgImage = new GreenfootImage("space1.gif");
    private static final int scrollSpeed = 4;

    private GreenfootImage scrollingImage;
    private int scrollPosition = 0;

    private Text calculationLabel;
    private FirstEquationNumber firstFactorLabel;
    private SecondEquationNumber secondFactorLabel;
    private OperatorEquation operatorLabel;
    private ScoreText scoreText;

    private AnswerBox ab1, ab2, ab3;

    private Life life1, life2, life3;

    private int[] answerBoxPositions = new int[3];

    private Score score;

    public ScrollWorld()
    {
        super(800, 400, 1);

        GreenfootImage background = new GreenfootImage(800, 400);
        scrollingImage = getScrollingImage(800, 400);
        background.drawImage(scrollingImage, 0, 0);
        setBackground(background);

        Equation eq = new Equation();

        firstFactorLabel = new FirstEquationNumber("0000");
        firstFactorLabel.setText(eq.getFirstNumber()+"");
        addObject(firstFactorLabel,300,30);

        secondFactorLabel = new SecondEquationNumber("0000");
        secondFactorLabel.setText(eq.getSecondNumber()+"");
        addObject(secondFactorLabel,500,30);

        operatorLabel = new OperatorEquation(eq.getOperator());
        addObject(operatorLabel,400,30);

        life1 = new Life();
        life2 = new Life();
        life3 = new Life();

        addObject(life1,20,380);
        addObject(life2,60,380);
        addObject(life3,100,380);

        score = new Score(scoreText);
        addObject(score,700,380);

        scoreText = new ScoreText("0000");
        scoreText.setText("0");
        addObject(scoreText,740,380);       

        ab1 = new AnswerBox(eq.getRandomResult1()+"", false);
        addObject(ab1,799,50);

        ab2 = new AnswerBox(eq.getRandomResult2()+"", false);
        addObject(ab2,799,200);

        ab3 = new AnswerBox(eq.getResult()+"", true);
        addObject(ab3,799,350);

        addObject(new Spaceship(), 100, 200);
        prepare();
    }

    public void createNewEquation(){
        Equation eq = new Equation();
        firstFactorLabel.setText(eq.getFirstNumber()+"");
        secondFactorLabel.setText(eq.getSecondNumber()+"");
        operatorLabel.setText(eq.getOperator());
        createAnswerBoxes(eq);
    }

    public void createAnswerBoxes(Equation eq){
        getAnswerBoxPositions();
        ab1 = new AnswerBox(eq.getRandomResult1()+"", false);
        addObject(ab1,799,answerBoxPositions[0]);

        ab2 = new AnswerBox(eq.getRandomResult2()+"", false);
        addObject(ab2,799,answerBoxPositions[1]);

        ab3 = new AnswerBox(eq.getResult()+"", true);
        addObject(ab3,799,answerBoxPositions[2]);
    }

    public void getAnswerBoxPositions(){

        int positionCase = Greenfoot.getRandomNumber(7);

        switch(positionCase){
            case 0:
            answerBoxPositions[0] = 50;
            answerBoxPositions[1] = 200;
            answerBoxPositions[2] = 350;
            return;
            case 1:
            answerBoxPositions[0] = 50;
            answerBoxPositions[1] = 350;
            answerBoxPositions[2] = 200;
            return;
            case 2:
            answerBoxPositions[0] = 200;
            answerBoxPositions[1] = 50;
            answerBoxPositions[2] = 350;
            return;
            case 3:
            answerBoxPositions[0] = 200;
            answerBoxPositions[1] = 350;
            answerBoxPositions[2] = 50;
            return;
            case 4:
            answerBoxPositions[0] = 350;
            answerBoxPositions[1] = 200;
            answerBoxPositions[2] = 50;
            return;
            default:
            answerBoxPositions[0] = 350;
            answerBoxPositions[1] = 50;
            answerBoxPositions[2] = 200;
            return;
        }    

    }

    public void act()
    {
        if(score.getScore()>1){
            ab1.setVelocity((score.getScore()/100)+1);
            ab2.setVelocity((score.getScore()/100)+1);
            ab3.setVelocity((score.getScore()/100)+1);
        }

        if(getObjects(Spaceship.class).size()==0){
            ScoreBoard myScoreBoard = new ScoreBoard(score.getScore());
            Greenfoot.playSound("cheers.wav");
            addObject (myScoreBoard, 350, getHeight()/2);
            Greenfoot.stop();
        } else {
            if(scrollSpeed > 0 && scrollPosition <= 0) {
                scrollPosition = getWidth();
            }
            if(scrollSpeed < 0 && scrollPosition >= getWidth()) {
                scrollPosition = 0;
            }
            scrollPosition -= scrollSpeed;
            paint(scrollPosition);
            randomAsteroid();

            if(getObjects(AnswerBox.class).size()==0){
                createNewEquation();
            }
        }
    }  

    public int y;
    public int deltaX;
    public int deltaY;
    public void randomAsteroid()
    {
        y=Greenfoot.getRandomNumber(400);
        if(Greenfoot.getRandomNumber(9999) < 50) 
        {
            SmallAsteroid smll = new SmallAsteroid();
            addObject(new SmallAsteroid(), 799, y);      
        }
        if(Greenfoot.getRandomNumber(9999) < 20) 
        {
            MediumAsteroid mdm = new MediumAsteroid();
            addObject(new MediumAsteroid(), 799, y);  
        }
        if(Greenfoot.getRandomNumber(9999) < 10) 
        {
            LargeAsteroid lrg = new LargeAsteroid();
            addObject(new LargeAsteroid(), 799, y);  
        }
    }

    /**
     * Paint scrolling image at given position and make sure the rest of
     * the background is also painted with the same image.
     */
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(scrollingImage, position, 0);
        bg.drawImage(scrollingImage, position - scrollingImage.getWidth(), 0);       

    }

    /**
     * Returns an image with the given dimensions.
     */
    private GreenfootImage getScrollingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x, y);
            }
        }
        return image;
    } 

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
