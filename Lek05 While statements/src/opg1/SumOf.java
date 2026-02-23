package opg1;

public class SumOf {
    void main() {
        int total = counter();
        IO.println(total);
    }

    public int counter() {
        int sum = 0;
        int i = 2;

        while (i < 100) {
            sum = sum + i;
            i = i + 2;

        }
        return sum;
    }
}

