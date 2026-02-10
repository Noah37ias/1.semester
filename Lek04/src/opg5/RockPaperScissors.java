package opg5;

public class RockPaperScissors {
    void main(){
        IO.println("1 = Rock  |  2 = Paper  |  3 = Scissors");
        IO.print("Insert number: ");
        int guess = Integer.parseInt(IO.readln());
        int number = (int)(Math.random()*3)+1;
        String resultUser = numberToName(guess);
        String resultPc = numberToName(number);
        IO.println("The user picked: " + resultUser);
        IO.println("The PC picked: " + resultPc);
        String winner = resultat(resultUser,resultPc);
        IO.println(winner);
    }
public String numberToName(int guess){
        if(guess==1){
            return "Rock";
        }
        else if(guess==2) {
            return "Paper";
        }
        else if(guess==3) {
            return "Scissors";
        }
        else return "Insert 1,2,3";
}
public String resultat(String choicePc, String choiceUser){
    if(choicePc.equalsIgnoreCase(choiceUser)){
        return "both of you picked " + choicePc;
    }
    else if
        (choiceUser.equalsIgnoreCase("Rock") &&
                choicePc.equalsIgnoreCase("Paper")){
        return "PC won, Paper beats Rock";
    }
    else if (choiceUser.equalsIgnoreCase("Paper") &&
            choicePc.equalsIgnoreCase("Rock")){
        return "PC won, Paper beats Rock";
    }
    else if (choiceUser.equalsIgnoreCase("Scissors") &&
            choicePc.equalsIgnoreCase("Rock")){
        return "User won, Rock beats Scissors";
    }
    else if (choiceUser.equalsIgnoreCase("Rock") &&
            choicePc.equalsIgnoreCase("Scissors")){
        return "PC won, Rock beats Scissors";
    }
    else if (choiceUser.equalsIgnoreCase("Scissors") &&
            choicePc.equalsIgnoreCase("Paper")){
        return "User won, Scissors beats Paper";
    }
    else if (choiceUser.equalsIgnoreCase("Paper") &&
            choicePc.equalsIgnoreCase("Scissors")){
        return "PC won, Scissors beats Paper";
    }

return null;
}

}
