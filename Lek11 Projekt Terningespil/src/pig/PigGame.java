package pig;

public class PigGame {
    void main() {
        printRules();//Bruger printRules metoden
        IO.println();
        Player player1 = new Player();//Opretter player1
        Player player2 = new Player();//Opretter player2

        IO.println("Playing pig game");
        while (player1.getPoints() <= 100 || player2.getPoints() <= 100) {//Så længe man er under 100 fortsæt
            IO.println("*****************");
            IO.println("* Player 1 Turn *");
            IO.println("*****************");

            player1.playTurn();//player1 spiller nu(Gør brug af playTurn metoden)
            if (player1.getPoints() >= 100) {//Hvis man kommer over 100 points
                IO.println("Player 1 Wins!");
                break;//Stopper while løkken så player2 ikke påbegynder sin tur
            }
            IO.println("*****************");
            IO.println("* Player 2 Turn *");
            IO.println("*****************");

            player2.playTurn();//player2 spiller nu(Gør brug af playTurn metoden)
            if (player2.getPoints() >= 100) {//Hvis man kommer over 100 points
                IO.println("Player 2 Wins!");
                break;//Stop while løkken
            }
        }
        //printResults(player1);
        //printResults(player2);

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
        IO.println("Roll count: " + player.getRollCount());

    }
}



