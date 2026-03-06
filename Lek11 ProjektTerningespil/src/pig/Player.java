package pig;

public class Player {
    private Die die1;
    private int rollCount;
    private int points;//Til at holde styr på total points

    public Player() {
        this.die1 = new Die();//Opretter en terning
    }

    public void throwDie() {
        die1.roll();//Bruger roll fra die klassen
        rollCount++;
    }

    public int getRollCount() {
        return rollCount;
    }

    public int getPoints() {
        return points;
    }

    public void playTurn() {
        int roundPoints = 0;//Variabel til points i runden
        IO.print("Roll? ");
        IO.readln();

        boolean finished = false;//Bruges til at holde styr på om runden skal fortsætte
        while (!finished) {

            throwDie();//Bruger throwDie metoden
            IO.println(String.format("Rolling... %d", die1.getFaceValue()));//Printer dit slag

            if (die1.getFaceValue() == 1) {//Hvis man slår 1
                IO.println("Your round is over ");
                finished = true;//Afslutter runden
            } else {
                roundPoints += die1.getFaceValue();//Læg slået værdi til roundpoints
                IO.println("Points this round: " + roundPoints);
                IO.println("Roll again? (Y/n)");
                String again = IO.readln();
                if (again.equalsIgnoreCase("n")) {//Hvis man ønsker at stoppe
                    points += roundPoints;//Læg roundPoints til ens total points
                    IO.println("Your round is over points now: " + points);
                    finished = true;//Afslutter runden
                }
            }
        }
    }
}