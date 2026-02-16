package opg2;

import java.util.Scanner;

public class NumberReaderD {
    void main() {
        IO.print("Amount of numbers: ");
        int amount = Integer.parseInt(IO.readln());
        IO.print("Insert " + amount + " numbers between 1 and 99: ");
        Scanner input = new Scanner(System.in);
        int lastNumber = -67;
        int count = 0;
        for (int i = 0; i < amount; i++) {
            int number = input.nextInt();

            if (number == lastNumber) { //Hvis vores number er det samme som sidste lastNumber
                count++;//Skal vi have count 1 op
            } else { //Ellers skal vi
                if (count > 1) {//Hvis count er større end en print nummer og antal gange
                    IO.println(lastNumber + "(" + count + ")");
                }
                lastNumber = number;//Gem forrige nummer
                count = 1;
            }

        }
        if (count > 1) {
            IO.println(lastNumber + "(" + count + ")");
        }

    }
}

