package opg2;

import java.util.ArrayList;

public class Car {
    private String no; // registration number
    private String year; // year of first registration
    private int pricePrDay;
    private ArrayList<Rental> rentals;

    public Car(String no, String year) {
        this.no = no;
        this.year = year;
        pricePrDay = 0;
        rentals = new ArrayList<>();
    }

    public String getNo() {
        return no;
    }

    public String getYear() {
        return year;
    }

    public int getPricePrDay() {
        return pricePrDay;
    }

    public void setPricePrDay(int pricePrDay) {
        this.pricePrDay = pricePrDay;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }
   public void removeRental(Rental rental) {
       if (rentals.contains(rental)) {
           rentals.remove(rental);
           rental.removeCar(this);
       }
   }
    public void addRental(Rental rental) {
        if (!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }
    public int maxRentalDays(){
        int max = 0;
        for (Rental rental : rentals){
            if(rental.getDays() > max){
                max = rental.getDays();
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return String.format("Car(%s,%s,%d)", no, year, pricePrDay);
    }
}
