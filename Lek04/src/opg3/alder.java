package opg3;

import java.util.Scanner;

public class alder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert age here: ");
        int age = input.nextInt();
        alder tjekAlder = new alder();
        String result = tjekAlder.institution(age);
        System.out.println(result);
        System.out.print("Type true if Girl, and false if boy: ");
        boolean isGirl = input.nextBoolean();
        alder tjekHold = new alder();
        String resultHold = tjekHold.team(isGirl, age);
        System.out.println(resultHold);
    }

    public String institution(int age) {
        if (age > 0 && age <= 2) {
            return "Nursey";
        } else if (age >= 3 && age <= 5) {
            return "Kindergarten";
        } else if (age == 0) {
            return "Home";
        } else if (age >= 6 && age <= 16) {
            return "School";
        } else return "Out of School";
    }

    public String team(boolean isGirl, int age) {
        if (isGirl == true) {
            if (age >= 8) {
                return "Springy girls";
            } else {
                return "Tumbling girls";
            }
        }
        if (isGirl == false) {
            if (age >= 8) return "Cool boys";
            else return "Young cubs";
        }
        return null;
    }
}
