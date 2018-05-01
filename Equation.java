import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Equation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equation extends Actor
{
    int firstNumber;
    int secondNumber;
    String operator;
    double result;
    double randomResult1;
    double randomResult2;
    
    public Equation(){
        firstNumber = getRandomNumber();
        secondNumber = getRandomNumber();
        operator = getRandomOperator();
        result = calculateResult();
        randomResult1 = getRandomResultOffset(result);
        randomResult2 = getRandomResultOffset(result);
        
    }
    
    /**
     * Act - do whatever the Equation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    private int getRandomNumber(){
        return Greenfoot.getRandomNumber(100)+1;
    }
    
    private double getRandomResultOffset(double result){
        int randomOffset = Greenfoot.getRandomNumber(10)+1;
        int randomOpp = Greenfoot.getRandomNumber(2);
        if(randomOpp<1)
            return (result + randomOffset);
        else
            return (result - randomOffset);
    }
    
    private String getRandomOperator(){
        int opRandom = Greenfoot.getRandomNumber(4);
        
        if(opRandom<1){
            return "+";
        } else if(opRandom<2){
            return "-";
        } else if(opRandom<3){
            return "*";
        } else {
            if(firstNumber > secondNumber)
                return "/";
            else
                return "+";
        }
    }
    
    private double calculateResult(){
        if(operator.equals("+")){
            return firstNumber + secondNumber;
        } else if(operator.equals("-")){
            return firstNumber - secondNumber;
        } else if(operator.equals("*")){
            return firstNumber * secondNumber;
        } else {
            return Math.round(((firstNumber / secondNumber)*100)/100);
        }
    }
    
    public int getFirstNumber(){
        return firstNumber;
    }
    
    public int getSecondNumber(){
        return secondNumber;
    }
    
    public String getOperator(){
        return operator;
    }
    
    public double getResult(){
        return result;
    }
    
    public double getRandomResult1(){
        return randomResult1;
    }
    
    public double getRandomResult2(){
        return randomResult2;
    }
}
