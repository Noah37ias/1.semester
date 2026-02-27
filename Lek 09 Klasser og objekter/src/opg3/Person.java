package opg3;

public class Person {
    private String name;
    private String address;
    private double monthlySalary;

    public Person(String name, String address, double monthlySalary) {
        this.name = name;
        this.address = address;
        this.monthlySalary = monthlySalary;
    }

    public String toString() {
        return "Name is: " + this.name + " Address is: " + this.address + " Salary is: " + this.monthlySalary;
    }

    public double calculateYearlySalary() {
        double baseYearlySalary = (this.monthlySalary * 12);
        return baseYearlySalary * 1.025;
    }

    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Salary
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    //Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
