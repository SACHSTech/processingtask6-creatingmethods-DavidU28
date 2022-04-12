/**
 * A program that let's you enter the lenght, position, and colour of the fish and will output your specifications to the screen
 * It also takes the weight of the fish and hours of sunlight the seaweed have recieves to determine there size
 * @author D. Ursu
 */

import processing.core.PApplet;

public class Sketch extends PApplet {
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0, 100, 255);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // Calls method for fish
    drawFish(400, 400, 100, 255, 0, 0);
    drawFish(150, 200, 150, 0, 255, 0);
    drawFish(300, 100, 80, 255, 0, 0);
    drawFish(250, 650, 150, 255, 255, 0);
    drawFish(650, 500, 125, 255, 200, 0);
    drawFish(650, 250, 175, 200, 255, 0);

    // Enter the fishes weight in pounds
    double combinedFishweight = 40;

    // hours of sunlight the seaweed recieves in a day
    double hoursOfsunlight = 14;

    // Size of seaweed depending on sunglight and size of fish (the heavier the fish, the larger it po0ps, therfore giving the seeweed more basctiera to eat of off)
    double size = seaWeedsize(combinedFishweight, hoursOfsunlight);
    strokeWeight((float) size);

    // Calls method for seaweed
    drawSeaweed(30, 800);
    drawSeaweed(100, 780);
    drawSeaweed(250, 760);
    drawSeaweed(370, 780);
    drawSeaweed(425, 830);
    drawSeaweed(530, 760);
    drawSeaweed(617, 830);
    drawSeaweed(715, 780);
    drawSeaweed(760, 760);
    
  }
  
  /**
   * 
   * Draws components of the fish based off inputed values of position, size, and colour
   * @param1 position of X coordnate 
   * @param2 position of Y coordinate
   * @param3 size of fish
   * @param4 amount of red in the body colour of the fish
   * @param5 amount of green in the body colour of the fish
   * @param6 amount of blue in the body colour of the fish
   */
  public void drawFish(int positionX, int positionY, int bodyLenght, int r, int g, int b){

    // body colour of fish
    noStroke();
    fill(r, g, b);
  
    int bodyLength = bodyLenght;
    int bodyHeight = bodyLength / 2;

    // body
    ellipse(positionX, positionY, bodyLength, bodyHeight);

    // tail
    double tailWidth = bodyLength / 4;
    double tailHeight = bodyHeight / 2;
    triangle((float)positionX - bodyLength / 2, (float) (positionY), (float) (positionX - bodyLength / 2 - tailWidth), (float) (positionY - tailHeight), (float) (positionX - bodyLength / 2 - tailWidth), (float) (positionY + tailHeight));

    // eye
    fill(33, 33, 33);
    ellipse(positionX + bodyLength / 4, positionY, bodyHeight / 5, bodyHeight / 5);
    
  }
  
  /**
   * Draws position of seaweed
   * @param weedX X position of seaweed
   * @param weedY y  position of seaweed
   */
  public void drawSeaweed(int weedX, int weedY){
    stroke(0, 100, 15, 230);
    noFill();
    bezier(weedX, weedY, weedX+60, weedY+-125, weedX+-50, weedY+-50, weedX+5, weedY+-175);

  }
    
  /**
   * Determines how much the seaweed grows based upon values of sunlight and fish weight
   * @param dbl1 weight of fish
   * @param dbl2 hours of sun light seaweed recieves
   * @return size of seaweed based of product of sunglight and weight of fish
   */
  public double seaWeedsize(double dbl1, double dbl2){
    return (dbl1 + 100) * (dbl2 / 100);

  }

}