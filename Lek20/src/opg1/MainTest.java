package opg1;

public class MainTest {
    public void main(){
        Person p1 = new Person("Mads", "123456-7890", "12345678");
        Person p2 = new Person("Lise", "098765-4321", "87654321");

        Dog d1 = new Dog(1, "Fido");
        Dog d2 = new Dog(2, "Rex");
        Dog d3 = new Dog(3, "Buster");

        p1.addDog(d1);
        p1.addDog(d2);
        p2.addDog(d3);

        IO.println(p1.getDogs());
        p1.removeDog(d1);
        IO.println(p1.getDogs());
    }
}
