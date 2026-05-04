package opg4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FromKeyboard {
    void main(){
        Scanner scanner = new Scanner(System.in);
        String fileName = ("Lek23 Exceptions and txf reading/src/opg4/Test");
        File out = new File(fileName);

        try(PrintWriter pw = new PrintWriter(out)){
            int input = scanner.nextInt();

            while(input!=-1) {
                if(input>0){
                    pw.println(input);
                }
                input = scanner.nextInt();
            }
            scanner.close();
        }catch(FileNotFoundException ex){
            IO.println(ex);
        }
    }
}
