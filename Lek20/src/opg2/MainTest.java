package opg2;

public class MainTest {
    void main(){
        Car c1 = new Car("AB12345", "2020");
        c1.setPricePrDay(500);

        Car c2 = new Car("XY98765", "2023");
        c2.setPricePrDay(800);

        Rental r1 = new Rental(1, "01-05-2026", 5);
        Rental r2 = new Rental(2, "10-06-2026", 14);

        // Dobbeltrettet sammenhæng
        r1.addCar(c1);
        r1.addCar(c2);
        c1.addRental(r2);
        c2.addRental(r1);

        // Test af metoderne
        IO.println("Samlet pris for udlejning r1: " + r1.getTotalPrice());
        IO.println("Max lejedage for bil c1: " + c1.maxRentalDays());
        IO.println("Biler tilknyttet r1: " + r1.getCars());
    }
}
