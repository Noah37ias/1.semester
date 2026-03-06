package rollTwoDice;

import java.util.Arrays;

public class RollTwoDiceGame {
    void main() {

        Player p1 = new Player();
        p1.play();
    }

    public static void printRules() {
        IO.println("=====================================================");
        IO.println("Rules of RollOneDie:");
        IO.println("The player throws one die as long as he/she wants.");
        IO.println("=====================================================");
    }

    public static void printResults(Player p1) {
        IO.println("Results");
        IO.println("-------");
        IO.println("Roll count: " + p1.getRollCount());

    }
}