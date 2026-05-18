package opg2;

import opg1.Customer;

import java.util.Arrays;

public class MergeIntegers {
    void main() {
        int[] liste1 = {2, 4, 6, 8, 10, 12, 14};
        int[] liste2 = {1, 2, 4, 5, 6, 9, 12, 17};
        IO.println(Arrays.toString(sharedNumbers(liste1, liste2)));
    }

    public int[] sharedNumbers(int[] l1, int[] l2) {
        int[] result = new int[l1.length];
        int i1 = 0;
        int i2 = 0;
        int n = 0;
        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2]) {
                i1++;
            } else if (l1[i1] > l2[i2]) {
                i2++;
            } else {
                result[n] = l1[i1];
                n++;
                i1++;
                i2++;
            }
        }
        return result;
    }
}
