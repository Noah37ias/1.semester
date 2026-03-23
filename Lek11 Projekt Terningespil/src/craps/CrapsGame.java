package craps;

public class CrapsGame {
    void main() {
        printRules();
        Player p1 = new Player();
        p1.play();
        printResults(p1);

    }

    public static void printRules() {
        IO.println("Rules of Craps");
        IO.println("* First roll:");
        IO.println("-----------------------------------------------------------------------");
        IO.println("7 or 11             -   You win!");
        IO.println("2,3 or 12           -   You lose!");
        IO.println("4,5,6,8,9 or 10     -   Point set, the game continues!");
        IO.println("-----------------------------------------------------------------------");
        IO.println("* When point is set, you keep rolling the dice until:");
        IO.println("Hit your set point  -   You win!");
        IO.println("7                   -   You lose!");
        IO.println("-----------------------------------------------------------------------");
    }

    public static void printResults(Player p1) {
        IO.println("Results");
        IO.println("-------");
        IO.println("Roll count: " + p1.getRollCount());

    }
}
