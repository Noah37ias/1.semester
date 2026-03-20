package test;

import java.util.Scanner;

public class AppNoahA {
    void main() {
        //del 1
        int rejseBudget = 0;
        double euroBudget = 0;
        double dollarBudget = 0;
        double jpyBudget = 0;
        Scanner scanner = new Scanner(IO.readln("Indsæt dit daglige rejsebudget i DKK: "));
        rejseBudget = scanner.nextInt();
        //del 2
        euroBudget = rejseBudget / 7.4729;
        dollarBudget = rejseBudget / 6.5116;
        jpyBudget = rejseBudget / 0.0409;

        IO.println(String.format("Rejsebudget i USD: %.2f ", dollarBudget));
        IO.println(String.format("Rejsebudget i EUR: %.2f", euroBudget));
        IO.println(String.format("Rejsebudget i JPY: %.2f", jpyBudget));

        //del 3
        IO.println("Budgetvurdering/anbefaling: ");
        if (euroBudget < 60) {//Hvis vores budget er under 60
            IO.println("Lavt budget(f.eks Sydøstasien eller Østeuropa");
        } else if (euroBudget > 120) {//hvis vores budget er over 120
            IO.println("Højt budget(f.eks Asien,Skandinavien eller USA");
        } else {//Hvis vores budget hverken er over 120 eller under 60
            IO.println("Medium budget (f.eks Europa eller Latinamerika");
        }
    }
}
