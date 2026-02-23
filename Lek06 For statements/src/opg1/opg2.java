package opg1;

import java.util.Queue;

public class opg2 {
    void main() {
        IO.println("Opgave a:");
        printPowersOfTwo(); //opgave a

        IO.println("Opgave b");
        int total = sumEvenInts(7,25); //opgave b
        IO.println(total);

        IO.println("Opgave c");
        int sumOf = sumOddDigits(1234567);//opgave c

        IO.println(sumOf);
    }

    public void printPowersOfTwo() {
        int tal = 1;

        for(int potens = 0;potens <= 20;potens++) {
            IO.println("2 opløftet i " + potens + " giver " + tal);// skal printes inden, da 2^0=1
            tal = tal * 2; //2*1 = 2, 2*2=4, 2*4=8 - samme som 2^1, 2^2 og 2^3
        }
    }

    public int sumEvenInts(int lower, int upper) {
        int sum = 0;
        while (lower < upper) {// så længe lower er mindre end upper fortsæt
            if (lower % 2 == 0) {//Tjek om tallet er lige
                sum = sum + lower;//Tilføj til total sum
                // IO.println(sum); //til test
            }
            lower++;//Ryk vores lower en op
            //IO.println(lower); //til test
        }
        return sum;
    }

    public int sumOddDigits(int number) {
        int sum = 0;
        while (number > 0) {//Så længe number er større end 0 fortsæt
            if (number % 2 == 1) { //Tjekker om tallet er ulige
                int ciffer = number % 10; //Denne bruges til at få vores sidste ciffer 1234567 % 10 = 7
                sum = ciffer + sum; //Vi ved jo at tallet er ulige så vi skal have det tilføjet til sum
            }
            number = number / 10;//Gør det sidste tal til kommatal 1234567 / 10 = 123456,7
        }
        return sum;
    }
}
