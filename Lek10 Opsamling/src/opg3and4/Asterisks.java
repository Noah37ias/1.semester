package opg3and4;

import java.util.Arrays;
import java.util.Scanner;

public class Asterisks {
    void main() {
        IO.print("Choose the amount of numbers you want to insert: ");

        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        IO.print("Insert " + amount + " numbers and captions: ");
        String[] captions = new String[amount];
        int[] values = new int[amount];
        for (int i = 0; i < amount; i++) {
            values[i] = scanner.nextInt();
            captions[i] = scanner.nextLine();
        }

        int max = -67;
        for (int i = 0; i < amount; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        for (int i = 0; i < amount; i++) {
            String captionFormat = String.format("%-12s", captions[i]);
            IO.print(captionFormat + ": ");

            int stars = 0;
            if (max > 0) {
                stars = (int) Math.round(((double) values[i] / max) * 40);
            }

            for (int j = 0; j < stars; j++) {
                IO.print("*");
            }
            IO.println("");
        }
    }
}
