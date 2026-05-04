package opg3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    void main(){
        String fileName = ("Lek23 Exceptions and txf reading/src/opg1/Numbers");
        File f = new File(fileName);
        try(Scanner scanner = new Scanner(f)){
            while(scanner.hasNextInt()){

            }
        }catch(FileNotFoundException ex) {
            IO.println(ex);
        }
    }
}
