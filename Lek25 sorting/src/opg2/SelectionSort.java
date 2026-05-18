package opg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SelectionSort {
    void main() {
        Customer c1 = new Customer("Noah", 100);
        Customer c2 = new Customer("Carsten", 150);
        Customer c3 = new Customer("Arian", 200);
        Customer c4 = new Customer("Arian", 250);
        Customer c5 = new Customer("Arian", 100);
        Customer c6 = new Customer("Arian", 300);

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(c6);

        Collections.sort(customers);
        IO.println(customers);
        String[] list = {"Noah", "Carsten", "Arian", "Arian"};
        selectionSort(list);
        IO.println(Arrays.toString(list));
    }

    public static void selectionSort(String[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {

                if (list[minIndex].compareTo(list[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                String temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }
}
