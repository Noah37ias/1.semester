package opg2;

public class SumOfArrayNumbers {
    void main(){
        int[] liste = {4,6,7,2,3};
        int result  = sum(liste);
        IO.println(result);
        int result2  = sum2(liste);
        IO.println(result2);
    }
    public int sum(int[]t){
        int total = 0;
    for(int i = 0; i<t.length;i++){
    total = t[i] + total;
    }
    return total;
    }
    int total2 = 0;
    public int sum2(int[]t){
        for(int element : t){
            total2 = element + total2;
        }
        return total2;
    }
}
