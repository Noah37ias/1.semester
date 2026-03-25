package opg1;

public class LinearSearch1 {
    int[] arr = {2,2,2,2,2,1};
    void main(){
        IO.println(LinearSearchArray(arr));

    }
    public boolean LinearSearchArray(int[]arr){
        boolean found = false;
        int i = 0;
        while(!found && i<arr.length){
            if(arr[i]%2==0){
                i++;
            }
        else found = true;
        }
        return found;
    }
}
