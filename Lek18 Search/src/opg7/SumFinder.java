package opg7;

public class SumFinder {
    private int[] numbers = {1,2,3,4,5,6,7};

    void main(){

        IO.println(searchSum(numbers,7));
    }
    public int searchSum(int[] numbers,int total){
        int i = 0;
        int found = -67;
        while(found==-67 && i<numbers.length){
            if(sum(i,total,numbers)){
                found = i;
            }
            else i++;
        }
        return found;
    }
    public boolean sum(int i,int total,int[] numbers){
        boolean result = false;
        int j = i;
        int counter = 0;
        while(!result && j<numbers.length){
            counter = counter + numbers[j];
            if(counter==total){
                result = true;
            }
            j++;
        }
    return result;
    }
}
