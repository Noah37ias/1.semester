package opg2;

public class Employee {
    // The name of the employee.
    private String name;
    // Whether the employee is a trainee or not.
    private boolean trainee;
    private int age;

    /** Create an employee. */
    public Employee(String name, boolean trainee) {
        this.name = name;
        this.trainee = trainee;
    }

    public Employee(String name, boolean trainee, int age) {
        this.name = name;
        this.trainee = trainee;
        this.age = age;
    }

    @Override
    public String toString() {
        return ("***********\n" +
                "Name: " + name + "\n" +
                "Trainee: " + trainee + "\n" +
                "Age: " + age + "\n" +
                "***********");
    }

    public String getName() {
        return this.name;
    }

    public boolean isTrainee() {
        return this.trainee;
    }

    public void setTrainee(boolean trainee) {
        this.trainee = trainee;
    }

    public void birthday() {
        this.age++;
    }
}
