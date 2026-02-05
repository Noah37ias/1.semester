package opg2;
import java.util.Scanner;
public class NumberOrder {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert 3 whole numbers: ");
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();
        String result = order(number1,number2,number3);
        //String result2 = order(number3,number2, number1);
        System.out.println(result);
        //System.out.println(result2);

    }
    public static String order(int number1,int number2,int number3){
    if(number1<number2 && number1 < number3){
        return "Voksende";
    }
    else if(number1>number2&&number2>number3){
        return "Aftagende";
    }
    else
        return "Hverken-eller";

    }
}
