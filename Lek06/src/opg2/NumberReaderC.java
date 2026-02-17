package opg2;

import java.util.Scanner;

public class NumberReaderC {
    void main() {
        IO.print("Amount of numbers: ");
        int amount = Integer.parseInt(IO.readln());
        IO.print("Insert " + amount + " numbers between 1 and 99: ");
        Scanner input = new Scanner(System.in);
        int max = 0;
        int count = 1;

        for (int i = 0; i < amount; i++) {
            int number = input.nextInt();
            if (number == max) {
                count++;
            }
            if (number > max) {
                max = number;
            }
        }
        IO.println("The highest number was: " + max);
        IO.println(max + " was in the line " + count + " times");


    }
}
