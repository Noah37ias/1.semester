package Model;

import javax.swing.plaf.multi.MultiListUI;
import java.util.Random;

public class MultipleChoiceTest {
    private static Random random = new Random();
    private static char[] correctAnswer = {'A','B','C','D','A','B','C','D','A','B'};


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

    public static char[] getCorrectAnswer() {
        return correctAnswer;
    }

    public static void setCorrectAnswer(char[] correctAnswer) {
        MultipleChoiceTest.correctAnswer = correctAnswer;
    }
}
