package opg1;

public class NumberReader2 {
    public static void main(String[] args) {
    }
        public static void numberCheck(int number){
            if (number > 0) {
                IO.println("Positiv");
            }
            else if(number < 0){
                IO.println("Negativ");
            }
            else if(number == 0){
                IO.println("0");
            }
        }
    }

