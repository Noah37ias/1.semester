package opg3;

public class test {
    void main(){
        Person modtager = new Person("Mads", 67);
        Person giver1 = new Person("Lise", 69);
        Person giver2 = new Person("Jens", 67);

        Gift g1 = new Gift("Bog", 167, giver1);
        Gift g2 = new Gift("Chokolade", 50, giver1);
        Gift g3 = new Gift("Vin", 420, giver2);

        modtager.addGift(g1);
        modtager.addGift(g2);
        modtager.addGift(g3);

        IO.println(modtager.getName() + " har modtaget følgende gaver:");
        for (Gift gift : modtager.getReceivedGifts()) {
            IO.println("- " + gift.getDescription() + " (" + gift.getPrice() + " kr.) givet af " + gift.getGiver().getName());
        }

        IO.println("Samlet værdi af gaver: " + modtager.totalPrice() + " kr.");
        for (Person giver : modtager.getGivers()) {
            IO.println(giver.getName());
        }
    }
}
