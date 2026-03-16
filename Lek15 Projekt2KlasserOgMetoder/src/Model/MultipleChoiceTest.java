package Model;

import javax.swing.plaf.multi.MultiListUI;
import java.util.Random;

public class MultipleChoiceTest {
    private static Random random = new Random();


    public static char[] generateAnswers(int size) {
        char[] muligheder = new char[10];

        int[] answers = new int[size];
        for (int i = 0; i < size; i++) {
            answers[i] = random.nextInt(4);
            switch(answers[i]){
                case 0 -> muligheder[i] = 'A';
                case 1 -> muligheder[i] = 'B';
                case 2 -> muligheder[i] = 'C';
                default -> muligheder[i] = 'D';
            }
        }
        return muligheder;
    }

}
