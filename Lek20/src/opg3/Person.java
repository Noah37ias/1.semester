package opg3;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> receivedGifts;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.receivedGifts = new ArrayList<Gift>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public ArrayList<Gift> getReceivedGifts() {
        return new ArrayList<>(receivedGifts);
    }

    public void addGift(Gift gift) {
        receivedGifts.add(gift);
    }

    public void removeGift(Gift gift) {
        receivedGifts.remove(gift);
    }

    public double totalPrice() {
        double total = 0;
        for (Gift gift : receivedGifts) {
            total += gift.getPrice();
        }
        return total;
    }
    public ArrayList<Person> getGivers() {

        ArrayList<Person> givers = new ArrayList<>();
        for (Gift gift : receivedGifts) {
            Person giver = gift.getGiver();

            if(!givers.contains(giver)) {
                givers.add(giver);
            }
        }
        return givers;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
