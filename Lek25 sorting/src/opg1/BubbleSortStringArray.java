package opg1;

import java.util.ArrayList;

public class BubbleSortStringArray {
    private ArrayList<String> navne = new ArrayList<>();

    void main() {
        navne.add("Noah");
        navne.add("Carsten");
        navne.add("Arian");
        navne.add("Arian");
        navne.add("Arian");
        navne.add("Noah");
        IO.println(navne);
        bubbleSort(navne);
        IO.println(navne);
    }

    public static void bubbleSort(ArrayList<String> strings) {
        boolean swapped = true;
        for (int i = strings.size()-1; i > 0 && swapped == true; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (strings.get(j).compareToIgnoreCase(strings.get(j + 1))>0) {
                    //swap arr[j] and arr[j+1]
                    String temp = strings.get(j);
                    strings.set(j, strings.get(j + 1));
                    strings.set(j + 1, temp);
                    swapped = true;
                }
            }
        }
    }
}
