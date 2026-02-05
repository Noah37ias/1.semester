import java.util.Scanner;

public class NumberReader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IO.print("Insert a whole number: ");
        int number = input.nextInt();
        if (number > 0) {
            IO.println("Positiv");
        }
        else if(number < 0){
            IO.println("Negativ");
        }
        else if(number == 0){
            IO.println("0");
        }
    }
}
