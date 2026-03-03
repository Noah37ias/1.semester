package opg5;

public class ArrayCheck {
    void main(){
    //int[] a = new int[5];
    //int[] b = new int[a.length];
    int[] a = {1,2,3};
    int[] b = {1,2,3};
    if(equal(a,b)) IO.println("The two arrays are in order");
    else IO.println("The two arrays are not in order");

    }
    public boolean equal(int []a,int []b){
        for(int i=0;i<a.length;i++){
        if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
