package opg2;

import java.util.Scanner;

public class NumberReaderD {
    void main() {
        IO.println("Amount of numbers: ");
        int amount = Integer.parseInt(IO.readln());
        IO.println("Insert " + amount + " numbers between 1 and 99: ");
        Scanner input = new Scanner(System.in);
        int lastNumber = -67;
        int count = 0;
        for (int i = 0; i < amount; i++) {
            int number = input.nextInt();

            if (number == lastNumber) {
                count++;
            } else {
                if (count > 1) {
                    IO.println(lastNumber + "(" + count + ")");
                }
                lastNumber = number;
                count = 1;
            }

        }
        if (count > 1) {
            IO.println(lastNumber + "(" + count + ")");
        }

    }
}

