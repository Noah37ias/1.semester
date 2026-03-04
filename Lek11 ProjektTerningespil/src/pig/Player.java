package pig;

public class Player {
    private Die die1;
    private int rollCount;
    int points = 0;

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

    public void play() {

        IO.println("Roll?");
        IO.readln();
        boolean finished = false;
        while (!finished) {

            throwDie();
            IO.println(String.format("Rolling... %d", die1.getFaceValue()));
            if (die1.getFaceValue() == 1) {
                IO.println("Your round is over ");
                finished = true;
            } else {
                IO.println("Roll again? (Y/n)");
                String again = IO.readln();
                if (again.equalsIgnoreCase("n")) {
                    points += rollCount;
                    IO.println(rollCount);
                    finished = true;
                }
            }
        }
    }
}