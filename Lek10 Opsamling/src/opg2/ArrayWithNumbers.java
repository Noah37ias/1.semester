package opg2;

import java.awt.image.ImagingOpException;
import java.util.Arrays;
import java.util.Random;

public class ArrayWithNumbers {
    void main() {
        int[] result = new int[10];
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int remaining = 10;
        Random random = new Random();

        for (int i = 0; i < source.length; i++) {
            int randomIndex = random.nextInt(remaining);

            result[i] = source[randomIndex];

            for (int j = randomIndex; j < remaining - 1; j++) {
                source[j] = source[j + 1];

            }
            source[remaining-1] = 0;
            remaining--;
        }
        IO.println(Arrays.toString(result));
    }
}
