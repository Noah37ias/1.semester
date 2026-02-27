package opg3;

public class PersonApp {
    void main() {


        Person p1 = new Person("Noah", "Åbyvej 77d 3.th", 30000);
        IO.println(p1);
        IO.println(p1.calculateYearlySalary());
    }
}
