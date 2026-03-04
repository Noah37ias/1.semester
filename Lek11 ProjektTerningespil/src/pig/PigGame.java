package pig;

public class PigGame {
    void main(){
        printRules();
        IO.println();
        Player player1 = new Player();
        Player player2 = new Player();

        IO.println("Playing pig game");
        IO.print("Insert amount of points to win: ");
        int winPoints = Integer.parseInt(IO.readln());
        while(player1.getPoints() < winPoints || player2.getPoints()< winPoints) {
            IO.println("*****************");
            IO.println("* Player 1 Turn *");
            IO.println("*****************");

            player1.playTurn();
            if(player1.getPoints() >= winPoints) {
                IO.println("Player 1 Wins!");
                break;
            }
            IO.println("*****************");
            IO.println("* Player 2 Turn *");
            IO.println("*****************");

            player2.playTurn();
            if(player2.getPoints() >= winPoints) {
                IO.println("Player 2 Wins!");
                break;
            }
        }
        printResults(player1,player2);

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

    public static void printResults(Player player1, Player player2) {
        IO.println("Results");
        IO.println("-------");

        IO.println("Player 1 average roll count pr round: "+ (double) player1.getRollCount()/player1.getRoundNumber());
        IO.println("Player 2 average roll count pr round: "+ (double) player2.getRollCount()/player2.getRoundNumber());
    }
}



