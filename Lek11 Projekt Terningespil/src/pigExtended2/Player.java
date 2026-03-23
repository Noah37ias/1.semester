package pigExtended2;

public class Player {
    private Die die1;
    private int rollCount;
    private int points;

    private int roundNumber;

    public Player() {
        this.die1 = new Die();
    }

    public void throwDie() {
        die1.roll();
        rollCount++;
    }

    public int getRollCount() {
        return rollCount;
    }

    public int getPoints() {
        return points;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void playTurn() {
        int roundPoints = 0;

        IO.print("Roll? ");
        IO.readln();
        boolean finished = false;
        while (!finished) {

            throwDie();
            IO.println(String.format("Rolling... %d", die1.getFaceValue()));

            if (die1.getFaceValue() == 1) {
                IO.println("Your round is over, total points now: " + points);
                roundNumber++;
                finished = true;

            } else {
                roundPoints += die1.getFaceValue();
                IO.println("Points this round: " + roundPoints + " Total points now: " + points);
                IO.println("Roll again? (Y/n)");
                String again = IO.readln();
                if (again.equalsIgnoreCase("n")) {
                    points += roundPoints;
                    IO.println("Your round is over, total points now: " + points);
                    IO.println();
                    roundNumber++;
                    finished = true;
                }
            }
        }
    }
}