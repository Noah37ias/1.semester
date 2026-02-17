package opg2;

import java.util.Scanner;

public class NumberReaderA {
    void main() {
        int amount = Integer.parseInt(IO.readln());
        Scanner input = new Scanner(System.in);
        IO.println("Insert " + amount + " numbers between 1 and 99: ");

        int max = -67; //For at være sikker på max er mindre end indtastet tal
        int min = 6767; //For at være sikker på min er større end indtastet tal
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < amount; i++) {//Kører alle tal igennem
            int number = input.nextInt();

            if (number > max) {//Hvis vores nuværende number er større end max
                max = number;//Ændrer max til det nuværende number
            }
            if (number < min) {//Hvis vores nuværende number er mindre end min
                min = number;//Ændrer min til det nuværende number
            }
            if (number % 2 == 0) {//Hvis number er et lige tal
                evenCount++;//Lig 1 til evenCount
            }
            if (number % 2 != 0) {//Hvis number er et ulige tal
                oddCount++;//Lig 1 til oddCount
            }

        }
        //Når forløkken er afsluttet print følgende
        IO.println("Amount of odd numbers found: " + oddCount);
        IO.println("Amount of even numbers found: " + evenCount);
        IO.println("The biggest number found: " + max);
        IO.println("The smallest number found: " + min);

    }
}
