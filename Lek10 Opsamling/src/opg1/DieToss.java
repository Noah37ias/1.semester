package opg1;

import java.util.Random;

public class DieToss {
    void main() {
        int[] list = new int[20];
        Random random = new Random();

        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(6) + 1;
        }
        boolean inRun = false;

        for (int i = 0; i < list.length; i++) {
            if (inRun) {
                if (list[i] != list[i-1]) {
                    IO.print(")");
                    inRun = false;
                }
            }
            if (!inRun) {
                if (i < list.length - 1 && list[i] == list[i + 1]) {
                    IO.print(" (");
                    inRun = true;
                } else if (i > 0 && list[i] != list[i - 1]) {
                    IO.print(" ");
                }
            }
            IO.print(list[i]);
        }
        if (inRun) {
            IO.print(")");
        }
    }
}
