package opg2;

public class EmployeeApp {
    void main() {
        Employee e1 = new Employee("Hans Jensen", true, 18);
        e1.birthday();
        e1.birthday();
        e1.birthday();

        IO.println("Test: " + e1);
        IO.println();

        IO.println("Name: " + e1.getName());
        IO.println("Trainee? " + e1.isTrainee());
        IO.println();

        e1.setTrainee(false);
        IO.println("Trainee? " + e1.isTrainee());
        IO.println();

    }
}
