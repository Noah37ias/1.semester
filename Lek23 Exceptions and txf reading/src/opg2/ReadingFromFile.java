package opg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingFromFile {
    private ArrayList<Integer> list = new ArrayList<>();

    void main(){
        String fileName = ("Lek23 Exceptions and txf reading/src/opg1/Numbers");
        File f = new File(fileName);
        try(Scanner scanner = new Scanner(f)){
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                list.add(number);
            }
                for(int i = list.size()-1; i>=0;i--){
                    IO.println(list.get(i));
            }
        } catch(FileNotFoundException ex){
            IO.println(ex);
        }

    }
}
