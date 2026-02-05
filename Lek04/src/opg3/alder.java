package opg3;
import java.util.Scanner;
public class alder {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert age here: ");
        int age = input.nextInt();
        alder tjekAlder = new alder();
        String result = tjekAlder.institution(age);
        System.out.println(result);

    }
    public String institution(int age){
        if(age > 0 && age <=2){
            return "Nursey";
        }
        else if(age >= 3 && age <=5){
            return"Kindergarten";
        }
        else if(age == 0){
            return "Home";
        }
        else if(age>=6 && age<=16){
            return "School";
        }
        else return "Out of School";
    }
}
