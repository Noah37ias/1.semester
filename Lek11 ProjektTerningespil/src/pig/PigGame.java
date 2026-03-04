package pig;

public class PigGame {
    void main(){
        printRules();
        IO.println();

        Player player1 = new Player();
        Player player2 = new Player();

        IO.println("Plying RollOneDice.");
        player1.play();
        player2.play();

        printResults(player1);
        printResults(player2);

        IO.println();

        IO.println("Thank you for playing RollOneDie.");
    }

    public static void printRules() {
        IO.println("=====================================================");
        IO.println("Rules of RollOneDie:");
        IO.println("The player throws one die as long as he/she wants.");
        IO.println("=====================================================");
    }

    public static void printResults(Player player) {
        IO.println("Results");
        IO.println("-------");
        IO.println("Roll count: "+ player.getRollCount());
    }
}



