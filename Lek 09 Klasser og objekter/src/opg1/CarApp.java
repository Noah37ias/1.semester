package opg1;

public class CarApp {
    void main() {
        Car myCar = new Car("VW UP", "White", "AB 12.345", 50000);
        Car myCar1 = new Car("Kia", "Red", "BG23088", 0);
        IO.println("OPG 1 " + myCar1);

        IO.println("OPG 2: Color of the car is: " + myCar1.getColor());
        myCar1.setKm(220000);
        IO.println("OPG 3: " + myCar1.getKm());

        IO.println(myCar1);
        IO.println(myCar);


        String brand = myCar.getBrand();
        IO.println("Brand: " + brand);
        IO.println("My car: " + myCar.getBrand() + ", " +
                myCar.getColor() + ", " + myCar.getRegNo()
        );

        myCar.setKm(65000);
        IO.println("Km nu: " + myCar.getKm());
    }
}
