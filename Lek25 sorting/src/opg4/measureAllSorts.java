package opg4;

import java.util.ArrayList;
import java.util.Random;

public class measureAllSorts {
    void main() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        Random random = new Random();
        list1.addAll(random.ints(50000, 5, 1000).boxed().toList());
        list2.addAll(random.ints(50000, 1, 1000).boxed().toList());
        list3.addAll(random.ints(50000, 1, 1000).boxed().toList());
        System.currentTimeMillis();
        IO.println(list1);
        bubbleSort(list1);
        IO.println(System.currentTimeMillis());
        IO.println(list1);

    }

    public static void bubbleSort(ArrayList<Integer> liste) {
        boolean swapped = true;
        for (int i = liste.size() -1; swapped && i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (liste.get(j) > liste.get(j + 1)) {
                    int temp = liste.get(j);
                    liste.set(j, j + 1);
                    liste.set(j + 1, temp);
                    swapped = true;
                }
            }
        }
    }
}
