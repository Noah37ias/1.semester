package opg5;

public class Pattern {
    void main() {
        int n = Integer.parseInt(IO.readln());
        displayPattern(n);

    }

    public void displayPattern(int n) {
        int row = 1;//Første række

        while (row <= n) {//Så længe vi ikke er over n rækker
            int column = 1;//Sætter column til 0 igen

            while (column <= row) {//Kører så længe column er mindre end = række nr
                IO.print(column + " ");//Udskriver vores column og et mellemrum
                column++; //Går til næste column
            }
            IO.println();//Skifter linje
            row++;//Næste række
        }
    }
}
