package opg3;

public class LinearSearch3 {
    int[] arr1 = {10,123,133,13,13};
    int[] arr2 = {1,10,111,1123,13};
    int[] arr3 = {1,11,1,1,13};
    void main(){
        IO.println("Array 1: "+LinearSearch(arr1));
        IO.println("Array 2: "+LinearSearch(arr2));
        IO.println("Array 3: "+LinearSearch(arr3));
    }
    public boolean LinearSearch(int[] arr){
        boolean found = false;
        int i = 0;
        while(!found && i <arr.length-1){
            if(arr[i]==arr[i+1]){
                found = true;
            }
            else i++;
        }
        return found;
    }
}
