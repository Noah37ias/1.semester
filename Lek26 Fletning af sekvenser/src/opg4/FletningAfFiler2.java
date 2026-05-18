package opg4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FletningAfFiler2 {
    void main() {
        String fileName1 = "Lek26 Fletning af sekvenser/src/opg4/heltal1";
        String fileName2 = "Lek26 Fletning af sekvenser/src/opg4/heltal2";
        String fileName3 = "Lek26 Fletning af sekvenser/src/opg4/heltalSamlet2";
        mergeFiles(fileName1,fileName2,fileName3);
    }

    public void mergeFiles(String fileName1, String fileName2, String fileName3) {
        File f1 = new File(fileName1);
        File f2 = new File(fileName2);
        File f3 = new File(fileName3);

        try (Scanner scan1 = new Scanner(f1);
             Scanner scan2 = new Scanner(f2);
             PrintWriter writer = new PrintWriter(f3)) {

            int tal1 = scan1.nextInt();
            int tal2 = scan2.nextInt();
            while (scan1.hasNext() || scan2.hasNext()) {
                if (tal1 < tal2) {
                    writer.println(tal1);
                    tal1 = scan1.nextInt();
                } else if (tal1 > tal2) {
                    writer.println(tal2);
                    tal2 = scan2.nextInt();
                } else {
                    writer.println(tal1);
                    tal1 = scan1.nextInt();
                    tal2 = scan2.nextInt();
                }
            }
            writer.println(Integer.MAX_VALUE);
        } catch (
                FileNotFoundException ex) {
            System.out.println(ex);
        }

    }
}