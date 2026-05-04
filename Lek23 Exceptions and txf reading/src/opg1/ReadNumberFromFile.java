package opg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.Scanner;

public class ReadNumberFromFile {
    void main() {
        String fileName = "Lek23 Exceptions and txf reading/src/opg1/Numbers";
        File f = new File(fileName);
        try (Scanner scan = new Scanner(f)) {
            while (scan.hasNextInt()) {
                int number = scan.nextInt();
                number = number * 2;
                IO.println(number);
            }
        } catch (
                FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}