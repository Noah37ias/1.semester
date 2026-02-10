package opg1;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IO.print("Insert whole number here: ");
        int number = input.nextInt();
        NumberReader2.numberCheck(number);
    }
}
