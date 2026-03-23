package crapsGameExtended;

public class Player {
    private Die die1;
    private Die die2;
    private int rollCount;
    int number = 0;

    public Player() {
        this.die1 = new Die();
        this.die2 = new Die();
    }

    public int getRollCount() {
        return rollCount;
    }

    public int getTotalFacevalue() {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    public void throwDie() {
        die1.roll();
        die2.roll();
        rollCount++;

    }

    public void play() {
        boolean playing = true;
        int gamesWon = 0;
        int gamesLost = 0;
        while (playing) {

            IO.println("Roll?");
            IO.readln();
            throwDie();
            IO.println("Rolling...");
            IO.println(die1.getFaceValue() + ", " + die2.getFaceValue());

            if (getTotalFacevalue() == 7 || getTotalFacevalue() == 11) {
                IO.println("You won the game :)");
                gamesWon++;

            } else if (getTotalFacevalue() == 2 || getTotalFacevalue() == 3 || getTotalFacevalue() == 12) {
                IO.println("You lost the game :(");
                gamesLost++;

            } else {
                number = getTotalFacevalue();
                IO.println("Point is set to: " + number);


                boolean finished = false;

                while (!finished) {
                    IO.println("Roll?");
                    IO.readln();

                    throwDie();
                    IO.println("Rolling...");
                    IO.println(die1.getFaceValue() + ", " + die2.getFaceValue() + " - Total: " + getTotalFacevalue());

                    if (getTotalFacevalue() == 7) {
                        IO.println("You lost the game :(");
                        gamesLost++;
                        finished = true;
                    } else if (getTotalFacevalue() == number) {
                        IO.println("You won the game :)");
                        gamesWon++;
                        finished = true;
                    }

                }
            }
            IO.print("Wanna play again? y/n: ");
            String again = IO.readln();
            if (again.equalsIgnoreCase("n")) {
                playing = false;
            }
        }
        IO.println("Thanks for playing!");
        IO.println("Games won: " + gamesWon);
        IO.println("Games lost: " + gamesLost);
    }
}