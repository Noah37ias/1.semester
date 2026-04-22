package opg1;

import java.util.ArrayList;

public class Person {
    private String name;
    private String cpr;
    private String phone;
    private ArrayList<Dog> dogs = new ArrayList<>();

    public Person(String name, String cpr, String phone) {
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    public String getCpr() {
        return cpr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public ArrayList<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void removeDog(Dog dog) {
        if (dogs.contains(dog)) {
            dogs.remove(dog);
            dog.setPerson(null);
        }
    }

    public void addDog(Dog dog) {
        if (!dogs.contains(dog)) {
            dogs.add(dog);
            dog.setPerson(this);
        }
    }


    @Override
    public String toString() {
        return "Person(" + name + ", " + cpr + ", " + phone + ")";
    }
}
