package com.interviewcake.solutions;

public class Problem6 {
    public static String myFunction(String arg) {
        // write the body of your function here
        Rectangle r1 = new Rectangle(1,6,1,3);
        Rectangle r2 = new Rectangle(4,5,3,6);
        Rectangle r3 = RectangleOverlap.findOverlap(r1,r2);
        System.out.println("Rectangle overlap area " + r3.getLeftX() + 
        " : " + r3.getWidth() + " : " + r3.getBottomY() + " : " + r3.getHeight());
        return "running with " + arg;
    }
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        String testInput = "test input";
        System.out.println(myFunction(testInput));
    }
}

class RectangleOverlap{
    
    public static Rectangle findOverlap(Rectangle rect1, Rectangle rect2){
        RangeOverlap xOverlap = RangeOverlap.findOverlap(rect1.getLeftX(),
        rect1.getWidth(), rect2.getLeftX(), rect2.getWidth());
        
        
        RangeOverlap yOverlap = RangeOverlap.findOverlap(rect1.getBottomY(),
        rect1.getHeight(), rect2.getBottomY(), rect2.getHeight());
        
        if(xOverlap.getLength()==0 ||  yOverlap.getLength() ==0){
            return new Rectangle(0,0,0,0);
        }
        return new Rectangle(xOverlap.getStartPoint(),xOverlap.getLength(),
        yOverlap.getStartPoint(), yOverlap.getLength()
        );
        
    }
    
}

class RangeOverlap {
    private int startPoint;
    private int length;
    
    public RangeOverlap(int startPoint, int length){
        this.startPoint = startPoint;
        this.length = length;
    }
    
    public int getStartPoint(){
        return startPoint;
    }
    
    public void setStartPoint(int startPoint){
        this.startPoint = startPoint;
    }
    
    public int getLength(){
        return length;
    }
    
    public void setLength(int length){
        this.length = length;
    }

    public static RangeOverlap findOverlap(int startPoint1, int length1, int startPoint2, int length2){
        int highestStart = Math.max(startPoint1,startPoint2);
        int lowestEnd = Math.min(startPoint1 + length1 , startPoint2+length2);
        
        if(highestStart >= lowestEnd){
            return new RangeOverlap(0,0);
        }
        int length = lowestEnd-highestStart;
        return new RangeOverlap(highestStart,length);
    }
    
}



class Rectangle {
    private int leftX;
    private int bottomY;
    
    private int width;
    private int height;
    
    public Rectangle(int leftX, int width, int bottomY, int height){
        this.leftX = leftX;
        this.width = width;
        this.bottomY = bottomY;
        this.height = height;
    }
    
    public int getLeftX(){
        return leftX;
    }
    
    public void setLeftX(int leftX){
        this.leftX = leftX;
    }
    
    public int getBottomY(){
        return bottomY;
    }
    public void setBottomY(int bottomY){
        this.bottomY = bottomY;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
}