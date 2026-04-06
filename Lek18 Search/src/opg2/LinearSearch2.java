package opg2;

public class LinearSearch2 {
    int[] arr1 = {10,1,1,1,13};
    int[] arr2 = {1,1,1,1,1};
    int[] arr3 = {1,1,1,1,13};

    void main() {
        IO.println("Array 1: "+LinearSearch(arr1));
        IO.println("Array 2: "+LinearSearch(arr2));
        IO.println("Array 3: "+LinearSearch(arr3));
    }

    public int LinearSearch(int arr[]) {
        boolean found = false;
        int i = 0;
        int result = -1;

        while (!found && i < arr.length) {
            if (arr[i] >= 10 && arr[i] <= 15) {
                result = arr[i];
                found = true;
            }
            else i++;
        }
        return result;
    }
}
