package opg1;

import java.util.ArrayList;

public class BubbleSortStringArray {
    private ArrayList<String> navne = new ArrayList<>();

    void main() {
        navne.add("Noah");
        navne.add("Carsten");
        navne.add("Arian");
        IO.println(navne.size());

    }

    public static void bubbleSort(ArrayList<String> strings) {
        boolean swapped = true;
        for (int i = strings.size(); i > 0 && swapped == true; i--) {
            swapped = false;
//            for (int j = 0; j < i; j++) {
//                if (strings.get(j) > strings.get(j + 1)) {
//                    // swap arr[j] and arr[j+1]
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    swapped = true;
//                }
//            }
        }
    }
}
