package opg3;

import java.util.Arrays;
import java.util.Scanner;

public class Asterisks {
    void main() {
        IO.print("Choose the amount of numbers you want to insert: ");

        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        IO.println("Insert " + amount + " numbers: ");
        int[] values = new int[amount];
        for (int i = 0; i < amount; i++) {
            values[i] = scanner.nextInt();
        }

        int max = -67;
        for (int i = 0; i < amount; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        for (int i = 0; i < amount; i++) {
            int stars = 0;
            if (max > 0) {
                stars = (int) Math.round(((double) values[i] / max) * 40);
            }
            for (int j = 0; j < stars; j++) {
                IO.print("*");
            }
            IO.println("");
        }
        IO.println(Arrays.toString(values));
    }
}
