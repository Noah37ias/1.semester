package opg3;

import java.util.Arrays;

public class SumOfTwoArrays {
    void main() {
        //OPGAVE 3
        int[] list1 = {4, 6, 7, 2, 3};
        int[] list2 = {4, 6, 8, 2, 6};
        int[] list3 = sumArrays(list1, list2);
        IO.println(Arrays.toString(list3));

        //OPGAVE 4
        boolean UnEven1 = hasUnEven(list1);
        boolean UnEven2 = hasUnEven(list2);
        IO.println(UnEven1);
        IO.println(UnEven2);

    }

    public int[] sumArrays(int[] a, int[] b) {
        int[] c = new int[5];
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public boolean hasUnEven(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 1) {
                return true;
            }

        }
        return false;
    }
}
