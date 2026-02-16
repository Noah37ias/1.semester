package opg1;

public class opg1 {
    void main() {
        int total = counter();
        IO.println(total);
    }

    public int counter() {
        int sum = 0;
        int i = 2;

        for (i=2;i < 100;i=i+2){
            sum = sum + i;

        }
        return sum;
    }
}

