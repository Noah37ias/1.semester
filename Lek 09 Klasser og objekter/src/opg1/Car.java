package opg1;

public class Car {
    private String brand;
    private String color;
    private String regNo; // registration number
    private int km;

    public Car(String brand, String color, String regNo, int km) {
        this.brand = brand;
        this.color = color;
        this.regNo = regNo;
        this.km = km;
    }

    @Override
    public String toString() {
        return ("***********" +
                "* " + brand + color +
                "* " + regNo +
                "* " + km + " km" +
                "***********");
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getRegNo() {
        return regNo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
