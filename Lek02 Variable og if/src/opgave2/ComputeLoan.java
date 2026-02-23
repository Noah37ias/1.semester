package opgave2;
import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Loan Amount, annual interest and number of years: ");
        double loanAmount = input.nextDouble();
        double interest = input.nextDouble();
        double years = input.nextDouble();

        double numberOfMonths = years * 12;
        double interestRatePrMonth = interest/12/100;
        IO.println(loanAmount+" "+interest+" "+numberOfMonths);
        double denumerator = 1-1/Math.pow(1+interestRatePrMonth, numberOfMonths);
        double monthlyPayment = loanAmount * interestRatePrMonth / denumerator;
        IO.println("The monthly payment is: " + monthlyPayment);
        IO.println("Total payment is: " + monthlyPayment * numberOfMonths);

    }
}
