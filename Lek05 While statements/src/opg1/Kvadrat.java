package opg1;

public class Kvadrat {
    void main() {
        int limit = Integer.parseInt(IO.readln());
        int total1 = kvadratCounter(limit);
        IO.println("The total is: " + total1);
    }

    public int kvadratCounter(int limit) {
        int sum = 0;
        int i = 1;

        while (i * i <= limit) {
            sum = sum + (i * i);
            i++;
            IO.println("i: " + i);
            IO.println("Sum: " + sum);


        }
        return sum;
    }
}
