package opg4;

public class InvestmentValue {
    void main(){
        IO.print("Insert investment, interest and amount of years");
        double investment = Double.parseDouble(IO.readln());
        double interest = Double.parseDouble(IO.readln());
        double years = Double.parseDouble(IO.readln());


        double sum = futureInvestment(investment,interest,years);//Metode kald
        //IO.println(sum);//Print resultat
    }
    public double futureInvestment(double investment, double interest, double years){
        double sum = investment;
        int i = 0;
        while(i<years){
            sum = investment +(sum * (interest/100));
            IO.println(sum);
            i++;

        }
        return sum;
    }
}
