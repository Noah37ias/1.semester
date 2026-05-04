package opg3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteFromFile {

    void main() {
        String fileName = ("Lek23 Exceptions and txf reading/src/opg3/Test");
        File out = new File(fileName);

        try(PrintWriter writer = new PrintWriter(out)){
            int number = 0;
            while(number != 101){
                if(number%2==0){
                    writer.println(number);
                }
                number++;

            }
        }catch(FileNotFoundException ex){
            IO.println(ex);
        }
    }
}