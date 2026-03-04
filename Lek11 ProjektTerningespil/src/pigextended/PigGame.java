package pigextended;

public class PigGame {
    void main(){
        printRules();
        IO.println();
        Player player1 = new Player();
        Player player2 = new Player();

        IO.println("Playing pig game");
        while(player1.getPoints() <100 || player2.getPoints()<100) {
            IO.println("Player 1 Turn");
            player1.playTurn();
            IO.println("Player 2 Turn");
            player2.playTurn();
        }
        printResults(player1);
        printResults(player2);

        IO.println();

        IO.println("Thank you for playing the pig game");
    }

    public static void printRules() {
        IO.println("=====================================================");
        IO.println("Rules of Pig game:");
        IO.println("The player throws one die as long as he/she wants.");
        IO.println("But if the dice hits 1 your round is over");
        IO.println("If you hit 5,3,5 your points is 13");
        IO.println("First player to 100 wins");
        IO.println("=====================================================");
    }

    public static void printResults(Player player) {
        IO.println("Results");
        IO.println("-------");
        IO.println("Roll count: "+ player.getRollCount());

    }
}



