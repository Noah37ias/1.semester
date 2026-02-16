package opg2;

import java.util.Scanner;

public class NumberReaderA {
    void main() {
        int amount = Integer.parseInt(IO.readln());
        Scanner input = new Scanner(System.in);
        IO.println("Insert " + amount + " numbers between 1 and 99: ");

        int max = -67;
        int min = 6767;
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < amount; i++) {
            int number = input.nextInt();

            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            if (number % 2 == 0) {
                evenCount++;
            }
            if (number % 2 != 0) {
                oddCount++;
            }

        }
        IO.println("Amount of odd numbers found: " + oddCount);
        IO.println("Amount of even numbers found: " + evenCount);
        IO.println("The biggest number found: " + max);
        IO.println("The smallest number found: " + min);

    }
}
