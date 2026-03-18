package opg5;

public class MyRectangle2D {
    private double x = 0;
    private double y = 0;
    private double width = 1;
    private double height = 1;

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public MyRectangle2D() {

    }
    public double area() {
        return width * height;
    }
    public double perimeter() {
        return 2 * (width + height);
    }
    public boolean contains(double x, double y) {
    this.x = x;
    this.y = y;
    return true;
    }

}
