package opg2;

import java.util.ArrayList;

public class Rental {
    private int no;
    private String date;
    private int days; // days of rental
    private ArrayList<Car> cars;

     public Rental(int no, String date, int days) {
        this.no = no;
        this.date = date;
        this.days = days;
        this.cars = new ArrayList<>();
    }

    public int getNo() {
        return no;
    }

    public String getDate() {
        return date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    public ArrayList<Car> getCars() {
         return cars;
    }
    public void addCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
            car.addRental(this);
        }
    }
    public void removeCar(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
            car.removeRental(this);
        }
    }
    public double getTotalPrice(){
         double total = 0;
         for (Car car : cars){
             total = (car.getPricePrDay() * getDays()) + total;
         }
         return total;
    }

    @Override
    public String toString() {
        return "Rental(" + no + "," + date + "," + days + ")";
    }
}
