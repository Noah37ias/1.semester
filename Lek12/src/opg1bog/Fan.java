package opg1bog;

public class Fan {
    private final int slow = 1;
    private final int fast = 3;
    private final int medium = 2;
    private int speed = slow;
    private boolean isOn = false;
    private double radius = 5;
    private String color = "Blue";



    public Fan(){

    }
    public Fan(int speed, double radius, String color, boolean on){
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.isOn = on;
    }

    public String toString() {
        String[] speeds = {"","slow","medium","fast"};
        if(isOn){
            return "Fan is on - The speed is: " + speeds[speed] + " The color is: " + color;
        }
        else{
            return "Fan is off - The color is: " +  color + " The radius is: " + radius;
        }
    }

    public boolean isOn() {
        return isOn;
    }
    public void setOn(boolean on) {
        isOn = on;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
