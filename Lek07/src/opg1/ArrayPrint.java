package opg1;

import java.util.Arrays;

public class ArrayPrint {
    void main(){

        int[] listOne = new int[10];
        IO.println("Opgave 1" + Arrays.toString(listOne));

        int[] listTwo = {2,44 -23, 99, 8, -5, 7, 10, 20, 30};
        IO.println("Opgave 2" + Arrays.toString(listTwo));

        int[] listThree = new int[10];
        for(int i = 0; i < listThree.length; i++){
        listThree[i] = i;
        }
        IO.println("Opgave 3" + Arrays.toString(listThree));
        int[] listFour = new int[10];
        for(int i = 0; i < listFour.length;i++){
            listFour[i] = (i+1) * 2;
        }
        IO.println("Opgave 4" + Arrays.toString(listFour));
        int[] listFive = new int[10];
        for(int i = 0; i < listFive.length; i++) {
            listFive[i] = i*i;
        }
        IO.println("Opgave 5" + Arrays.toString(listFive));
            int[] listSix = new int[10];
        for(int i = 0; i < listSix.length; i++){
            listSix[i] = i % 2;
        }
        IO.println("Opgave 6" + Arrays.toString(listSix));
        int[] listSeven = new int[10];


    }
}
