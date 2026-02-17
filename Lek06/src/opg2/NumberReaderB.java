package opg2;

import java.util.Scanner;

public class NumberReaderB {
    void main() {
        int amount = Integer.parseInt(IO.readln());
        Scanner input = new Scanner(System.in);
        IO.println("Insert " + amount + " numbers between 1 and 99: ");
        int sum = 0;

        for(int i = 0;i < amount; i++) {
            int numbers = input.nextInt();
            sum = numbers + sum;//Læg numbers til sum
            IO.println(sum);
        }
    }
}
