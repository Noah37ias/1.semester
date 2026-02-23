package opg6;

import java.util.Arrays;

public class Ekstra {
    void main() {
        int[] list1 = {1, 2, 6, 9, 3, 5, 22, 11};
        int[] result1 = replaceNumber(list1);
        IO.println(Arrays.toString(result1));

        int[] result2 = swapElements(list1);
        IO.println(Arrays.toString(result2));
    }

    public int[] replaceNumber(int[] list) {
        int[] newList = new int[list.length];//En liste på samme længde som list

        for (int i = 0; i < list.length; i++) {

            if (list[i] % 2 == 1) {
                newList[i] = 0;
            } else {
                newList[i] = list[i];
            }
        }
        return newList;
    }

    public int[] swapElements(int[] list) {
        int[] withSwapped = new int[list.length];//En liste på samme længde som list

        for (int i = 0; i < list.length; i++) {
            if (i == list.length - 1){
                withSwapped[i] = list[0];
            }
            else if(i==0){//Er vi på det første tal?
                withSwapped[i] = list[list.length-1];//Sidste tal i list bliver første tal i swapped
            }
            else{
                withSwapped[i] = list[i];
            }
        }
        return withSwapped;
    }
    public boolean isAscending(int[]list){
        int[] lastNumber = new int[list.length]; //En liste på samme længde som list
    for(int i = 0; i<list.length;i++){
    //    if(list==)
    }
        return true;
    }
}
