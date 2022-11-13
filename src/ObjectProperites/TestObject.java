package src.ObjectProperites;

import src.StartSimulation;
import src.Enviornment.*;


public class TestObject {
    private int leftX;
    private int rightX;
    private int topY;
    private int bottomY;
    private double yVelocity;
    private double xVelocity;
    private double mass;
    public TestObject(int leftX, int rightX, int topY, int bottomY, double mass) {
        this.leftX = leftX;
        this.rightX = rightX;
        this.topY = topY;
        this.bottomY = bottomY;
        this.mass = mass;
        yVelocity = 0;
    }
    
    public void setDimentions(int leftX, int rightX, int topY, int bottomY) {
        this.leftX = leftX;
        this.rightX = rightX;
        this.topY = topY;
        this.bottomY = bottomY;
    }
    
    public int getLeftX() {
        return leftX;
    }
    public int getRightX() {
        return rightX;
    }
    public int getTopY() {
        return topY;
    }
    public int getBottomY() {
        return bottomY;
    }
    
    public double getYVelocity() {
        return yVelocity;
    }
    
    public double getXVelocity() {
        return xVelocity;
    }
    
    public void addXVelocity(double velocity) {
        if(bottomY == StartSimulation.height) {
            if(xVelocity + velocity < 8 && xVelocity + velocity > -8)
            xVelocity += velocity;
            else
            xVelocity = velocity > 0 ? 8 : -8;
        }
        else{
            if(xVelocity + velocity < 8 && xVelocity + velocity > -8)
                xVelocity += velocity/4;
                else
                xVelocity = velocity > 0 ? 8 : -8;
        }
        updateX();
    }
    
    public void addYVelocity(double velocity) {
        yVelocity += velocity;
        updateY();
    }
    
    public void updateGlobalVelocity() {
        updateY();
        updateX();
    }
    
    public void updateX() {
        if(xVelocity != 0) {
            if(xVelocity > 0) {
                if(bottomY == StartSimulation.height)
                xVelocity -= (Environment.coefFriction*Environment.globalYVelocity)/(1000.0/Environment.timerDelay);
                rightX += Math.ceil(xVelocity*Environment.scale);
                leftX += Math.ceil(xVelocity*Environment.scale);
                if(xVelocity <= 0) {
                    xVelocity = 0;
                }
            }
            else {
                if(bottomY == StartSimulation.height)
                xVelocity +=  (Environment.coefFriction*Environment.globalYVelocity)/(1000/Environment.timerDelay);
                leftX += Math.ceil(xVelocity*Environment.scale);
                rightX += Math.ceil(xVelocity*Environment.scale);
                if(xVelocity >= 0) {
                    xVelocity = 0;
                }
            }
        }
    }
    
    public void updateY() {
        if(bottomY < StartSimulation.height)
        yVelocity -= (Environment.globalYVelocity)/(1000/Environment.timerDelay);
        if(bottomY > StartSimulation.height) {
            yVelocity = 0;
            topY = StartSimulation.height - (bottomY - topY);
            bottomY = StartSimulation.height;
        }
        if(!(bottomY >= StartSimulation.height)) {
            topY -= yVelocity*Environment.scale;
            bottomY -= yVelocity*Environment.scale;
            if(bottomY >= StartSimulation.height) {
                yVelocity = 0;
            }
        }
        else if(yVelocity > 0) {
            topY -= yVelocity*Environment.scale;
            bottomY -= yVelocity*Environment.scale;
        }
        
    }
}


