package opg4;

public class RectangleApp {
    void main() {
        Rectangle r1 = new Rectangle(4, 40);
        IO.println(r1);
        IO.println("The Area is: " + r1.getArea());
        IO.println("The Perimeter is: " + r1.getPerimeter());

        Rectangle r2 = new Rectangle(3.5,35.9);
        IO.println(r2);
        IO.println("The Area is: " + r2.getArea());
        IO.println("The Perimeter is: " + r2.getPerimeter());

    }
}
