package opg4;

import java.util.ArrayList;

public class Test {
    ArrayList<Player> players = new ArrayList<Player>();
    void main(){
        Player player1 = new Player("Noah",100,180,75);
        Player player2 = new Player("Lort",79,180,75);
        Player player3 = new Player("Alex",77,160,75);
        Player player4 = new Player("Bent",76,180,75);
        Player player5 = new Player("Svend",55,150,75);
        Player player6 = new Player("Sten",11,110,75);


        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);

        findPlayerGoals(players,100);
        IO.println(findPlayerGoals(players,69));

        IO.println(findPlayerBinary(players,69));
        IO.println(findPlayerName(players));
    }


    public Player findPlayerGoals(ArrayList<Player> players, int score) {
        boolean found = false;
        int i = 0;
        Player foundPlayer = null;

        while(!found && i < players.size()) {
            if(players.get(i).getScoredGoals() == score) {
                foundPlayer=players.get(i);
                found = true;
            }
            else i++;
        }
        return foundPlayer;
    }
    public Player findPlayerBinary(ArrayList<Player> players, int score) {
        Player foundPlayer = null;
        int right = players.size()-1;
        int left = 0;

        while(foundPlayer == null && left <= right) {
        int middle = (left + right) / 2;
        if(players.get(middle).getScoredGoals() == score) {
            foundPlayer=players.get(middle);
        }
        else if(players.get(middle).getScoredGoals() < score) {
        right=middle-1;
        }
        else left=middle+1;
        }
        return foundPlayer;
    }
    public String findPlayerName(ArrayList<Player> players) {
        String foundPlayerName = null;
        int i = 0;
        while(foundPlayerName == null && i < players.size()) {
            if(players.get(i).getHeight()<170 && players.get(i).getScoredGoals() > 50) {
                foundPlayerName=players.get(i).getName();
            }
            else i++;
        }
        return foundPlayerName;
    }
}
