package opgave1;
import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        IO.print("Enter purchased amount: ");
        double purchaseAmount = input.nextDouble();
        double salesTax = purchaseAmount * 0.06;

        IO.println("Sales tax is " + salesTax);
        input.close();
    }
}
