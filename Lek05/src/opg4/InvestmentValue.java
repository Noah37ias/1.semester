package opg4;

public class InvestmentValue {
    void main() {
        IO.print("Insert investment, interest and amount of years");
        double investment = Double.parseDouble(IO.readln());
        double interest = Double.parseDouble(IO.readln());
        int years = Integer.parseInt(IO.readln());

        double monthlyInterestRate = interest / 1200; //månedlig rente i decimal

        futureInvestment(investment, monthlyInterestRate, years);//Metode kald
        //IO.println(sum);//Print resultat
    }

    public void futureInvestment(double investment, double monthlyInterestRate, int years) {
        int i = 1;
        while (i <= years) {

            double sum = investment * Math.pow(1 + monthlyInterestRate, i * 12);
            IO.println(sum);
            i++;

        }

    }

}

